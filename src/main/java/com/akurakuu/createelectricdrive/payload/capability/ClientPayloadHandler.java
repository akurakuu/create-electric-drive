package com.akurakuu.createelectricdrive.payload.capability;

import com.akurakuu.createelectricdrive.block.motor.abstractmotor.AbstractMotorBlockEntity;
import net.minecraft.core.BlockPos;
import net.neoforged.neoforge.network.handling.IPayloadContext;

import java.util.Objects;

public class ClientPayloadHandler {
    public static void handleDataOnMain(final CapabilityPayload.Capacity data, final IPayloadContext context) {
//        ExampleMod.LOGGER.debug("[CLIENT] handleDataOnMain: {}", data.capacity());

        BlockPos targetPos = new BlockPos(data.getX(), data.getY(), data.getZ());
        AbstractMotorBlockEntity block = (AbstractMotorBlockEntity) context.player().level().getBlockEntity(targetPos);

        // エネルギー同期
        if (Objects.nonNull(block)) {
//            ExampleMod.LOGGER.debug("[CLIENT] block: {}", block);
            block.setCapability(data.capacity());
        } else {
//            ExampleMod.LOGGER.warn("[CLIENT] block is null");
        }
    }
}
