package com.example.magicitemsort.items;

import com.example.magicitemsort.block.ModBlocks;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab MAGIC_ITEMS = new CreativeModeTab("MagicItemsTab") {
        @Override
        public ItemStack makeIcon(){
            return new ItemStack(ModItems.MAGIC_WAND.get());
        }
    };

    public static final CreativeModeTab MAGIC_BLOCKS = new CreativeModeTab("MagicBlocksTab") {
        @Override
        public ItemStack makeIcon(){
            return new ItemStack(ModBlocks.MAGIC_BOOKSHELF.get());
        }
    };
}
