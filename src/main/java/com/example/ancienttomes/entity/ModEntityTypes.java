package com.example.ancienttomes.entity;

import com.example.ancienttomes.AncientTomes;
import com.example.ancienttomes.entity.custom.FloatingBookEntity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, AncientTomes.MODID);

    public static final RegistryObject<EntityType<FloatingBookEntity>> FLOATING_BOOK =
            ENTITY_TYPES.register("floating_book",
            () -> EntityType.Builder.of(FloatingBookEntity::new, MobCategory.CREATURE)
                    .sized(0.8f, 0.6f)
                    .build(new ResourceLocation(AncientTomes.MODID, "floating_book").toString()));


    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}