package com.thepandaxxl.createpanda.AIGoals;

import com.thepandaxxl.createpanda.CPBlocks;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.world.entity.animal.Panda;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class PandaMoveToBlock {
    public static class PandaMoveToBlockGoal extends MoveToBlockGoal {

        private final Panda panda;

        public PandaMoveToBlockGoal(Panda panda, double speedModifier, int searchRange) {
            super(panda, speedModifier, searchRange);
            this.panda = panda;
        }

        @Override
        protected boolean isValidTarget(LevelReader levelReader, BlockPos pos) {
            BlockState blockState = this.panda.level().getBlockState(pos);
            if (blockState.is(Blocks.BAMBOO)
                    || blockState.is(CPBlocks.BAMBOO_CREAM_CAKE.get())
                    || blockState.is(CPBlocks.BAMBOO_BAMBOO_CREAM_CAKE.get())) {
                return true;
            } else {
                return false;
            }
        }

        @Override
        public boolean canUse() {
            return !this.panda.isBaby() && super.canUse();
        }

        @Override
        public double acceptedDistance() {
            if (isReachedTarget() && tryTicks > 2) {
                panda.getNavigation().stop();
                BlockState blockState = this.panda.level().getBlockState(getMoveToTarget().below());
                if (
                    blockState.is(CPBlocks.BAMBOO_CREAM_CAKE.get())
                    || blockState.is(CPBlocks.BAMBOO_BAMBOO_CREAM_CAKE.get())
                    ) {
                    this.panda.level().setBlockAndUpdate(getMoveToTarget().below(), Blocks.AIR.defaultBlockState());
                    this.panda.playSound(SoundEvents.PANDA_EAT);
                }
            }
            return 3.0D;
        }

    }
}
