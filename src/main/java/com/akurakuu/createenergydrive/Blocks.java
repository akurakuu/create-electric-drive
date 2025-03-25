package com.akurakuu.createenergydrive;

import com.akurakuu.createenergydrive.blocks.motor.MotorBlock;
import com.simibubi.create.Create;
import com.tterrag.registrate.util.entry.BlockEntry;

import static com.simibubi.create.foundation.data.ModelGen.customItemModel;

import static com.akurakuu.createenergydrive.CreateEnergyDrive.REGISTRATE;

public class Blocks {
    static {
        REGISTRATE.setCreativeTab(CreateEnergyDrive.MAIN_TAB);
    }

    public static final BlockEntry<MotorBlock> BASIC_MOTOR = REGISTRATE.block(
                    "basic_motor",
//                    MotorBlock::new
                    properties -> new MotorBlock(properties)
            )
            .item()
            .transform(customItemModel())
            .register();

    public static final BlockEntry<MotorBlock> ENHANCED_MOTOR = REGISTRATE.block(
                    "enhanced_motor",
//                    MotorBlock::new
                    properties -> new MotorBlock(properties)
            )
            .item()
            .transform(customItemModel())
            .register();

    public static final BlockEntry<MotorBlock> ADVANCED_MOTOR = REGISTRATE.block(
                    "advanced_motor",
//                    MotorBlock::new
                    properties -> new MotorBlock(properties)
            )
            .item()
            .transform(customItemModel())
            .register();

    public static final BlockEntry<MotorBlock> INNOVATIVE_MOTOR = REGISTRATE.block(
                    "innovative_motor",
//                    MotorBlock::new
                    properties -> new MotorBlock(properties)
            )
            .item()
            .transform(customItemModel())
            .register();

    public static final BlockEntry<MotorBlock> TRANSCENDENT_MOTOR = REGISTRATE.block(
                    "ultimate_motor",
//                    MotorBlock::new
                    properties -> new MotorBlock(properties)
            )
            .item()
            .transform(customItemModel())
            .register();

    public static void register() {

    }
}
