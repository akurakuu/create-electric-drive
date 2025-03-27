package com.akurakuu.create_electric_drive.block.motor;

import com.akurakuu.create_electric_drive.TierUtil;
import com.akurakuu.create_electric_drive.block.motor.abstractmotor.AbstractMotorBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class InnovativeMotorBlockEntity extends AbstractMotorBlockEntity {
    public InnovativeMotorBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(TierUtil.Tier.Innovative, type, pos, state);
    }
}
