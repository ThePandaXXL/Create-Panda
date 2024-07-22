package com.thepandaxxl.createpanda;

import java.util.function.Supplier;

import org.joml.Vector3f;

import com.simibubi.create.AllFluids;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.foundation.utility.Color;
import com.tterrag.registrate.builders.FluidBuilder;
import com.tterrag.registrate.builders.FluidBuilder.FluidTypeFactory;
import com.tterrag.registrate.util.entry.FluidEntry;
import com.tterrag.registrate.util.entry.ItemEntry;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.material.FluidState;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.ForgeFlowingFluid;

public class CPFluids {

    // public static final FluidEntry<ForgeFlowingFluid.Flowing> BAMBOO_CREAM =
    // createpanda.REGISTRATE
    // .standardFluid("bamboo_cream",
    // SolidRenderedPlaceableFluidType.create(0x00B800,
    // () -> 0.05f))
    // .properties(b -> b.viscosity(2000)
    // .density(1400))
    // .fluidProperties(p -> p.levelDecreasePerBlock(2)
    // .tickRate(25)
    // .slopeFindDistance(3)
    // .explosionResistance(100f))
    // .register();

    public static FluidEntry<ForgeFlowingFluid.Flowing> BAMBOO_CREAM;
    public static FluidEntry<ForgeFlowingFluid.Flowing> BAMBOO_SYRUP;
    public static ItemEntry<BucketItem> BAMBOO_CREAM_BUCKET;
    public static ItemEntry<BucketItem> BAMBOO_SYRUP_BUCKET;

    public static void register() {
        FluidBuilder<ForgeFlowingFluid.Flowing, CreateRegistrate> bamboo_cream = createpanda.REGISTRATE
                .fluid("bamboo_cream", new ResourceLocation("createpanda", "fluid/bamboo_cream_still"),
                        new ResourceLocation("createpanda", "fluid/bamboo_cream_flow"),
                        SolidRenderedPlaceableFluidType.create(0x00B800, () -> 0.05f))
                .properties((b) -> {
                    b.viscosity(1500).density(1400);
                }).fluidProperties((p) -> {
                    p.levelDecreasePerBlock(2).tickRate(25).slopeFindDistance(3).explosionResistance(100.0F);
                }).source(ForgeFlowingFluid.Source::new);
        BAMBOO_CREAM_BUCKET = bamboo_cream.bucket().properties((p) -> {
            return p.stacksTo(1);
        }).register();
        BAMBOO_CREAM = bamboo_cream.register();

        FluidBuilder<ForgeFlowingFluid.Flowing, CreateRegistrate> bamboo_syrup = createpanda.REGISTRATE
                .fluid("bamboo_syrup", new ResourceLocation("createpanda", "fluid/bamboo_syrup_still"),
                        new ResourceLocation("createpanda", "fluid/bamboo_syrup_flow"),
                        SolidRenderedPlaceableFluidType.create(0x00B800, () -> 0.05f))
                .properties((b) -> {
                    b.viscosity(1500).density(1400);
                }).fluidProperties((p) -> {
                    p.levelDecreasePerBlock(2).tickRate(25).slopeFindDistance(3).explosionResistance(100.0F);
                }).source(ForgeFlowingFluid.Source::new);
        BAMBOO_SYRUP_BUCKET = bamboo_syrup.bucket().properties((p) -> {
            return p.stacksTo(1);
        }).register();
        BAMBOO_SYRUP = bamboo_syrup.register();
    }

    private static class SolidRenderedPlaceableFluidType extends AllFluids.TintedFluidType {

        private Vector3f fogColor;
        private Supplier<Float> fogDistance;

        public static FluidTypeFactory create(int fogColor, Supplier<Float> fogDistance) {
            return (p, s, f) -> {
                SolidRenderedPlaceableFluidType fluidType = new SolidRenderedPlaceableFluidType(p, s, f);
                fluidType.fogColor = new Color(fogColor, false).asVectorF();
                fluidType.fogDistance = fogDistance;
                return fluidType;
            };
        }

        private SolidRenderedPlaceableFluidType(Properties properties, ResourceLocation stillTexture,
                ResourceLocation flowingTexture) {
            super(properties, stillTexture, flowingTexture);
        }

        @Override
        protected int getTintColor(FluidStack stack) {
            return NO_TINT;
        }

        /*
         * Removing alpha from tint prevents optifine from forcibly applying biome
         * colors to modded fluids (this workaround only works for fluids in the solid
         * render layer)
         */
        @Override
        public int getTintColor(FluidState state, BlockAndTintGetter world, BlockPos pos) {
            return 0x00ffffff;
        }

        @Override
        protected Vector3f getCustomFogColor() {
            return fogColor;
        }

        @Override
        protected float getFogDistanceModifier() {
            return fogDistance.get();
        }

    }
}