package me.maxmods.learnfabric.features.module.impl.movement;

import me.maxmods.learnfabric.features.module.Module;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;

public class Freeze extends Module {
    public Freeze(){
        super("Freeze", ": Sets velocity to 0");
    }

    @Override
    protected void enable(){
        MinecraftClient.getInstance().player.sendMessage(Text.of("Freeze was toggled!"), false);
    }

    @Override
    protected void disable() {

    }

    @Override
    public void tick() {
        MinecraftClient.getInstance().player.setVelocity(0,0,0);
        MinecraftClient.getInstance().player.sendMessage(Text.of("Tick of Freeze passed!"), false);
    }
//MinecraftClient.getInstance().player.sendMessage(Text.of("Tick of Freeze passed!"), true);
    @Override
    public void renderWorld(MatrixStack stack) {

    }

    @Override
    public void renderHud() {

    }
}
