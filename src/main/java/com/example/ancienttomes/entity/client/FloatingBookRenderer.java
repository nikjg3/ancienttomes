package com.example.ancienttomes.entity.client;

import com.example.ancienttomes.AncientTomes;
import com.example.ancienttomes.entity.custom.FloatingBookEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class FloatingBookRenderer extends GeoEntityRenderer<FloatingBookEntity>{

      public FloatingBookRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new FloatingBookModel());
        this.shadowRadius = 0.3f;
    }

    @Override
    public ResourceLocation getTextureLocation(FloatingBookEntity instance) {
        return new ResourceLocation(AncientTomes.MODID, "textures/entity/floating_book/floating_book.png");
    }

    @Override
    public RenderType getRenderType(FloatingBookEntity animatable, float partialTicks, PoseStack stack,
                                    MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(0.6F, 0.6F, 0.6F);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}
