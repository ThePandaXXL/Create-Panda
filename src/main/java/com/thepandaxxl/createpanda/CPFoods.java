package com.thepandaxxl.createpanda;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class CPFoods {
    
    public static final FoodProperties BAMBOOED_APPLE = (new FoodProperties.Builder()).nutrition(8).saturationMod(0.8F).alwaysEat().build();
    public static final FoodProperties BAMBOO_BERRIES = (new FoodProperties.Builder()).nutrition(7).saturationMod(0.8F).alwaysEat().build();
    public static final FoodProperties BAR_OF_BAMBOO = (new FoodProperties.Builder().nutrition(6).saturationMod(0.3F).alwaysEat().build());
    public static final FoodProperties BAMBOO_CHOCOLATE_CANDY = (new FoodProperties.Builder().nutrition(10).saturationMod(0.9F).effect(() -> new MobEffectInstance(MobEffects.LUCK, 3600, 0), 1.0F).alwaysEat().build());
    public static final FoodProperties BAMBOO_COOKIE = (new FoodProperties.Builder().nutrition(2).saturationMod(0.4F).alwaysEat().build());
    public static final FoodProperties BAMBOO_SOUP = (new FoodProperties.Builder().nutrition(6).saturationMod(1.4F).alwaysEat().build());
    public static final FoodProperties BAMBOO_SWEET_ROLL = (new FoodProperties.Builder().nutrition(6).saturationMod(0.8F).alwaysEat().build());
    public static final FoodProperties BAMBOO_BREAD = (new FoodProperties.Builder().nutrition(5).saturationMod(1.2F).alwaysEat().build());
    public static final FoodProperties BAMBOO_CHICKEN = (new FoodProperties.Builder().nutrition(14).saturationMod(2.8F).alwaysEat().build());
    public static final FoodProperties GOLDEN_BAMBOO = (new FoodProperties.Builder().nutrition(4).saturationMod(9.6F).effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 2400, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 100, 1), 1.0F).alwaysEat().build());
    public static final FoodProperties BAMBOO_BEER = (new FoodProperties.Builder().nutrition(2).saturationMod(0.4F).effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 3600, 0), 0.5F).alwaysEat().build());
    public static final FoodProperties BAMBOO_JUICE = (new FoodProperties.Builder().nutrition(4).saturationMod(0.8F).alwaysEat().build());

    public CPFoods() {
    }

}
