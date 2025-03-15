package com.lvedy.bdmod;

import com.lvedy.bdmod.entity.ModEntities;
import com.lvedy.bdmod.entity.boss.blackDragon.BlackDragonEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BDMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModBusEvent {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.BLACKDRAGON.get(), BlackDragonEntity.createAttributes().build());
    }
}
