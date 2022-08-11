package com.example.ancienttomes.world.feature;

import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

import com.example.ancienttomes.AncientTomes;

public class ModPlacedFeatures {
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES =
            DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, AncientTomes.MODID);


    public static final RegistryObject<PlacedFeature> CRYSTAL_ORE_PLACED = PLACED_FEATURES.register("crystal_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.CRYSTAL_ORE.getHolder().get(),
                    commonOrePlacement(7, // VeinsPerChunk
                        HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));
    
    public static final RegistryObject<PlacedFeature> GLYPH_STONE_PLACED = PLACED_FEATURES.register("glyph_stone_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.CRYSTAL_ORE.getHolder().get(),
                    commonOrePlacement(7, // VeinsPerChunk
                        HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));


    public static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
        return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
    }

    public static List<PlacementModifier> commonOrePlacement(int p_195344_, PlacementModifier p_195345_) {
        return orePlacement(CountPlacement.of(p_195344_), p_195345_);
    }

    public static List<PlacementModifier> rareOrePlacement(int p_195350_, PlacementModifier p_195351_) {
        return orePlacement(RarityFilter.onAverageOnceEvery(p_195350_), p_195351_);
    }

    public static void Register(IEventBus eventBus) {
        PLACED_FEATURES.register(eventBus);
    }
}