package com.thepandaxxl.createpanda.Tags;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

public class BambooChocolateCandyItem extends Item {

    public BambooChocolateCandyItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> components, TooltipFlag flag) {
        components.add(Component.translatable("tooltip.createpanda.luck3.00").withStyle(ChatFormatting.BLUE));
        super.appendHoverText(stack, level, components, flag);
    }

}