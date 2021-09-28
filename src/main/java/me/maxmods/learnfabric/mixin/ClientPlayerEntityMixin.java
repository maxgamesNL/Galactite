package me.maxmods.learnfabric.mixin;


import me.maxmods.learnfabric.features.module.Module;
import me.maxmods.learnfabric.features.module.ModuleRegistry;
import net.minecraft.client.network.ClientPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayerEntity.class)
public class ClientPlayerEntityMixin {
    @Inject(method="tick",at=@At("HEAD"))
    public void preTick(CallbackInfo ca){
        for(Module module : ModuleRegistry.getInstance().getAll()){
            if (module.isEnabled()) module.tick();
        }
    }
}
