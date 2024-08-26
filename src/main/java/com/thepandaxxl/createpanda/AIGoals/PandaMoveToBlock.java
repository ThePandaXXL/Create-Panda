package com.thepandaxxl.createpanda.AIGoals;

import com.thepandaxxl.createpanda.CPBlocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.world.entity.animal.Panda;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class PandaMoveToBlock {
    public static class PandaMoveToBlockGoal extends MoveToBlockGoal {

        private final Panda panda;

        public int startEatingTick = 0;

        public PandaMoveToBlockGoal(Panda panda, double speedModifier, int searchRange) {
            super(panda, speedModifier, searchRange);
            this.panda = panda;
        }

        @SuppressWarnings("null")
        @Override
        protected boolean isValidTarget(LevelReader levelReader, BlockPos pos) {
            BlockState blockState = this.panda.level().getBlockState(pos);
            if (blockState.is(Blocks.BAMBOO)
                    || blockState.is(CPBlocks.BAMBOO_CREAM_CAKE.get())
                    || blockState.is(CPBlocks.BAMBOO_BAMBOO_CREAM_CAKE.get())
                    || blockState.is(CPBlocks.GOLDEN_BAMBOO_BAMBOO_CREAM_CAKE.get())) {
                return true;
            } else {
                return false;
            }
        }

        @Override
        public boolean canUse() {
            if (getMoveToTarget().closerToCenterThan(this.mob.position(), 3.5D)) {
                return false;
            }
            return !this.panda.isBaby() && super.canUse();
        }

        @Override
        public double acceptedDistance() {
            if (isReachedTarget() && (tryTicks > 2 || (tryTicks < 0 && startEatingTick != 0))) {

                this.panda.getNavigation().stop();

                if (startEatingTick == 0) {
                    startEatingTick = tryTicks;
                }

                BlockState blockState = this.panda.level().getBlockState(getMoveToTarget().below());
                this.panda.playSound(SoundEvents.PANDA_EAT);
                BlockParticleOption particle = new BlockParticleOption(ParticleTypes.BLOCK, blockState);
                if (this.panda.level() instanceof ServerLevel _level) {
                    _level.sendParticles(particle, getMoveToTarget().below().getX() + 0.5,
                            getMoveToTarget().below().getY() + 0.5, getMoveToTarget().below().getZ() + 0.5, 10, 0.0,
                            0.0, 0.0, 0.1);
                }

                if ((startEatingTick - tryTicks) >= 20) {
                    if (blockState.is(CPBlocks.BAMBOO_CREAM_CAKE.get())
                            || blockState.is(CPBlocks.BAMBOO_BAMBOO_CREAM_CAKE.get())
                            || blockState.is(CPBlocks.GOLDEN_BAMBOO_BAMBOO_CREAM_CAKE.get())) {
                        this.panda.level().setBlockAndUpdate(getMoveToTarget().below(), Blocks.AIR.defaultBlockState());
                        this.panda.playSound(SoundEvents.PANDA_EAT);
                    }
                    startEatingTick = 0;
                }

            }
            return 3.0D;
        }

    }
}
