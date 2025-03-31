package com.akurakuu.create_electric_drive.block.motor.abstractmotor;

import com.akurakuu.create_electric_drive.CreateElectricDrive;
import com.akurakuu.create_electric_drive.ShapeUtil;
import com.akurakuu.create_electric_drive.TierUtil;
import com.simibubi.create.content.kinetics.base.DirectionalKineticBlock;
import com.simibubi.create.foundation.block.IBE;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class AbstractMotorBlock extends DirectionalKineticBlock implements IBE<AbstractMotorBlockEntity> {
    public static final BooleanProperty POWERED = BlockStateProperties.POWERED;

    public final TierUtil.Tier motorTier;

    private static final ShapeUtil shape = new ShapeUtil(
            Block.box(3, 0, 3, 13, 14, 13),
            Block.box(3, 2, 3, 13, 16, 13),
            Block.box(3, 3, 2, 13, 13, 16),
            Block.box(3, 3, 0, 13, 13, 14),
            Block.box(2, 3, 3, 16, 13, 13),
            Block.box(0, 3, 3, 14, 13, 13)
    );

    public AbstractMotorBlock(TierUtil.Tier motorTier, Properties properties) {
        super(properties);
        this.motorTier = motorTier;
        registerDefaultState(defaultBlockState().setValue(POWERED, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(POWERED);
    }

    @Override
    protected void tick(BlockState state, @NotNull ServerLevel level, @NotNull BlockPos pos, @NotNull RandomSource random) {
        if (state.getValue(POWERED) && !level.hasNeighborSignal(pos)) {
            level.setBlock(pos, state.cycle(POWERED), 2);
        }
    }

    public TierUtil.Tier getMotorTier() {
        return motorTier;
    }

    @Override
    public Direction.Axis getRotationAxis(BlockState state) {
        return state.getValue(FACING).getAxis();
    }

    @Override
    public Class<AbstractMotorBlockEntity> getBlockEntityClass() {
        return AbstractMotorBlockEntity.class;
    }

    @Override
    public BlockEntityType<? extends AbstractMotorBlockEntity> getBlockEntityType() {
        return null;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Direction preferred = getPreferredFacing(context);
        if ((context.getPlayer() != null && context.getPlayer().isShiftKeyDown()) || preferred == null)
            return super.getStateForPlacement(context);
        return defaultBlockState().setValue(FACING, preferred);
    }

    @Override
    public boolean hasShaftTowards(LevelReader world, BlockPos pos, BlockState state, Direction face) {
        return face == state.getValue(FACING);
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {

//        return ShapeUtil.getShape(new ShapeUtil(
//                        Block.box(3, 0, 3, 13, 14, 13),
//                        Block.box(3, 2, 3, 13, 16, 13),
//                        Block.box(3, 3, 2, 13, 13, 16),
//                        Block.box(3, 3, 0, 13, 13, 14),
//                        Block.box(2, 3, 3, 16, 13, 13),
//                        Block.box(0, 3, 3, 14, 13, 13)
//                ),
//                state.getValue(FACING));
        return shape.getShape(state.getValue(FACING));
    }
}
