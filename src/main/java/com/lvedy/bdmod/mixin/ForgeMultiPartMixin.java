package com.lvedy.bdmod.mixin;

import com.github.darkpred.morehitboxes.api.HitboxData;
import com.github.darkpred.morehitboxes.api.MultiPart;
import com.github.darkpred.morehitboxes.api.MultiPartEntity;
import com.github.darkpred.morehitboxes.internal.ForgeMultiPart;
import com.lvedy.bdmod.entity.boss.blackDragon.BlackDragonEntity;
import com.lvedy.bdmod.entity.boss.blackDragon.BlackDragonPart;
import net.minecraft.world.entity.Mob;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ForgeMultiPart.ForgeMultiPartFactory.class)
public class ForgeMultiPartMixin {
    @Inject(method = "create", at = @At("RETURN"), cancellable = true, remap = false)
    private <T extends Mob & MultiPartEntity<T>> void injected(T parent, HitboxData hitboxData, CallbackInfoReturnable<MultiPart<T>> cir) {
        if (parent instanceof BlackDragonEntity) {
            cir.setReturnValue(new BlackDragonPart<>(parent, hitboxData));
        }
    }
}
