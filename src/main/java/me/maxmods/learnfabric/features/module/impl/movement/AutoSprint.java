package me.maxmods.learnfabric.features.module.impl.movement;

import me.maxmods.learnfabric.features.module.Module;
import me.maxmods.learnfabric.features.module.ModuleRegistry;
import me.maxmods.learnfabric.features.module.impl.Categories.Movement;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;

public class AutoSprint extends Module {
    public AutoSprint(){super("Autosprint", ModuleRegistry.getInstance().getCategoryByName("Movement"),": Makes you automatically sprint.");}
    ClientPlayerEntity player = MinecraftClient.getInstance().player;


    public void enable(){
        player.sendMessage(Text.of("Autosprint was turned on!"), false);
    }
    public void disable(){
        player.sendMessage(Text.of("Autosprint was turned off."), false);
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
