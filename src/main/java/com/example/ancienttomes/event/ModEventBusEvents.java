package com.example.ancienttomes.event;

import net.minecraft.client.Minecraft;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nonnull;

import com.example.ancienttomes.AncientTomes;
import com.example.ancienttomes.entity.ModEntityTypes;
import com.example.ancienttomes.entity.custom.FloatingBookEntity;

@Mod.EventBusSubscriber(modid = AncientTomes.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {


    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
        event.put(ModEntityTypes.FLOATING_BOOK.get(), FloatingBookEntity.setAttributes());
    }
}