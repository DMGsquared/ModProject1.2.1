package net.DMG.mymod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties FRIED_EGG = new FoodProperties.Builder().nutrition(5).saturationModifier(.6f)
            .effect(new MobEffectInstance(MobEffects.JUMP,200), 1.0f)
            .effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200), 1.0f).fast().build();
}
