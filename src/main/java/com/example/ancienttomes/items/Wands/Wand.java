package com.example.ancienttomes.items.Wands;

import java.util.Map;

import com.example.ancienttomes.block.ModBlocks;
import com.example.ancienttomes.items.ModItems;
import com.google.common.collect.ImmutableMap;

import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.internal.TextComponentMessageFormatHandler;
import com.mojang.logging.LogUtils;

public class Wand extends Item{

    private static final Map<Block, Item> WAND_ITEM_WAVE =
        new ImmutableMap.Builder<Block, Item>()
            .put(ModBlocks.GLYPH_STONE.get(), ModItems.MAGIC_GLYPH.get())
            .put(ModBlocks.DEEPSLATE_GLYPH_STONE.get(), ModItems.MAGIC_GLYPH.get())
            .build();
    
    public Wand(Properties pProperties){
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if(!pContext.getLevel().isClientSide()){
            Level level = pContext.getLevel();
            BlockPos positionClicked = pContext.getClickedPos();
            Block blockClicked = level.getBlockState(positionClicked).getBlock();
            
            if(canWaveWand(blockClicked)){
                ItemEntity entityItem = new ItemEntity(level,
                    pContext.getPlayer().getX(),pContext.getPlayer().getY(),pContext.getPlayer().getZ(),
                    new ItemStack(WAND_ITEM_WAVE.get(blockClicked), 1));   

                level.destroyBlock(positionClicked, false);

                if(blockClicked.getName().getString().equals("Glyph Stone")){
                    level.setBlock(positionClicked, Blocks.STONE.defaultBlockState(), 0);
                }else{
                    level.setBlock(positionClicked, Blocks.DEEPSLATE.defaultBlockState(), 0);
                }

                level.addFreshEntity(entityItem);
                
                pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(), p ->{
                    p.broadcastBreakEvent(pContext.getHand());
                });
            }
            else{
                pContext.getPlayer().displayClientMessage(Component.literal("Cant magic wand this"), 
                true);
            }
        }


        return InteractionResult.SUCCESS;
    }
    
    private boolean canWaveWand(Block block){
        return WAND_ITEM_WAVE.containsKey(block);
    }
}
