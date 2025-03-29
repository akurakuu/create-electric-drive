package com.akurakuu.create_electric_drive;

import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

import static com.akurakuu.create_electric_drive.CreateElectricDrive.REGISTRATE;

public class AllItems {
    static {
        REGISTRATE.setCreativeTab(AllCreateModeTabs.MAIN_TAB);
    }

    public static final ItemEntry<Item> BASIC_COIL = REGISTRATE.item(
                    "basic_coil",
                    Item::new
            )
            .register();

    public static final ItemEntry<Item> ADVANCED_COIL = REGISTRATE.item(
                    "advanced_coil",
                    Item::new
            )
            .register();

    public static final ItemEntry<Item> INNOVATIVE_COIL = REGISTRATE.item(
                    "innovative_coil",
                    Item::new
            )
            .register();

    public static final ItemEntry<Item> ULTIMATE_MOTOR = REGISTRATE.item(
                    "ultimate_coil",
                    Item::new
            )
            .properties(p -> p.rarity(Rarity.RARE))
            .register();

    public static final ItemEntry<Item> HOT_STURDY_SHEET = REGISTRATE.item(
                    "hot_sturdy_sheet",
                    Item::new
            )
            .register();

    public static final ItemEntry<Item> ULTIMATE_SHEET = REGISTRATE.item(
                    "ultimate_sheet",
                    Item::new
            )
            .properties(p -> p.rarity(Rarity.RARE))
            .register();

    public static void register() {

    }
}
