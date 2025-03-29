package com.akurakuu.create_electric_drive.block.motor.abstractmotor;

import com.akurakuu.create_electric_drive.Config;
import com.akurakuu.create_electric_drive.TierUtil;
import com.akurakuu.create_electric_drive.block.BlockCapability;
import com.akurakuu.create_electric_drive.payload.capability.CapabilityPayload;
import com.mojang.blaze3d.vertex.PoseStack;
import com.simibubi.create.content.kinetics.base.GeneratingKineticBlockEntity;
import com.simibubi.create.content.kinetics.motor.KineticScrollValueBehaviour;
import com.simibubi.create.foundation.blockEntity.behaviour.BlockEntityBehaviour;
import com.simibubi.create.foundation.blockEntity.behaviour.ValueBoxTransform;
import com.simibubi.create.foundation.utility.CreateLang;
import com.simibubi.create.foundation.blockEntity.behaviour.scrollValue.ScrollValueBehaviour;
import dev.engine_room.flywheel.lib.transform.TransformStack;
import net.createmod.catnip.math.AngleHelper;
import net.createmod.catnip.math.VecHelper;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.network.PacketDistributor;

import java.util.List;
import java.util.Objects;

public class AbstractMotorBlockEntity extends GeneratingKineticBlockEntity {
    public static final int DEFAULT_SPEED = 16;
    public static final int MAX_SPEED = 256;

    protected ScrollValueBehaviour generatedSpeed;
    private final TierUtil.Tier motorTier;
    private final BlockCapability energyStorage;
    private boolean isActive = false;

    public AbstractMotorBlockEntity(TierUtil.Tier motorTier, BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
        this.motorTier = motorTier;
        this.energyStorage = new BlockCapability(
                Config.motorConfig.maxCapacity.getFromTier(motorTier),
                Config.motorConfig.maxReceive.getFromTier(motorTier),
                Config.motorConfig.maxReceive.getFromTier(motorTier),
                true,
                false
        );
    }

    @Override
    public void initialize() {
        super.initialize();

//        CreateElectricDrive.LOGGER.debug("Initialize: {} {}", this.hashCode(), Blocks.MOTOR.get().getBlockEntityType().hashCode());

        if (!hasSource() || getGeneratedSpeed() > getTheoreticalSpeed()) {
            updateGeneratedRotation();
        }
    }

    @Override
    public float getGeneratedSpeed() {
//        if (!Block.MOTOR.has(getBlockState())) {
//            return 0;
//        }

        return convertToDirection(isActive ? generatedSpeed.getValue() : 0, getBlockState().getValue(AbstractMotorBlock.FACING));
    }

    @Override
    public float calculateAddedStressCapacity() {
        return Config.motorConfig.producedStress.getFromTier(motorTier);
    }

    public int calculateEnergyConsumption() {
        return Math.abs(Config.motorConfig.consumedEnergy.getFromTier(motorTier) * generatedSpeed.getValue());
    }

    public void setCapability(int capability) {
        energyStorage.setEnergy(capability);
    }

    public BlockCapability getCapability() {
//        CreateElectricDrive.LOGGER.debug("Get Capability: {} {}", this.hashCode(), Blocks.MOTOR.get().getBlockEntityType().hashCode());
        return energyStorage;
    }

    @Override
    public void addBehaviours(List<BlockEntityBehaviour> behaviours) {
//        super.addBehaviours(behaviours);
//
//        CenteredSideValueBoxTransform slot = new CenteredSideValueBoxTransform((motor, side) -> !(motor.getValue(MotorBlock.FACING) == side.getOpposite() || motor.getValue(MotorBlock.FACING) == side));
////        ValueBox
//
//        generatedSpeed = new KineticScrollValueBehaviour(CreateLang.translateDirect("generic.speed"), this, slot);
//        generatedSpeed.between(-MAX_SPEED, MAX_SPEED);
//        generatedSpeed.value = DEFAULT_SPEED;
//        generatedSpeed.withCallback(i -> this.updateGeneratedRotation());
//        behaviours.add(generatedSpeed);

        super.addBehaviours(behaviours);
        int max = MAX_SPEED;
        generatedSpeed = new KineticScrollValueBehaviour(CreateLang.translateDirect("kinetics.creative_motor.rotation_speed"),
                this, new MotorValueBox());
        generatedSpeed.between(-max, max);
        generatedSpeed.value = DEFAULT_SPEED;
        generatedSpeed.withCallback(i -> this.updateGeneratedRotation());
        behaviours.add(generatedSpeed);
    }

    @Override
    public boolean addToGoggleTooltip(List<Component> tooltip, boolean isPlayerSneaking) {
        super.addToGoggleTooltip(tooltip, isPlayerSneaking);

        String space = "    ";
        String nest = " ";
//        tooltip.add(Component.literal(space).append("Generated Speed: ").append(String.valueOf(generatedSpeed.getValue())));
//        tooltip.add(Component.literal(space).append("Can I / Can O: ").append(String.valueOf(energyStorage.canReceive())).append(" / ").append(String.valueOf(energyStorage.canExtract())));
//        tooltip.add(Component.literal(space).append("Capacity / Current: ").append(String.valueOf(energyStorage.getMaxEnergyStored())).append(" / ").append(String.valueOf(energyStorage.getEnergyStored())));
//        tooltip.add(Component.literal(space).append("Energy Consumption: ").append(String.valueOf(calculateEnergyConsumption())));

        tooltip.add(Component.literal(space + "Forge Energy Capacity:").withStyle(ChatFormatting.GRAY));
        tooltip.add(Component.literal(space + nest + ChatFormatting.AQUA + energyStorage.getEnergyStored() + "FE" + ChatFormatting.DARK_GRAY + " / " + energyStorage.getMaxEnergyStored() + "FE"));


        return true;
    }

    @Override
    public void tick() {
        super.tick();

        if (!isOverStressed()) {
            updateGeneratedRotation();
        }

        if (isActive) {
            // エネルギーの消費
            if (Objects.nonNull(getLevel())) {
                if (!getLevel().isClientSide() && !isOverStressed()) {
                    energyStorage.consumeEnergy(calculateEnergyConsumption());
                }
            }

            // クライアントと同期
            try {
                ChunkPos chunkPos = new ChunkPos(getBlockPos());
                Level level = getLevel();
                if (Objects.nonNull(level) && !level.isClientSide()) {
                    PacketDistributor.sendToPlayersTrackingChunk(Objects.requireNonNull((ServerLevel) level), chunkPos, new CapabilityPayload.Capacity(
                            getBlockPos().getX(),
                            getBlockPos().getY(),
                            getBlockPos().getZ(),
                            energyStorage.getEnergyStored()
                    ));
                }
            } catch (NullPointerException e) {
//                ExampleMod.LOGGER.warn("sendToAllPlayers NullPointerException: \n{}", String.valueOf(e));
            }
        }

        isActive = energyStorage.getEnergyStored() > 0;
    }

    class MotorValueBox extends ValueBoxTransform.Sided {
        @Override
        protected Vec3 getSouthLocation() {
//            return VecHelper.voxelSpace(9, 8, 14);
            return VecHelper.voxelSpace(8, 8, 12.5);
//            return VecHelper.voxelSpace(8, 8, 16);
        }

        @Override
        public Vec3 getLocalOffset(LevelAccessor level, BlockPos pos, BlockState state) {
            Direction facing = state.getValue(AbstractMotorBlock.FACING);
            return super.getLocalOffset(level, pos, state).add(Vec3.atLowerCornerOf(facing.getNormal())
                    .scale(-1 / 16f));
        }

        @Override
        public void rotate(LevelAccessor level, BlockPos pos, BlockState state, PoseStack ms) {
            super.rotate(level, pos, state, ms);
            Direction facing = state.getValue(AbstractMotorBlock.FACING);
            if (facing.getAxis() == Direction.Axis.Y)
                return;
            if (getSide() != Direction.UP)
                return;
            TransformStack.of(ms)
                    .rotateZDegrees(-AngleHelper.horizontalAngle(facing) + 180);
        }

        @Override
        protected boolean isSideActive(BlockState state, Direction direction) {
            return state.getValue(AbstractMotorBlock.FACING).getAxis() != direction.getAxis();
        }
    }
}
