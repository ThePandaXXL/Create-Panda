package com.thepandaxxl.createpanda;

import com.mrh0.createaddition.blocks.cake.CACakeBlock;
import com.simibubi.create.AllTags.AllItemTags;
import com.simibubi.create.foundation.data.ModelGen;
import com.tterrag.registrate.builders.BlockBuilder;
import com.tterrag.registrate.util.entry.BlockEntry;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
public class CPBlocks {

    public static final BlockEntry<CACakeBlock> BAMBOO_CREAM_CAKE;
    public static final BlockEntry<CACakeBlock> BAMBOO_BAMBOO_CREAM_CAKE;

    public CPBlocks() {
    }

    static {

        BAMBOO_CREAM_CAKE = ((BlockBuilder) createpanda.REGISTRATE.block("bamboo_cream_cake", CACakeBlock::new)
                .initialProperties(() -> {
                    return Blocks.CAKE;
                }).properties((props) -> {
                    return props.sound(SoundType.WOOL).strength(0.5F);
                }).item().tag(AllItemTags.UPRIGHT_ON_BELT.tag).transform(ModelGen.customItemModel())).register();

        BAMBOO_BAMBOO_CREAM_CAKE = ((BlockBuilder) createpanda.REGISTRATE
                .block("bamboo_bamboo_cream_cake", CACakeBlock::new)
                .initialProperties(() -> {
                    return Blocks.CAKE;
                }).properties((props) -> {
                    return props.sound(SoundType.WOOL).strength(0.5F);
                }).item().tag(AllItemTags.UPRIGHT_ON_BELT.tag).transform(ModelGen.customItemModel())).register();
    }

    public static void register() {}

}
