package com.akurakuu.createenergydrive;

import com.akurakuu.createenergydrive.blocks.motor.AbstractMotorBlock;
import com.tterrag.registrate.util.entry.BlockEntry;

import static com.simibubi.create.foundation.data.ModelGen.customItemModel;

import static com.akurakuu.createenergydrive.CreateEnergyDrive.REGISTRATE;

public class Blocks {
    static {
        REGISTRATE.setCreativeTab(CreateEnergyDrive.MAIN_TAB);
    }

    public static final BlockEntry<AbstractMotorBlock> BASIC_MOTOR = REGISTRATE.block(
                    "basic_motor",
//                    MotorBlock::new
                    properties -> new AbstractMotorBlock(properties)
            )
            .item()
            .transform(customItemModel())
            .register();

    public static final BlockEntry<AbstractMotorBlock> ENHANCED_MOTOR = REGISTRATE.block(
                    "enhanced_motor",
//                    MotorBlock::new
                    properties -> new AbstractMotorBlock(properties)
            )
            .item()
            .transform(customItemModel())
            .register();

    public static final BlockEntry<AbstractMotorBlock> ADVANCED_MOTOR = REGISTRATE.block(
                    "advanced_motor",
//                    MotorBlock::new
                    properties -> new AbstractMotorBlock(properties)
            )
            .item()
            .transform(customItemModel())
            .register();

    public static final BlockEntry<AbstractMotorBlock> INNOVATIVE_MOTOR = REGISTRATE.block(
                    "innovative_motor",
//                    MotorBlock::new
                    properties -> new AbstractMotorBlock(properties)
            )
            .item()
            .transform(customItemModel())
            .register();

    public static final BlockEntry<AbstractMotorBlock> TRANSCENDENT_MOTOR = REGISTRATE.block(
                    "ultimate_motor",
//                    MotorBlock::new
                    properties -> new AbstractMotorBlock(properties)
            )
            .item()
            .transform(customItemModel())
            .register();

    public static void register() {

    }
}
