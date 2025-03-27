package com.akurakuu.create_electric_drive.block.motor;

import com.akurakuu.create_electric_drive.Entity;
import com.akurakuu.create_electric_drive.TierUtil;
import com.akurakuu.create_electric_drive.block.motor.abstractmotor.AbstractMotorBlock;
import com.akurakuu.create_electric_drive.block.motor.abstractmotor.AbstractMotorBlockEntity;
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
