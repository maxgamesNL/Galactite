package me.maxmods.learnfabric.features.module.impl.hud;

import me.maxmods.learnfabric.features.module.Module;
import me.maxmods.learnfabric.features.module.ModuleRegistry;
import me.maxmods.learnfabric.features.module.impl.Categories.HUD;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;

public class Speedometer extends Module {
    public Speedometer(){super("Speedometer", ModuleRegistry.getInstance().getCategoryByName("HUD"), ": Shows how fast you are going");}


    public void enable(){

    }
    public void disable(){

    }
    public void tick(){
        MinecraftClient.getInstance().player.sendMessage(Text.of("Your speed is: "+MinecraftClient.getInstance().player.getSpeed()), true);
    }

    @Override
    public void renderWorld(MatrixStack stack) {

    }

    @Override
    public void renderHud() {

    }
}
