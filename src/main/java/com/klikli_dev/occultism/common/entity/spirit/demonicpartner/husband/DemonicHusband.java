package com.klikli_dev.occultism.common.entity.spirit.demonicpartner.husband;

import com.klikli_dev.occultism.Occultism;
import com.klikli_dev.occultism.common.entity.spirit.demonicpartner.DemonicPartner;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.util.NonNullLazy;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

public class DemonicHusband extends DemonicPartner implements GeoEntity {

    public static final ResourceLocation ID = new ResourceLocation(Occultism.MODID, "demonic_husband");
    public static final NonNullLazy<EntityType<DemonicHusband>> ENTITY_TYPE =
            NonNullLazy.of(() -> EntityType.Builder.of(DemonicHusband::new, MobCategory.CREATURE)
                    .sized(0.6F, 1.8f)
                    .fireImmune()
                    .clientTrackingRange(8)
                    .build(ID.toString()));
    AnimatableInstanceCache animatableInstanceCache = GeckoLibUtil.createInstanceCache(this);

    protected DemonicHusband(EntityType<? extends TamableAnimal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @Override
    public int getCurrentSwingDuration() {
        return 11; //to match our attack animation speed + 1 tick
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        var mainController = new AnimationController<>(this, "mainController", 0, this::animPredicate);
        controllers.add(mainController);
    }

    private <T extends GeoAnimatable> PlayState animPredicate(AnimationState<T> tAnimationState) {

        if (this.swinging) {
            return tAnimationState.setAndContinue(RawAnimation.begin().thenPlay("attack"));
        }

        if (this.isInSittingPose())
            return tAnimationState.setAndContinue(RawAnimation.begin().thenPlay("sitting"));

        if (this.isLying())
            return tAnimationState.setAndContinue(RawAnimation.begin().thenPlay("lies"));

        return tAnimationState.setAndContinue(tAnimationState.isMoving() ? RawAnimation.begin().thenPlay("walk") : RawAnimation.begin().thenPlay("idle"));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.animatableInstanceCache;
    }
}
