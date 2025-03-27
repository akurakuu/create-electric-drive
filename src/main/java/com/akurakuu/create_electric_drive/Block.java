package com.akurakuu.create_electric_drive;

import com.akurakuu.create_electric_drive.block.motor.*;
import com.simibubi.create.AllBlocks;
import com.tterrag.registrate.util.entry.BlockEntry;

import static com.simibubi.create.foundation.data.ModelGen.customItemModel;

import static com.akurakuu.create_electric_drive.CreateElectricDrive.REGISTRATE;

public class Block {
    static {
        REGISTRATE.setCreativeTab(CreateElectricDrive.MAIN_TAB);
    }

    public static final BlockEntry<BasicMotorBlock> BASIC_MOTOR = REGISTRATE.block(
                    "basic_motor",
                    BasicMotorBlock::new
            )
            .item()
            .build()
            .register();

    public static final BlockEntry<AdvancedMotorBlock> ADVANCED_MOTOR = REGISTRATE.block(
                    "advanced_motor",
//                    MotorBlock::new
                    AdvancedMotorBlock::new
            )
            .item()
            .build()
            .register();

    public static final BlockEntry<InnovativeMotorBlock> INNOVATIVE_MOTOR = REGISTRATE.block(
                    "innovative_motor",
//                    MotorBlock::new
                    InnovativeMotorBlock::new
            )
            .item()
            .build()
            .register();

    public static final BlockEntry<UltimateMotorBlock> ULTIMATE_MOTOR = REGISTRATE.block(
                    "ultimate_motor",
//                    MotorBlock::new
                    UltimateMotorBlock::new
            )
            .item()
            .build()
            .register();

    public static void register() {

    }
}
