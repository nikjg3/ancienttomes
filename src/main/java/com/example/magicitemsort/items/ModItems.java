package com.example.magicitemsort.items;

import com.example.magicitemsort.MagicItemSort;
import com.example.magicitemsort.items.Wands.Wand;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems{

    public static final DeferredRegister<Item> ITEMS = 
        DeferredRegister.create(ForgeRegistries.ITEMS, MagicItemSort.MODID);


    public static final RegistryObject<Item> MAGIC_STICK = ITEMS.register("magic_stick",
    () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MAGIC_ITEMS)));

    public static final RegistryObject<Item> MAGIC_CORE = ITEMS.register("magic_core",
    () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MAGIC_ITEMS)));

    public static final RegistryObject<Item> MAGIC_WAND = ITEMS.register("magic_wand",
    () -> new Wand(new Item.Properties().tab(ModCreativeModeTab.MAGIC_ITEMS).durability(128)));

    public static void Register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}

/*  Mod Ideas  
 *  Collect words from stone with wand or something
 * 
 * 
 * 
 */