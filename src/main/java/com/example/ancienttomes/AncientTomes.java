package com.example.ancienttomes;

import com.example.ancienttomes.items.ModItems;
import com.example.ancienttomes.world.feature.ModConfiguredFeatures;
import com.example.ancienttomes.world.feature.ModPlacedFeatures;
import com.example.ancienttomes.block.ModBlocks;
import com.example.ancienttomes.entity.ModEntityTypes;
import com.example.ancienttomes.entity.client.FloatingBookRenderer;
import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import software.bernie.example.registry.EntityRegistry;
import software.bernie.geckolib3.GeckoLib;

import javax.xml.catalog.CatalogFeatures.Feature;

import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(AncientTomes.MODID)
public class AncientTomes
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "ancienttomes";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();



    public AncientTomes()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.Register(modEventBus);
        ModBlocks.Register(modEventBus);

        ModConfiguredFeatures.Register(modEventBus);
        ModPlacedFeatures.Register(modEventBus);

        ModEntityTypes.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::clientSetup);
        
        GeckoLib.initialize();
        
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        // Setup Code
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        // Do something when the server starts
        LOGGER.info("Hooray the server started");
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    private void clientSetup(final FMLClientSetupEvent event)
    {

        EntityRenderers.register(ModEntityTypes.FLOATING_BOOK.get(), FloatingBookRenderer::new);
    }
}
