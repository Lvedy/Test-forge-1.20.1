package com.lvedy.bdmod;

import com.lvedy.bdmod.entity.ModEntities;
import com.lvedy.bdmod.entity.boss.blackDragon.BlackDragonRender;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = BDMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModClientBusEvent {
    @SubscribeEvent
    public static void registerLayer(FMLClientSetupEvent event) {
        EntityRenderers.register(ModEntities.BLACKDRAGON.get(), BlackDragonRender::new);
    }
}
