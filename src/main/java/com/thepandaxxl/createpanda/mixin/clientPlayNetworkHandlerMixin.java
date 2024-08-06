package com.thepandaxxl.createpanda.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.thepandaxxl.createpanda.CPItems;

import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

@Mixin(ClientPacketListener.class)
public class clientPlayNetworkHandlerMixin {
    
    private static boolean isCPTotem(ItemStack itemStack){
        return itemStack.is(CPItems.BAMBOO_OF_UNDYING.get());
    }

    @Inject(method = "findTotem", at = @At(value = "RETURN"), cancellable = true)
    private static void getActiveBambooOfUndying(Player player, CallbackInfoReturnable<ItemStack> cir){
        for(InteractionHand hand : InteractionHand.values()) {
            ItemStack itemStack = player.getItemInHand(hand);
            if(isCPTotem(itemStack)) {
                cir.setReturnValue(itemStack);
            }
        }
    }

}
