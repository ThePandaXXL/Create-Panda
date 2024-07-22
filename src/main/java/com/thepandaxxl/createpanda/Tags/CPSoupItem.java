package com.thepandaxxl.createpanda.Tags;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class CPSoupItem extends Item {
    public CPSoupItem(Item.Properties properties) {
        super(properties);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level world, LivingEntity entity) {
        super.finishUsingItem(stack, world, entity);

        if (entity instanceof Player && !((Player)entity).getAbilities().instabuild) {
            ItemStack bowl = new ItemStack(Items.BOWL);
            Player player = (Player) entity;

            if (!player.getInventory().add(bowl)) {
                player.drop(bowl, false);
            }
        }

        return stack.isEmpty() ? new ItemStack(Items.BOWL) : stack;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.DRINK;
    }
}
