package com.lvedy.bdmod.entity;

import com.lvedy.bdmod.BDMod;
import com.lvedy.bdmod.entity.boss.blackDragon.BlackDragonEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, BDMod.MODID);

    public static final RegistryObject<EntityType<BlackDragonEntity>> BLACKDRAGON =
            ENTITY_TYPES.register("black_dragon", () -> EntityType.Builder.of(BlackDragonEntity::new, MobCategory.CREATURE)
                    .sized(8f, 8f).build(new ResourceLocation(BDMod.MODID,"black_dragon").toString()));


    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
