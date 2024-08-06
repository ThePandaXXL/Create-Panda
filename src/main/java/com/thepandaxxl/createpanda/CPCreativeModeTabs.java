package com.thepandaxxl.createpanda;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

@EventBusSubscriber(bus = Bus.MOD)
public class CPCreativeModeTabs {

    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB,
            createpanda.ID);

    public static final RegistryObject<CreativeModeTab> MAIN = TABS.register("create_panda",
    () -> CreativeModeTab.builder()
    .title(Component.literal("Create Panda"))
    .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
    .icon(() -> new ItemStack(Items.BAMBOO))
    .displayItems((displayParams, output) -> {
        //Fluids
        output.accept(CPFluids.BAMBOO_CREAM_BUCKET.get());
        output.accept(CPFluids.BAMBOO_SYRUP_BUCKET.get());

        //Blocks
        output.accept(CPBlocks.BAMBOO_CREAM_CAKE.get());
        output.accept(CPBlocks.BAMBOO_BAMBOO_CREAM_CAKE.get());
        output.accept(CPBlocks.GOLDEN_BAMBOO_BAMBOO_CREAM_CAKE.get());

        //Items
        output.accept(CPItems.BAMBOO_OF_UNDYING.get());
        output.accept(CPItems.BAMBOO_OREO.get());
        output.accept(CPItems.BAMBOOED_APPLE.get());
        output.accept(CPItems.BAMBOO_BERRIES.get());
        output.accept(CPItems.BAR_OF_BAMBOO.get());
        output.accept(CPItems.BAMBOO_CHOCOLATE_CANDY_1.get());
        output.accept(CPItems.CHOCOLATE_CANDY_4.get());
        output.accept(CPItems.BAMBOO_COOKIE.get());
        output.accept(CPItems.BAMBOO_SOUP.get());
        output.accept(CPItems.BAMBOO_SWEET_ROLL.get());
        output.accept(CPItems.BAMBOO_DOUGH.get());
        output.accept(CPItems.BAMBOO_BREAD.get());
        output.accept(CPItems.BAMBOO_CHICKEN.get());
        output.accept(CPItems.GOLDEN_BAMBOO.get());
        output.accept(CPItems.BAMBOO_BEER.get());
        output.accept(CPItems.BAMBOO_JUICE.get());
        
    })
    .build()
    );

    public static void register(IEventBus modEventBus) {
		TABS.register(modEventBus);
	}

}
