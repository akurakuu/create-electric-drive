package com.akurakuu.create_electric_drive;

import com.akurakuu.create_electric_drive.block.motor.*;
import com.simibubi.create.AllPartialModels;
import com.simibubi.create.content.kinetics.base.OrientedRotatingVisual;
import com.tterrag.registrate.util.entry.BlockEntityEntry;

import static com.akurakuu.create_electric_drive.CreateElectricDrive.REGISTRATE;

public class Entity {
    public static final BlockEntityEntry<BasicMotorBlockEntity> BASIC_MOTOR = REGISTRATE
            .blockEntity("basic_motor",
                    BasicMotorBlockEntity::new
            )
            .visual(() -> OrientedRotatingVisual.of(AllPartialModels.SHAFT_HALF), false)
            .validBlocks(Block.BASIC_MOTOR)
            .register();

    public static final BlockEntityEntry<AdvancedMotorBlockEntity> ADVANCED_MOTOR = REGISTRATE
            .blockEntity("advanced_motor",
                    AdvancedMotorBlockEntity::new
            )
            .visual(() -> OrientedRotatingVisual.of(AllPartialModels.SHAFT_HALF), false)
            .validBlocks(Block.ADVANCED_MOTOR)
            .register();

    public static final BlockEntityEntry<InnovativeMotorBlockEntity> INNOVATIVE_MOTOR = REGISTRATE
            .blockEntity("innovative_motor",
                    InnovativeMotorBlockEntity::new
            )
            .visual(() -> OrientedRotatingVisual.of(AllPartialModels.SHAFT_HALF), false)
            .validBlocks(Block.INNOVATIVE_MOTOR)
            .register();

    public static final BlockEntityEntry<UltimateMotorBlockEntity> ULTIMATE_MOTOR = REGISTRATE
            .blockEntity("ultimate_motor",
                    UltimateMotorBlockEntity::new
            )
            .visual(() -> OrientedRotatingVisual.of(AllPartialModels.SHAFT_HALF), false)
            .validBlocks(Block.ULTIMATE_MOTOR)
            .register();

    public static void register() {

    }
}
