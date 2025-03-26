package com.akurakuu.createelectricdrive.block.motor;

import com.akurakuu.createelectricdrive.Entity;
import com.akurakuu.createelectricdrive.TierUtil;
import com.akurakuu.createelectricdrive.block.motor.abstractmotor.AbstractMotorBlock;
import com.akurakuu.createelectricdrive.block.motor.abstractmotor.AbstractMotorBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class EnhancedMotorBlock extends AbstractMotorBlock {
    public EnhancedMotorBlock(Properties properties) {
        super(TierUtil.Tier.Enhanced, properties);
    }

    @Override
    public BlockEntityType<? extends AbstractMotorBlockEntity> getBlockEntityType() {
        return Entity.ENHANCED_MOTOR.get();
    }
}
