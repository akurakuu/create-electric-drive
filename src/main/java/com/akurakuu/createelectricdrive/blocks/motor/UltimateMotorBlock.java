package com.akurakuu.createelectricdrive.blocks.motor;

import com.akurakuu.createelectricdrive.Entities;
import com.akurakuu.createelectricdrive.TierUtil;
import com.akurakuu.createelectricdrive.blocks.motor.abstractmotor.AbstractMotorBlock;
import com.akurakuu.createelectricdrive.blocks.motor.abstractmotor.AbstractMotorBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class UltimateMotorBlock extends AbstractMotorBlock {
    public UltimateMotorBlock(Properties properties) {
        super(TierUtil.Tier.Ultimate, properties);
    }

    @Override
    public BlockEntityType<? extends AbstractMotorBlockEntity> getBlockEntityType() {
        return Entities.ULTIMATE_MOTOR.get();
    }
}
