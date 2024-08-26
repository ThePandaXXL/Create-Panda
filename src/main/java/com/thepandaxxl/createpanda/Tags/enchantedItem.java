package com.thepandaxxl.createpanda.Tags;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class enchantedItem extends Item {

    public enchantedItem(Item.Properties properties) {
        super(properties);
    }

    public boolean isFoil(ItemStack itemStack) {
        return true;
    }

}
