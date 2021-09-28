package me.maxmods.learnfabric.mixin;


import net.minecraft.client.MinecraftClient;
import net.minecraft.client.RunArgs;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public class MinecraftClientMixin {

    @Inject(method = "tick", at = @At("HEAD"))
    public void tick(CallbackInfo ci){

    }
    @Inject(method = "<init>", at = @At("TAIL"))
    public void onMinecraftCreate(RunArgs args, CallbackInfo ci){
        System.out.println("Minecraft Mixins were started!");
    }
}
