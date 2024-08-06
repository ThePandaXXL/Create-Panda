package com.thepandaxxl.createpanda.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.thepandaxxl.createpanda.CPBlocks;
import com.thepandaxxl.createpanda.CPItems;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Panda;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;

@Mixin(Panda.class)
public abstract class pandaFood extends Animal {

    protected pandaFood(EntityType<? extends Animal> p_27557_, Level p_27558_) {
        super(p_27557_, p_27558_);
    }

    @Inject(method = "registerGoals", at = @At("TAIL"))
    protected void createpandaGoals(CallbackInfo info) {
        this.goalSelector.addGoal(4, new TemptGoal(this, 2.0D, Ingredient.of(CPBlocks.BAMBOO_CREAM_CAKE.asItem()), false));
        this.goalSelector.addGoal(4, new TemptGoal(this, 2.0D, Ingredient.of(CPBlocks.BAMBOO_BAMBOO_CREAM_CAKE.asItem()), false));
        this.goalSelector.addGoal(4, new TemptGoal(this, 2.0D, Ingredient.of(CPBlocks.GOLDEN_BAMBOO_BAMBOO_CREAM_CAKE.asItem()), false));
        this.goalSelector.addGoal(4, new TemptGoal(this, 2.0D, Ingredient.of(CPItems.BAMBOO_OREO.get()), false));
        this.goalSelector.addGoal(4, new TemptGoal(this, 2.0D, Ingredient.of(CPItems.BAMBOOED_APPLE.get()), false));
        this.goalSelector.addGoal(4, new TemptGoal(this, 2.0D, Ingredient.of(CPItems.BAMBOO_BERRIES.get()), false));
        this.goalSelector.addGoal(4, new TemptGoal(this, 2.0D, Ingredient.of(CPItems.BAR_OF_BAMBOO.get()), false));
        this.goalSelector.addGoal(4, new TemptGoal(this, 2.0D, Ingredient.of(CPItems.BAMBOO_CHOCOLATE_CANDY_1.get()), false));
        this.goalSelector.addGoal(4, new TemptGoal(this, 2.0D, Ingredient.of(CPItems.CHOCOLATE_CANDY_4.get()), false));
        this.goalSelector.addGoal(4, new TemptGoal(this, 2.0D, Ingredient.of(CPItems.BAMBOO_COOKIE.get()), false));
        this.goalSelector.addGoal(4, new TemptGoal(this, 2.0D, Ingredient.of(CPItems.BAMBOO_SWEET_ROLL.get()), false));
        this.goalSelector.addGoal(4, new TemptGoal(this, 2.0D, Ingredient.of(CPItems.BAMBOO_BREAD.get()), false));
        this.goalSelector.addGoal(4, new TemptGoal(this, 2.0D, Ingredient.of(CPItems.BAMBOO_CHICKEN.get()), false));
        this.goalSelector.addGoal(4, new TemptGoal(this, 2.0D, Ingredient.of(CPItems.GOLDEN_BAMBOO.get()), false));
    }

    @SuppressWarnings("null")
    @Override
    public boolean isFood(ItemStack itemStack) {

        if (itemStack.is(Blocks.BAMBOO.asItem())
                || itemStack.is(CPBlocks.BAMBOO_CREAM_CAKE.asItem())
                || itemStack.is(CPBlocks.BAMBOO_BAMBOO_CREAM_CAKE.asItem())
                || itemStack.is(CPBlocks.GOLDEN_BAMBOO_BAMBOO_CREAM_CAKE.asItem())
                || itemStack.is(CPItems.BAMBOO_OREO.get())
                || itemStack.is(CPItems.BAMBOOED_APPLE.get())
                || itemStack.is(CPItems.BAMBOO_BERRIES.get())
                || itemStack.is(CPItems.BAR_OF_BAMBOO.get())
                || itemStack.is(CPItems.BAMBOO_CHOCOLATE_CANDY_1.get())
                || itemStack.is(CPItems.CHOCOLATE_CANDY_4.get())
                || itemStack.is(CPItems.BAMBOO_COOKIE.get())
                || itemStack.is(CPItems.BAMBOO_SWEET_ROLL.get())
                || itemStack.is(CPItems.BAMBOO_BREAD.get())
                || itemStack.is(CPItems.BAMBOO_CHICKEN.get())
                || itemStack.is(CPItems.GOLDEN_BAMBOO.get())) {
            return true;
        } else {
            return false;
        }

    }

}