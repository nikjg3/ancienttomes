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

public class Wand extends Item{

    private static final Map<Block, Item> WAND_ITEM_WAVE =
        new ImmutableMap.Builder<Block, Item>()
            .put(ModBlocks.MAGIC_BOOKSHELF.get(), ModItems.MAGIC_CORE.get())
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
                    positionClicked.getX(),positionClicked.getY(),positionClicked.getZ(),
                    new ItemStack(WAND_ITEM_WAVE.get(blockClicked), 1));   

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
