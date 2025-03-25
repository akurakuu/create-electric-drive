package com.akurakuu.createenergydrive.blocks.motor;

import com.akurakuu.createenergydrive.Entities;
import com.simibubi.create.content.kinetics.base.DirectionalKineticBlock;
import com.simibubi.create.foundation.block.IBE;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import org.jetbrains.annotations.NotNull;

public class MotorBlock extends DirectionalKineticBlock implements IBE<MotorBlockEntity> {
    public static final BooleanProperty POWERED = BlockStateProperties.POWERED;

    public MotorBlock(Properties properties) {
        super(properties);
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

    @Override
    public Direction.Axis getRotationAxis(BlockState state) {
        return state.getValue(FACING).getOpposite().getAxis();
    }

    @Override
    public Class<MotorBlockEntity> getBlockEntityClass() {
        return MotorBlockEntity.class;
    }

    @Override
    public BlockEntityType<? extends MotorBlockEntity> getBlockEntityType() {
        return Entities.BASIC_MOTOR.get();
    }

    @Override
    public boolean hasShaftTowards(LevelReader world, BlockPos pos, BlockState state, Direction face) {
        return face == state.getValue(FACING);
    }
}
