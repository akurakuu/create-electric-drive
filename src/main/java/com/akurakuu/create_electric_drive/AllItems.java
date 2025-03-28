package com.akurakuu.create_electric_drive;

import com.tterrag.registrate.util.entry.ItemEntry;

import static com.akurakuu.create_electric_drive.CreateElectricDrive.REGISTRATE;

public class AllItems {
    static {
        REGISTRATE.setCreativeTab(AllCreateModeTabs.MAIN_TAB);
    }

    public static final ItemEntry<net.minecraft.world.item.Item> BASIC_COIL = REGISTRATE.item(
                    "basic_coil",
                    net.minecraft.world.item.Item::new
            )
            .register();

    public static final ItemEntry<net.minecraft.world.item.Item> ADVANCED_COIL = REGISTRATE.item(
                    "advanced_coil",
                    net.minecraft.world.item.Item::new
            )
            .register();

    public static final ItemEntry<net.minecraft.world.item.Item> INNOVATIVE_COIL = REGISTRATE.item(
                    "innovative_coil",
                    net.minecraft.world.item.Item::new
            )
            .register();

    public static final ItemEntry<net.minecraft.world.item.Item> ULTIMATE_MOTOR = REGISTRATE.item(
                    "ultimate_coil",
                    net.minecraft.world.item.Item::new
            )
            .register();

    public static final ItemEntry<net.minecraft.world.item.Item> ULTIMATE_SHEET = REGISTRATE.item(
                    "ultimate_sheet",
                    net.minecraft.world.item.Item::new
            )
            .register();

    public static void register() {

    }
}
