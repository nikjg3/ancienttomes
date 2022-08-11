package com.example.ancienttomes.block;

import java.util.function.Supplier;

import com.example.ancienttomes.AncientTomes;
import com.example.ancienttomes.items.ModCreativeModeTab;
import com.example.ancienttomes.items.ModItems;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks{

    public static final DeferredRegister<Block> BLOCKS = 
        DeferredRegister.create(ForgeRegistries.BLOCKS, AncientTomes.MODID);

    //Magic Bookshelf
    public static final RegistryObject<Block> MAGIC_BOOKSHELF = registerBlock("magic_bookshelf",
        () -> new Block(BlockBehaviour.Properties.of(Material.WOOD).strength(2f)));
    
    //Magic Ore
    public static final RegistryObject<Block> CRYSTAL_ORE = registerBlock("crystal_ore",
    () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(8f)));

    //Magic Ore (Deepslate)
    public static final RegistryObject<Block> DEEPSLATE_CRYSTAL_ORE = registerBlock("deepslate_crystal_ore",
    () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(8f)));

    //Glyph Stone
    public static final RegistryObject<Block> GLYPH_STONE = registerBlock("glyph_stone",
    () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(4f)));

    //Glyph Stone (Deepslate)
    public static final RegistryObject<Block> DEEPSLATE_GLYPH_STONE = registerBlock("deepslate_glyph_stone",
    () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(4f)));
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(tab)));
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block,
            CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(ModCreativeModeTab.MAGIC_BLOCKS)));
    }

    
    public static void Register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}