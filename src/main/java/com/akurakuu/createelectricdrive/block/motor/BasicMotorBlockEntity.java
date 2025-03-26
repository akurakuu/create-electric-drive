package com.akurakuu.createelectricdrive.block.motor;

import com.akurakuu.createelectricdrive.TierUtil;
import com.akurakuu.createelectricdrive.block.motor.abstractmotor.AbstractMotorBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class BasicMotorBlockEntity extends AbstractMotorBlockEntity {
    public BasicMotorBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(TierUtil.Tier.Basic, type, pos, state);
    }
}
