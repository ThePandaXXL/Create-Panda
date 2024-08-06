package com.thepandaxxl.createpanda.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.thepandaxxl.createpanda.CPItems;

import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;

@Mixin(LivingEntity.class)
public abstract class livingEntityMixin extends Entity {

    @Shadow
    public native ItemStack getItemInHand(InteractionHand hand_1);

    @Shadow
    public native void setHealth(float health);

    @Shadow
    public native boolean removeAllEffects();

    @Shadow
    public native boolean addEffect(MobEffectInstance statusEffectInstance_1);

    protected livingEntityMixin(EntityType<?> entityType_1, Level world_1) {
        super(entityType_1, world_1);
    }

    static class getTotem {

        public static ItemStack getTotemStack(Entity entity) {

            ItemStack offhandStack = ((livingEntityMixin) entity).getItemInHand(InteractionHand.OFF_HAND);
            ItemStack mainhandStack = ((livingEntityMixin) entity).getItemInHand(InteractionHand.MAIN_HAND);

            if (offhandStack.getItem() == CPItems.BAMBOO_OF_UNDYING.get()) {
                return offhandStack;
            } else if (mainhandStack.getItem() == CPItems.BAMBOO_OF_UNDYING.get()) {
                return mainhandStack;
            }
            return new ItemStack(Items.TOTEM_OF_UNDYING);

        }

        public static EquipmentSlot getTotemEquipmentSlot(Entity entity) {

            ItemStack offhandStack = ((livingEntityMixin) entity).getItemInHand(InteractionHand.OFF_HAND);
            ItemStack mainhandStack = ((livingEntityMixin) entity).getItemInHand(InteractionHand.MAIN_HAND);
            
            if (offhandStack.getItem() == CPItems.BAMBOO_OF_UNDYING.get()) {
                return EquipmentSlot.OFFHAND;
            } else if (mainhandStack.getItem() == CPItems.BAMBOO_OF_UNDYING.get()) {
                return EquipmentSlot.MAINHAND;
            }
            return EquipmentSlot.OFFHAND;

        }

    }

    @SuppressWarnings("null")
    @Inject(at = @At("HEAD"), method = "checkTotemDeathProtection", cancellable = true)
    public void useBambooOfUndying(DamageSource damageSource_1, CallbackInfoReturnable<Boolean> callback) {

        Entity entity = this;
        Boolean isTotem = false;
        ItemStack stack = getTotem.getTotemStack(entity);
        EquipmentSlot slot = getTotem.getTotemEquipmentSlot(entity);
        if (!stack.is(Items.TOTEM_OF_UNDYING)) {
            isTotem = true;
        }

        if (entity instanceof Player) {

            Player player = (Player) entity;

            if (isTotem) {

                if (damageSource_1.is(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
                    callback.setReturnValue(false);
                } else {

                    this.setHealth(1.0F);
                    this.removeAllEffects();
                    this.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 900, 1));
                    this.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 100, 1));
                    this.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 800, 0));
                    this.level().broadcastEntityEvent(this, (byte) 35);

                    stack.hurtAndBreak(1, player,
                            e -> e.broadcastBreakEvent(slot));

                    callback.setReturnValue(true);

                }

            }
        }

    }

}
