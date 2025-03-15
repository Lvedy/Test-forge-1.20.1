package com.lvedy.bdmod.entity.boss.blackDragon;

import com.lvedy.bdmod.BDMod;
import com.lvedy.bdmod.entity.ModModelLayer;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class BlackDragonRender extends GeoEntityRenderer<BlackDragonEntity> {

    public BlackDragonRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new BlackDragonModel());
        this.shadowRadius = 8f;
    }
}
