package com.lvedy.bdmod.entity.boss.blackDragon;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class BlackDragonModel extends DefaultedEntityGeoModel<BlackDragonEntity> {
	public BlackDragonModel() {
		super(new ResourceLocation("black_dragon", "black_dragon"), true);
	}

	@Override
	public void setCustomAnimations(BlackDragonEntity animatable, long instanceId, AnimationState<BlackDragonEntity> animationState) {
	}
}