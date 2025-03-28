package com.akurakuu.create_electric_drive;

import com.tterrag.registrate.util.entry.RegistryEntry;
import it.unimi.dsi.fastutil.objects.ReferenceArrayList;
import it.unimi.dsi.fastutil.objects.ReferenceLinkedOpenHashSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.List;


import static com.akurakuu.create_electric_drive.CreateElectricDrive.MODID;
import static com.akurakuu.create_electric_drive.CreateElectricDrive.REGISTRATE;

public class AllCreateModeTabs {
    private static final DeferredRegister<CreativeModeTab> TAB_REGISTER = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    // Creates a creative tab with the id "create_electric_drive:example_tab" for the example item, that is placed after the combat tab
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MAIN_TAB = TAB_REGISTER.register("main",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.create_electric_drive.title")) //The language key for the title of your CreativeModeTab
                    .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
                    .icon(AllItems.ADVANCED_COIL::asStack)
                    //           .displayItems(new RegistrateDisplayItemsGenerator(true, CreateModeTab.MAIN_TAB))
                    .build());

    public static void register(IEventBus event) {
        TAB_REGISTER.register(event);
    }

    public static class RegistrateDisplayItemsGenerator implements CreativeModeTab.DisplayItemsGenerator {
        private final boolean addItems;
        private final DeferredHolder<CreativeModeTab, CreativeModeTab> tab;


        public RegistrateDisplayItemsGenerator(boolean addItems, DeferredHolder<CreativeModeTab, CreativeModeTab> tab) {
            this.addItems = addItems;
            this.tab = tab;
        }

        private List<Item> collectBlocks(DeferredHolder<CreativeModeTab, CreativeModeTab> tab/*, Predicate<Item> predicate*/) {
            List<Item> items = new ReferenceArrayList<>();

            for (RegistryEntry<Block, Block> block : REGISTRATE.getAll(Registries.BLOCK)) {
                if (REGISTRATE.isInCreativeTab(block, tab)) {
                    System.out.println("continued");
                    continue;
                }

                Item item = block.get().asItem();

                if (item == Items.AIR) {
                    continue;
                }

//                if (!predicate.test(item)) {
                items.add(item);
//                }
            }

            items = new ReferenceArrayList<>(new ReferenceLinkedOpenHashSet<>(items));

            return items;
        }

        @Override
        public void accept(CreativeModeTab.ItemDisplayParameters itemDisplayParameters, CreativeModeTab.Output output) {
            List<Item> items = new ArrayList<>();
//            items.addAll(collectBlocks(MAIN_TAB));


            for (Item item : items) {
                output.accept(item);
            }
        }
    }
}
