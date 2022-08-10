package com.example.magicitemsort.entitiy.custom;

import com.example.magicitemsort.MagicItemSort;

import net.minecraft.world.entity.EntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class MobEntityTypes {
    public static DeferredRegister<EntityType<?>> ENTITY_TYPES
        = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MagicItemSort.MODID);
}
