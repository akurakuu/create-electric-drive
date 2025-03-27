package com.akurakuu.create_electric_drive.capability;

import com.akurakuu.create_electric_drive.Block;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;

public class Capability {
    @SubscribeEvent
    public static void registerCapabilities(RegisterCapabilitiesEvent event) {
//        ExampleMod.LOGGER.debug("Registering Capability_: {}", Blocks.MOTOR.get().getBlockEntityType());
        event.registerBlockEntity(
                Capabilities.EnergyStorage.BLOCK,
                Block.BASIC_MOTOR.get().getBlockEntityType(),
                (object, context) -> {
//                    ExampleMod.LOGGER.debug("Registering Capability:\n{} {}", object.hashCode(), Blocks.MOTOR.get().getBlockEntityType().hashCode());
                    return object.getCapability();
                }
        );
        event.registerBlockEntity(
                Capabilities.EnergyStorage.BLOCK,
                Block.ADVANCED_MOTOR.get().getBlockEntityType(),
                (object, context) -> {
//                    ExampleMod.LOGGER.debug("Registering Capability:\n{} {}", object.hashCode(), Blocks.MOTOR.get().getBlockEntityType().hashCode());
                    return object.getCapability();
                }
        );
        event.registerBlockEntity(
                Capabilities.EnergyStorage.BLOCK,
                Block.INNOVATIVE_MOTOR.get().getBlockEntityType(),
                (object, context) -> {
//                    ExampleMod.LOGGER.debug("Registering Capability:\n{} {}", object.hashCode(), Blocks.MOTOR.get().getBlockEntityType().hashCode());
                    return object.getCapability();
                }
        );
        event.registerBlockEntity(
                Capabilities.EnergyStorage.BLOCK,
                Block.ULTIMATE_MOTOR.get().getBlockEntityType(),
                (object, context) -> {
//                    ExampleMod.LOGGER.debug("Registering Capability:\n{} {}", object.hashCode(), Blocks.MOTOR.get().getBlockEntityType().hashCode());
                    return object.getCapability();
                }
        );
    }
}

