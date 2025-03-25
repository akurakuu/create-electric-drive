package com.akurakuu.createenergydrive;

import com.akurakuu.createenergydrive.blocks.motor.MotorBlockEntity;
import com.simibubi.create.AllPartialModels;
import com.simibubi.create.content.kinetics.base.KineticBlockEntity;
import com.simibubi.create.content.kinetics.base.OrientedRotatingVisual;
import com.tterrag.registrate.util.entry.BlockEntityEntry;

import static com.akurakuu.createenergydrive.CreateEnergyDrive.REGISTRATE;

public class Entities {
    public static final BlockEntityEntry<MotorBlockEntity> BASIC_MOTOR = REGISTRATE
            .blockEntity("basic_motor",
                    MotorBlockEntity::new
            )
            .visual(() -> OrientedRotatingVisual.of(AllPartialModels.SHAFT_HALF), false)
            .validBlocks(Blocks.BASIC_MOTOR)
            .register();

    public static void register() {

    }
}
