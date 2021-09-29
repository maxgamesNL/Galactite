package me.maxmods.learnfabric.features.module.impl.movement;

import me.maxmods.learnfabric.features.module.Module;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;

public class AutoSprint extends Module {
    public AutoSprint(){super(" Autosprint", ": Makes you automatically sprint.");}
    ClientPlayerEntity player = MinecraftClient.getInstance().player;


    public void enable(){
        player.sendMessage(Text.of("Autosprint was toggled!"), false);
    }
    public void disable(){

    }

    @Override
    public void tick() {
        if (player.getSpeed() > 0){
            player.setSprinting(true);

        }
    }

    @Override
    public void renderWorld(MatrixStack stack) {

    }

    @Override
    public void renderHud() {

    }
}
