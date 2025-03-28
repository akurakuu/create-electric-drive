package com.akurakuu.create_electric_drive.capability;

import com.akurakuu.create_electric_drive.AllBlocks;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;

public class Capability {
    @SubscribeEvent
    public static void registerCapabilities(RegisterCapabilitiesEvent event) {
//        ExampleMod.LOGGER.debug("Registering Capability_: {}", Blocks.MOTOR.get().getBlockEntityType());
        event.registerBlockEntity(
                Capabilities.EnergyStorage.BLOCK,
                AllBlocks.BASIC_MOTOR.get().getBlockEntityType(),
                (object, context) -> {
//                    ExampleMod.LOGGER.debug("Registering Capability:\n{} {}", object.hashCode(), Blocks.MOTOR.get().getBlockEntityType().hashCode());
                    return object.getCapability();
                }
        );
        event.registerBlockEntity(
                Capabilities.EnergyStorage.BLOCK,
                AllBlocks.ADVANCED_MOTOR.get().getBlockEntityType(),
                (object, context) -> {
//                    ExampleMod.LOGGER.debug("Registering Capability:\n{} {}", object.hashCode(), Blocks.MOTOR.get().getBlockEntityType().hashCode());
                    return object.getCapability();
                }
        );
        event.registerBlockEntity(
                Capabilities.EnergyStorage.BLOCK,
                AllBlocks.INNOVATIVE_MOTOR.get().getBlockEntityType(),
                (object, context) -> {
//                    ExampleMod.LOGGER.debug("Registering Capability:\n{} {}", object.hashCode(), Blocks.MOTOR.get().getBlockEntityType().hashCode());
                    return object.getCapability();
                }
        );
        event.registerBlockEntity(
                Capabilities.EnergyStorage.BLOCK,
                AllBlocks.ULTIMATE_MOTOR.get().getBlockEntityType(),
                (object, context) -> {
//                    ExampleMod.LOGGER.debug("Registering Capability:\n{} {}", object.hashCode(), Blocks.MOTOR.get().getBlockEntityType().hashCode());
                    return object.getCapability();
                }
        );
    }
}

