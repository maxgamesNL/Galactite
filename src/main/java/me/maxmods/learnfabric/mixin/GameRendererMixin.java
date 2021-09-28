package me.maxmods.learnfabric.mixin;


import me.maxmods.learnfabric.features.module.Module;
import me.maxmods.learnfabric.features.module.ModuleRegistry;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameRenderer.class)
public class GameRendererMixin {
    @Inject(
            at = {@At(value = "FIELD",
                    target = "Lnet/minecraft/client/render/GameRenderer;renderHand:Z",
                    opcode = Opcodes.GETFIELD,
                    ordinal = 0)},
            method = {
                    "renderWorld(FJLnet/minecraft/client/util/math/MatrixStack;)V"})
    void onRenderWorld(float tickDelta, long limitTime, MatrixStack matrix, CallbackInfo ci) {
        for (Module module : ModuleRegistry.getInstance().getAll()) {
            if (module.isEnabled()) module.renderWorld(matrix);
        }
    }
}
