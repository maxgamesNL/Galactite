package me.maxmods.learnfabric.features.module.impl.movement;

import me.maxmods.learnfabric.features.module.Module;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;

public class Speed extends Module {
    public Speed(){super("speed", ": Makes you go brrrrt");}

    ClientPlayerEntity player = MinecraftClient.getInstance().player;
    float newMovementSpeed = 3f;

    @Override
    public void enable() {
        player.sendMessage(Text.of("Doesnt work yet. :("), false);
    }

    public void disable(){

    }

    @Override
    public void tick() {
        if(player.isSprinting()){

        }
    }

    @Override
    public void renderHud() {

    }

    @Override
    public void renderWorld(MatrixStack stack) {

    }
}
