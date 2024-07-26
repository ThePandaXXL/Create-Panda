package com.thepandaxxl.createpanda;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.thepandaxxl.createpanda.EntityOverride.pandaFood;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import com.mrh0.createaddition.CreateAddition;
//import net.mcreator.createconfectionery.CreateConfectioneryMod;
import com.simibubi.create.Create;
import com.simibubi.create.content.fluids.transfer.EmptyingRecipe;
import com.Imphuls3.createcafe.CreateCafe;

@Mod(createpanda.ID)
public class createpanda {

    // TODO Create Cafe: Oreo 1.20.1 && build.gradle implementation && CPItems Item
    // && Crafting && lang && model && textures

    public static final Logger LOGGER = LogUtils.getLogger();
    public static final String ID = "createpanda";
    public static final String NAME = "Create Panda";
    public static final String VERSION = "2.0.4";

    public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(ID);

    public createpanda() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        REGISTRATE.registerEventListeners(eventBus);
        CPFluids.register();
        CPBlocks.register();
        CPItems.register(eventBus);
        CPCreativeModeTabs.register(eventBus);
    }

}
