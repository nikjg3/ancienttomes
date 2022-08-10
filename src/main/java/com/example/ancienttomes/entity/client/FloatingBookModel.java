package com.example.ancienttomes.entity.client;

import com.example.ancienttomes.AncientTomes;
import com.example.ancienttomes.entity.custom.FloatingBookEntity;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class FloatingBookModel extends AnimatedGeoModel<FloatingBookEntity> {
    @Override
    public ResourceLocation getModelResource(FloatingBookEntity object) {
        return new ResourceLocation(AncientTomes.MODID, "geo/floating_book.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(FloatingBookEntity object) {
        return new ResourceLocation(AncientTomes.MODID, "textures/entity/floating_book/floating_book.png");
    }

    @Override
    public ResourceLocation getAnimationResource(FloatingBookEntity animatable) {
        return new ResourceLocation(AncientTomes.MODID, "animations/floating_book.animation.json");
    }
}
