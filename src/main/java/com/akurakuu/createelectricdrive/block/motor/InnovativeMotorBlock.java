package com.akurakuu.createelectricdrive.block.motor;

import com.akurakuu.createelectricdrive.Entity;
import com.akurakuu.createelectricdrive.TierUtil;
import com.akurakuu.createelectricdrive.block.motor.abstractmotor.AbstractMotorBlock;
import com.akurakuu.createelectricdrive.block.motor.abstractmotor.AbstractMotorBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class InnovativeMotorBlock extends AbstractMotorBlock {
    public InnovativeMotorBlock(Properties properties) {
        super(TierUtil.Tier.Innovative, properties);
    }

    @Override
    public BlockEntityType<? extends AbstractMotorBlockEntity> getBlockEntityType() {
        return Entity.INNOVATIVE_MOTOR.get();
    }
}
