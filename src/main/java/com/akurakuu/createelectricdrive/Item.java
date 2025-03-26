package com.akurakuu.createelectricdrive;

import com.tterrag.registrate.util.entry.ItemEntry;

import static com.akurakuu.createelectricdrive.CreateElectricDrive.REGISTRATE;

public class Item {
    public static final ItemEntry<net.minecraft.world.item.Item> BASIC_COIL = REGISTRATE.item(
                    "basic_coil",
                    net.minecraft.world.item.Item::new
            )
            .register();

    public static final ItemEntry<net.minecraft.world.item.Item> ENHANCED_COIL = REGISTRATE.item(
                    "enhanced_coil",
                    net.minecraft.world.item.Item::new
            )
            .register();

    public static void register() {

    }
}
