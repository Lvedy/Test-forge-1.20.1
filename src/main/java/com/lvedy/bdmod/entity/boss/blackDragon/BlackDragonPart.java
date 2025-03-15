package com.lvedy.bdmod.entity.boss.blackDragon;

import com.github.darkpred.morehitboxes.api.HitboxData;
import com.github.darkpred.morehitboxes.api.MultiPartEntity;
import com.github.darkpred.morehitboxes.internal.ForgeMultiPart;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;

public class BlackDragonPart<T extends Mob & MultiPartEntity<T>> extends ForgeMultiPart<T> {
    public BlackDragonPart(T parent, HitboxData hitboxData) {
        super(parent, hitboxData);
    }

    @Override
    public boolean isPickable() {
        return true;
    }

    public boolean is(Entity pEntity) {
        return this == pEntity || this.getParent() == pEntity;
    }

    @Override
    public boolean isPushable() {
        return false;
    }

    @Override
    public boolean canBeCollidedWith() {
        return true;
    }

}
