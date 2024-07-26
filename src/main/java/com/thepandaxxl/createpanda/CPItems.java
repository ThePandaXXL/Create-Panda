package com.thepandaxxl.createpanda;

import com.Imphuls3.createcafe.common.item.foods.ModFoods;
import com.simibubi.create.content.processing.sequenced.SequencedAssemblyItem;
import com.thepandaxxl.createpanda.Tags.BambooChocolateCandyItem;
import com.thepandaxxl.createpanda.Tags.CPSoupItem;
import com.thepandaxxl.createpanda.Tags.BambooBeerItem;
import com.thepandaxxl.createpanda.Tags.BambooJuiceItem;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CPItems {

    public static final DeferredRegister<Item> ITEMS;
    public static final RegistryObject<Item> BAMBOO_OREO;
    public static final RegistryObject<Item> BAMBOO_OREO_INCOMPLETE;
    public static final RegistryObject<Item> BAMBOOED_APPLE;
    public static final RegistryObject<Item> BAMBOO_BERRIES;
    public static final RegistryObject<Item> BAR_OF_BAMBOO;
    public static final RegistryObject<Item> BAMBOO_CHOCOLATE_CANDY_1;
    public static final RegistryObject<Item> CHOCOLATE_CANDY_4;
    public static final RegistryObject<Item> BAMBOO_COOKIE;
    public static final RegistryObject<Item> BAMBOO_SOUP;
    public static final RegistryObject<Item> BAMBOO_SWEET_ROLL;
    public static final RegistryObject<Item> BAMBOO_DOUGH;
    public static final RegistryObject<Item> BAMBOO_BREAD;
    public static final RegistryObject<Item> GOLDEN_BAMBOO;
    public static final RegistryObject<Item> BAMBOO_BEER;
    public static final RegistryObject<Item> BAMBOO_JUICE;

    public CPItems() {
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    static {
        ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, createpanda.ID);

        BAMBOO_OREO = ITEMS.register("bamboo_oreo", () -> {
            return new Item(new Item.Properties().food(ModFoods.OREO));
        });

        BAMBOO_OREO_INCOMPLETE = ITEMS.register("bamboo_oreo_incomplete", () -> {
            return new SequencedAssemblyItem(new Item.Properties());
        });

        BAMBOOED_APPLE = ITEMS.register("bambooed_apple", () -> {
            return new Item(new Item.Properties().food(CPFoods.BAMBOOED_APPLE));
        });

        BAMBOO_BERRIES = ITEMS.register("bamboo_glazed_berries", () -> {
            return new Item(new Item.Properties().food(CPFoods.BAMBOO_BERRIES));
        });

        BAR_OF_BAMBOO = ITEMS.register("bar_of_bamboo", () -> {
            return new Item(new Item.Properties().food(CPFoods.BAR_OF_BAMBOO));
        });

        BAMBOO_CHOCOLATE_CANDY_1 = ITEMS.register("bamboo_chocolate_candy_1", () -> {
            return new BambooChocolateCandyItem(new Item.Properties().food(CPFoods.BAMBOO_CHOCOLATE_CANDY));
        });

        CHOCOLATE_CANDY_4 = ITEMS.register("chocolate_candy_4", () -> {
            return new BambooChocolateCandyItem(new Item.Properties().food(CPFoods.BAMBOO_CHOCOLATE_CANDY));
        });

        BAMBOO_COOKIE = ITEMS.register("bamboo_cookie", () -> {
            return new Item(new Item.Properties().food(CPFoods.BAMBOO_COOKIE));
        });

        BAMBOO_SOUP = ITEMS.register("bamboo_soup", () -> {
            return new CPSoupItem(new Item.Properties().food(CPFoods.BAMBOO_SOUP));
        });

        BAMBOO_SWEET_ROLL = ITEMS.register("bamboo_sweet_roll", () -> {
            return new Item(new Item.Properties().food(CPFoods.BAMBOO_SWEET_ROLL));
        });

        BAMBOO_DOUGH = ITEMS.register("bamboo_dough", () -> {
            return new Item(new Item.Properties());
        });

        BAMBOO_BREAD = ITEMS.register("bamboo_bread", () -> {
            return new Item(new Item.Properties().food(CPFoods.BAMBOO_BREAD));
        });

        GOLDEN_BAMBOO = ITEMS.register("golden_bamboo", () -> {
            return new Item(new Item.Properties().food(CPFoods.GOLDEN_BAMBOO));
        });

        BAMBOO_BEER = ITEMS.register("bamboo_beer", () -> {
            return new BambooBeerItem(new Item.Properties().food(CPFoods.BAMBOO_BEER));
        });

        BAMBOO_JUICE = ITEMS.register("bamboo_juice", () -> {
            return new BambooJuiceItem(new Item.Properties().food(CPFoods.BAMBOO_JUICE));
        });

    }
}