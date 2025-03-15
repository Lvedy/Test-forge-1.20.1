package com.lvedy.bdmod.entity.boss.blackDragon;

import com.github.darkpred.morehitboxes.api.EntityHitboxData;
import com.github.darkpred.morehitboxes.api.EntityHitboxDataFactory;
import com.github.darkpred.morehitboxes.api.GeckoLibMultiPartEntity;
import com.github.darkpred.morehitboxes.api.MultiPart;
import com.lvedy.bdmod.entity.ModEntities;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;


public class BlackDragonEntity extends Mob implements GeoEntity, GeckoLibMultiPartEntity<BlackDragonEntity> {
    private int testTime = 0;
    private boolean test = false;
    protected static final RawAnimation TEST = RawAnimation.begin().thenLoop("animation.model.test");
    private AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private final EntityHitboxData<BlackDragonEntity> hitboxData = EntityHitboxDataFactory.create(this);

    public BlackDragonEntity(EntityType<? extends Mob> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.setHealth(this.getMaxHealth());
    }

    @Override
    public void aiStep() {
        if(this.testTime>0)
            this.testTime -= 1;
        if(this.testTime<=0)
            this.test = false;
        super.aiStep();
    }


    public static AttributeSupplier.Builder createAttributes(){
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 200D)
                .add(Attributes.MOVEMENT_SPEED,0.2D);
    }

    @Override
    public EntityHitboxData<BlackDragonEntity> getEntityHitboxData() {
        return hitboxData;
    }

    @Override
    public boolean partHurt(MultiPart<BlackDragonEntity> multiPart, @NotNull DamageSource damageSource, float v) {
        this.testTime = 60;
        this.test = true;
        return true;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "test", 0, this::AnimController));
    }

    protected <E extends BlackDragonEntity> PlayState AnimController(final AnimationState<E> event) {
        if (this.test && this.testTime > 0)
            return event.setAndContinue(TEST);
        return PlayState.STOP;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    @Override
    public boolean canCollideWith(Entity pEntity) {
        return false;
    }

    @Override
    public boolean isPickable() {
        return false;
    }

    @Override
    public boolean isPushable() {
        return false;
    }

    @Override
    protected void doPush(Entity p_20971_) {
    }

    @Override
    public void knockback(double strength, double xRatio, double zRatio) {
    }

}
