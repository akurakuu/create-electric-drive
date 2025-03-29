package com.akurakuu.create_electric_drive;

import com.akurakuu.create_electric_drive.block.motor.*;
import com.simibubi.create.content.contraptions.actors.harvester.HarvesterBlock;
import com.simibubi.create.content.decoration.encasing.CasingBlock;
import com.simibubi.create.foundation.data.BlockStateGen;
import com.simibubi.create.foundation.data.SharedProperties;
import com.simibubi.create.infrastructure.config.CStress;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredHolder;

import static com.simibubi.create.foundation.data.TagGen.axeOnly;
import static com.simibubi.create.foundation.data.TagGen.axeOrPickaxe;
import static com.simibubi.create.foundation.data.TagGen.pickaxeOnly;
import static com.simibubi.create.foundation.data.TagGen.tagBlockAndItem;

import static com.simibubi.create.foundation.data.ModelGen.customItemModel;

import static com.akurakuu.create_electric_drive.CreateElectricDrive.REGISTRATE;

public class AllBlocks {
    static {
        REGISTRATE.setCreativeTab(AllCreateModeTabs.MAIN_TAB);
    }

    public static final BlockEntry<BasicMotorBlock> BASIC_MOTOR = REGISTRATE.block(
                    "basic_motor",
                    BasicMotorBlock::new
            )
            .initialProperties(SharedProperties::softMetal)
            .transform(axeOrPickaxe())
            .simpleItem()
            .register();

    public static final BlockEntry<AdvancedMotorBlock> ADVANCED_MOTOR = REGISTRATE.block(
                    "advanced_motor",
//                    MotorBlock::new
                    AdvancedMotorBlock::new
            )
            .initialProperties(SharedProperties::softMetal)
            .transform(axeOrPickaxe())
            .simpleItem()
            .register();

    public static final BlockEntry<InnovativeMotorBlock> INNOVATIVE_MOTOR = REGISTRATE.block(
                    "innovative_motor",
//                    MotorBlock::new
                    InnovativeMotorBlock::new
            )
            .initialProperties(SharedProperties::softMetal)
            .transform(pickaxeOnly())
            .simpleItem()
            .register();

    public static final BlockEntry<UltimateMotorBlock> ULTIMATE_MOTOR = REGISTRATE.block(
                    "ultimate_motor",
//                    MotorBlock::new
                    UltimateMotorBlock::new
            )
            .initialProperties(SharedProperties::softMetal)
            .transform(pickaxeOnly())
            .item()
            .properties(p -> p.rarity(Rarity.RARE))
            .build()
            .register();

    public static final BlockEntry<CasingBlock> ULTIMATE_CASING = REGISTRATE.block(
                    "ultimate_casing",
                    CasingBlock::new
            )
            .initialProperties(SharedProperties::softMetal)
            .transform(pickaxeOnly())
            //            .transform(BlockBehaviour::)
            .item()
            .properties(p -> p.rarity(Rarity.RARE))
            .build()
            .register();

    public static void register() {

    }
}
