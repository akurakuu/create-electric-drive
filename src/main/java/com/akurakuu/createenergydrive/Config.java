package com.akurakuu.createenergydrive;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

import java.util.ArrayList;
import java.util.List;

// An example config class. This is not required, but it's a good idea to have one to keep your config organized.
// Demonstrates how to use Neo's config APIs
@EventBusSubscriber(modid = CreateEnergyDrive.MODID, bus = EventBusSubscriber.Bus.MOD)
public class Config {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    // コンフィグのキーとコメントで使う文字列
    public static final MotorTier<String> TIERS = new MotorTier<>(
            "Basic",
            "Enhanced",
            "Advanced",
            "Innovative",
            "Ultimate"
    );

    // 設定のリスト（設定用）
    private static final List<ModConfigSpec.IntValue> PRODUCED_STRESS_CONFIG = new ArrayList<>();
    private static final List<ModConfigSpec.IntValue> CONSUMED_ENERGY_CONFIG  = new ArrayList<>();
    private static final List<ModConfigSpec.IntValue> MAX_CAPACITY_CONFIG  = new ArrayList<>();
    private static final List<ModConfigSpec.IntValue> MAX_RECEIVE_CONFIG  = new ArrayList<>();

    // 設定のデフォルト値
    private static final List<Integer> PRODUCED_STRESS_DEFAULTS = List.of(16, 32, 64, 128, 256);
    private static final List<Integer> CONSUMED_ENERGY_DEFAULTS = List.of(128, 256, 512, 1024, 2048);
    private static final List<Integer> MAX_CAPACITY_DEFAULTS = List.of(1024, 2048, 4096, 8192, 16384);
    private static final List<Integer> MAX_RECEIVE_DEFAULTS = List.of(256, 512, 1024, 2048, 4096);

    // 設定
    static {
        List<String> tiers = TIERS.toList();
        for (int i = 0; i < tiers.size(); i++) {
            String tier = tiers.get(i);
            PRODUCED_STRESS_CONFIG.add(
                    BUILDER
                            .comment(tier + ": Stress produced at rotational speed 1")
                            .defineInRange("producedStress" + tier, PRODUCED_STRESS_DEFAULTS.get(i), 0, Integer.MAX_VALUE)
            );
            CONSUMED_ENERGY_CONFIG.add(
                    BUILDER
                            .comment(tier + ": Energy consumed per tick at rotational speed 1")
                            .defineInRange("consumedEnergy" + tier, CONSUMED_ENERGY_DEFAULTS.get(i), 0, Integer.MAX_VALUE)
            );
            MAX_CAPACITY_CONFIG.add(
                    BUILDER
                            .comment(tier + ": Maximum capacity of the motor (required consumedEnergy or more)")
                            .defineInRange("maxCapacity" + tier, MAX_CAPACITY_DEFAULTS.get(i), 0, Integer.MAX_VALUE)
            );
            MAX_RECEIVE_CONFIG.add(
                    BUILDER
                            .comment(tier + ": Maximum energy transfer per tick to the motor (required consumedEnergy or more)")
                            .defineInRange("maxReceive" + tier, MAX_RECEIVE_DEFAULTS.get(i), 0, Integer.MAX_VALUE)
            );
        }
    }

    static final ModConfigSpec SPEC = BUILDER.build();

    // 取得された設定
    public static class motorConfig {
        public static MotorTier<Integer> producedStress;
        public static MotorTier<Integer> consumedEnergyBasic;
        public static MotorTier<Integer> maxCapacityBasic;
        public static MotorTier<Integer> maxReceiveBasic;
    }


    @SubscribeEvent
    static void onLoad(final ModConfigEvent event) {
        // 設定の取得
        List<Integer> list = new ArrayList<>();

        for (ModConfigSpec.IntValue value : PRODUCED_STRESS_CONFIG) {
            list.add(value.get());
        }
        motorConfig.producedStress = MotorTier.ofList(list);

        list.clear();

        for (ModConfigSpec.IntValue value : CONSUMED_ENERGY_CONFIG) {
            list.add(value.get());
        }
        motorConfig.consumedEnergyBasic = MotorTier.ofList(list);

        list.clear();

        for (ModConfigSpec.IntValue value : MAX_CAPACITY_CONFIG) {
            list.add(value.get());
        }
        motorConfig.maxCapacityBasic = MotorTier.ofList(list);

        list.clear();

        for (ModConfigSpec.IntValue value : MAX_RECEIVE_CONFIG) {
            list.add(value.get());
        }
        motorConfig.maxReceiveBasic = MotorTier.ofList(list);
    }
}
