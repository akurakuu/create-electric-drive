package com.akurakuu.create_electric_drive.block.motor;

import com.akurakuu.create_electric_drive.Entity;
import com.akurakuu.create_electric_drive.TierUtil;
import com.akurakuu.create_electric_drive.block.motor.abstractmotor.AbstractMotorBlock;
import com.akurakuu.create_electric_drive.block.motor.abstractmotor.AbstractMotorBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class UltimateMotorBlock extends AbstractMotorBlock {
    public UltimateMotorBlock(Properties properties) {
        super(TierUtil.Tier.Ultimate, properties);
    }

    @Override
    public BlockEntityType<? extends AbstractMotorBlockEntity> getBlockEntityType() {
        return Entity.ULTIMATE_MOTOR.get();
    }
}
