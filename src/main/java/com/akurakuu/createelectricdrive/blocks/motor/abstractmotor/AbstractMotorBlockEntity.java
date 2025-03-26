package com.akurakuu.createelectricdrive.blocks.motor.abstractmotor;

import com.akurakuu.createelectricdrive.TierUtil;
import com.simibubi.create.content.kinetics.base.GeneratingKineticBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class AbstractMotorBlockEntity extends GeneratingKineticBlockEntity {
    public static final int DEFAULT_SPEED = 16;
    public static final int MAX_SPEED = 256;

    private final TierUtil.Tier motorTier;

    public AbstractMotorBlockEntity(TierUtil.Tier motorTier, BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
        this.motorTier = motorTier;
    }
}
