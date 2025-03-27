package com.akurakuu.create_electric_drive;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

import java.util.ArrayList;
import java.util.List;

// An example config class. This is not required, but it's a good idea to have one to keep your config organized.
// Demonstrates how to use Neo's config APIs
@EventBusSubscriber(modid = CreateElectricDrive.MODID, bus = EventBusSubscriber.Bus.MOD)
public class Config {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    // TODO commentBuilder
    private static final char commentSpace = ' '; // commentSpace

    // コンフィグのキーとコメントで使う文字列
    public static final TierUtil<String> TIERS = new TierUtil<>(
            "Basic",
            "Advanced",
            "Innovative",
            "Ultimate"
    );

    // 設定のリスト（設定用）
    private static final List<ModConfigSpec.IntValue> PRODUCED_STRESS_CONFIG = new ArrayList<>();
    private static final List<ModConfigSpec.IntValue> CONSUMED_ENERGY_CONFIG = new ArrayList<>();
    private static final List<ModConfigSpec.IntValue> MAX_CAPACITY_CONFIG = new ArrayList<>();
    private static final List<ModConfigSpec.IntValue> MAX_RECEIVE_CONFIG = new ArrayList<>();

    // 設定のデフォルト値
    private static final List<Integer> PRODUCED_STRESS_DEFAULTS = List.of(16, 32, 64, 512, 1024);
    private static final List<Integer> CONSUMED_ENERGY_DEFAULTS = List.of(8, 16, 32, 64, 128);
    private static final List<Integer> MAX_CAPACITY_DEFAULTS;
    // MAX_CAPACITY_DEFAULTを、モーターの最大回転速度と回転速度1の時のエネルギー消費量から計算(2倍)
    static {
        List<Integer> tmp = new ArrayList<>();
        for (int i = 0; i < CONSUMED_ENERGY_DEFAULTS.size(); i++) {
            tmp.add(CONSUMED_ENERGY_DEFAULTS.get(i) * 256 * 2);
        }
        MAX_CAPACITY_DEFAULTS = tmp;
    }
    private static final List<Integer> MAX_RECEIVE_DEFAULTS = MAX_CAPACITY_DEFAULTS;

    // 設定
    static {
        List<String> tiers = TIERS.toList();
        BUILDER.comment(
                commentSpace + "Motor Config\n" +
                        commentSpace + "Produced Stress: Stress produced when rotational speed is 1[su]\n" +
                        commentSpace + "Consumed Energy: Energy consumed per tick when rotational speed is 1[su]\n" +
                        commentSpace + "Max Capacity: Maximum capacity of the motor (required consumedEnergy * 256 or more)\n" +
                        commentSpace + "Max Receive: Maximum energy transfer per tick to the motor (required consumedEnergy * 256 or more)\n"
        );

        for (int i = 0; i < tiers.size(); i++) {
            String tier = tiers.get(i);
            PRODUCED_STRESS_CONFIG.add(
                    BUILDER
                            .comment(commentSpace + tier + ": Stress produced at rotational speed 1")
                            .defineInRange("producedStress" + tier, PRODUCED_STRESS_DEFAULTS.get(i), 0, Integer.MAX_VALUE)
            );
            CONSUMED_ENERGY_CONFIG.add(
                    BUILDER
                            .comment(commentSpace + tier + ": Energy consumed per tick at rotational speed 1")
                            .defineInRange("consumedEnergy" + tier, CONSUMED_ENERGY_DEFAULTS.get(i), 0, Integer.MAX_VALUE)
            );
            MAX_CAPACITY_CONFIG.add(
                    BUILDER
                            .comment(commentSpace + tier + ": Maximum capacity of the motor (required consumedEnergy or more)")
                            .defineInRange("maxCapacity" + tier, MAX_CAPACITY_DEFAULTS.get(i), 0, Integer.MAX_VALUE)
            );
            MAX_RECEIVE_CONFIG.add(
                    BUILDER
                            .comment(commentSpace + tier + ": Maximum energy transfer per tick to the motor (required consumedEnergy or more)")
                            .defineInRange("maxReceive" + tier, MAX_RECEIVE_DEFAULTS.get(i), 0, Integer.MAX_VALUE)
            );
        }
    }

    static final ModConfigSpec SPEC = BUILDER.build();

    // 取得された設定
    public static class motorConfig {
        public static TierUtil<Integer> producedStress;
        public static TierUtil<Integer> consumedEnergy;
        public static TierUtil<Integer> maxCapacity;
        public static TierUtil<Integer> maxReceive;
    }


    @SubscribeEvent
    static void onLoad(final ModConfigEvent event) {
        // 設定の取得
        List<Integer> list = new ArrayList<>();

        for (ModConfigSpec.IntValue value : PRODUCED_STRESS_CONFIG) {
            list.add(value.get());
        }
        motorConfig.producedStress = TierUtil.ofList(list);

        list.clear();

        for (ModConfigSpec.IntValue value : CONSUMED_ENERGY_CONFIG) {
            list.add(value.get());
        }
        motorConfig.consumedEnergy = TierUtil.ofList(list);

        list.clear();

        for (ModConfigSpec.IntValue value : MAX_CAPACITY_CONFIG) {
            list.add(value.get());
        }
        motorConfig.maxCapacity = TierUtil.ofList(list);

        list.clear();

        for (ModConfigSpec.IntValue value : MAX_RECEIVE_CONFIG) {
            list.add(value.get());
        }
        motorConfig.maxReceive = TierUtil.ofList(list);
    }
}
