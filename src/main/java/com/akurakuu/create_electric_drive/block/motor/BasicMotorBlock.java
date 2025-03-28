package com.akurakuu.create_electric_drive.block.motor;

import com.akurakuu.create_electric_drive.AllEntities;
import com.akurakuu.create_electric_drive.TierUtil;
import com.akurakuu.create_electric_drive.block.motor.abstractmotor.AbstractMotorBlock;
import com.akurakuu.create_electric_drive.block.motor.abstractmotor.AbstractMotorBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class BasicMotorBlock extends AbstractMotorBlock {
    public BasicMotorBlock(Properties properties) {
        super(TierUtil.Tier.Basic, properties);
    }

    @Override
    public BlockEntityType<? extends AbstractMotorBlockEntity> getBlockEntityType() {
        return AllEntities.BASIC_MOTOR.get();
    }
}
