package com.akurakuu.createelectricdrive.blocks.motor;

import com.akurakuu.createelectricdrive.TierUtil;
import com.akurakuu.createelectricdrive.blocks.motor.abstractmotor.AbstractMotorBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class EnhancedMotorBlockEntity extends AbstractMotorBlockEntity {
    public EnhancedMotorBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(TierUtil.Tier.Enhanced, type, pos, state);
    }
}
