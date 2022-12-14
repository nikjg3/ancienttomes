package com.example.ancienttomes.world.feature;

import java.util.List;

import com.example.ancienttomes.AncientTomes;
import com.example.ancienttomes.block.ModBlocks;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModConfiguredFeatures  {
    public static final DeferredRegister<ConfiguredFeature<?,?>> CONFIGURED_FEATURES = 
        DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, AncientTomes.MODID);

    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_CRYSTAL_ORE = Suppliers.memoize(() -> List.of(
        OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.CRYSTAL_ORE.get().defaultBlockState()),
        OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_CRYSTAL_ORE.get().defaultBlockState())));

    public static final RegistryObject<ConfiguredFeature<?, ?>> CRYSTAL_ORE = CONFIGURED_FEATURES.register("crystal_ore",
        () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_CRYSTAL_ORE.get(),25)));

    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_GLYPH_STONE = Suppliers.memoize(() -> List.of(
        OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.GLYPH_STONE.get().defaultBlockState()),
        OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_GLYPH_STONE.get().defaultBlockState())));
    
    public static final RegistryObject<ConfiguredFeature<?, ?>> GLYPH_STONE = CONFIGURED_FEATURES.register("glyph_stone",
        () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_GLYPH_STONE.get(),25)));
    
    public static void Register(IEventBus eventBus){
        CONFIGURED_FEATURES.register(eventBus);
    }
}
