package com.akurakuu.create_electric_drive.payload.capability;

import com.akurakuu.create_electric_drive.CreateElectricDrive;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.handling.DirectionalPayloadHandler;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import org.jetbrains.annotations.NotNull;

public class CapabilityPayload {
    @SubscribeEvent
    public static void register(final @NotNull RegisterPayloadHandlersEvent event) {
        final PayloadRegistrar registrar = event.registrar("create_electric_drive:capability");
        registrar.playBidirectional(
                CapabilityPayload.Capacity.TYPE,
                CapabilityPayload.Capacity.CODEC,
                new DirectionalPayloadHandler<>(
                        ClientPayloadHandler::handleDataOnMain,
                        ServerPayloadHandler::handleDataOnMain
                )
        );
    }

    public record Capacity(
            int getX,
            int getY,
            int getZ,
            int capacity
    ) implements CustomPacketPayload {
        public static final CustomPacketPayload.Type<Capacity> TYPE = new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath(CreateElectricDrive.MODID, "capability"));

        public static final StreamCodec<ByteBuf, Capacity> CODEC = StreamCodec.composite(
                ByteBufCodecs.INT,
                Capacity::getX,
                ByteBufCodecs.INT,
                Capacity::getY,
                ByteBufCodecs.INT,
                Capacity::getZ,
                ByteBufCodecs.INT,
                Capacity::capacity,
                Capacity::new
        );
        @Override
        public Type<? extends CustomPacketPayload> type() {
            return TYPE;
        }
    }
}
