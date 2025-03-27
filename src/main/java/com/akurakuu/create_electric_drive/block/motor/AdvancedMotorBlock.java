package com.akurakuu.create_electric_drive.block.motor;

import com.akurakuu.create_electric_drive.Entity;
import com.akurakuu.create_electric_drive.TierUtil;
import com.akurakuu.create_electric_drive.block.motor.abstractmotor.AbstractMotorBlock;
import com.akurakuu.create_electric_drive.block.motor.abstractmotor.AbstractMotorBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class AdvancedMotorBlock extends AbstractMotorBlock {
    public AdvancedMotorBlock(Properties properties) {
        super(TierUtil.Tier.Advanced, properties);
    }

    @Override
    public BlockEntityType<? extends AbstractMotorBlockEntity> getBlockEntityType() {
        return Entity.ADVANCED_MOTOR.get();
    }
}
