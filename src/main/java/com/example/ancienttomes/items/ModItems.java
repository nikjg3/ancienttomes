package com.example.ancienttomes.items;

import com.example.ancienttomes.AncientTomes;
import com.example.ancienttomes.entity.ModEntityTypes;
import com.example.ancienttomes.items.Wands.Wand;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems{

    public static final DeferredRegister<Item> ITEMS = 
        DeferredRegister.create(ForgeRegistries.ITEMS, AncientTomes.MODID);

    public static final RegistryObject<Item> MAGIC_CORE = ITEMS.register("magic_core",
    () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MAGIC_ITEMS)));
    
    public static final RegistryObject<Item> CRYSTAL_CHUNK = ITEMS.register("crystal_chunk",
    () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MAGIC_ITEMS)));

    public static final RegistryObject<Item> MAGIC_GLYPH = ITEMS.register("magic_glyph",
    () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MAGIC_ITEMS)));

    //Wand items
    public static final RegistryObject<Item> MAGIC_WAND = ITEMS.register("magic_wand",
    () -> new Wand(new Item.Properties().tab(ModCreativeModeTab.MAGIC_ITEMS).durability(128)));

    //Tomes 
    public static final RegistryObject<Item> ANCIENT_SCRIPTS = ITEMS.register("ancient_scripts",
    () -> new Wand(new Item.Properties().tab(ModCreativeModeTab.MAGIC_ITEMS).durability(128)));

    public static final RegistryObject<Item> FLOATING_BOOK_SPAWN_EGG = ITEMS.register("floating_book_spawn_egg",
    () -> new ForgeSpawnEggItem(ModEntityTypes.FLOATING_BOOK, 14260801, 16777215,
            new Item.Properties().tab(ModCreativeModeTab.MAGIC_ITEMS)));


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