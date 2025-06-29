package com.tenbcpu.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FishingBobberEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.Vec3d;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(FishingBobberEntity.class)
public class FishingBobberEntityMixin {

    private boolean velocityModified = false;

    @Inject(method = "tick", at = @At("HEAD"))
    private void modifyVelocity(CallbackInfo ci) {
        if (velocityModified) return; // Only modify once

        FishingBobberEntity self = (FishingBobberEntity)(Object)this;
        Entity owner = self.getOwner();

        if (owner instanceof PlayerEntity player) {
            ItemStack stack = player.getMainHandStack();

            if (stack.getItem() == Items.FISHING_ROD && stack.hasNbt() && stack.getNbt().contains("Power")) {
                double power = stack.getNbt().getDouble("Power");
                Vec3d vel = self.getVelocity();
                self.setVelocity(vel.multiply(power));
                velocityModified = true;
            }
        }
    }
}