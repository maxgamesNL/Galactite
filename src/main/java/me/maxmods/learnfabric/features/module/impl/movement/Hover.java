package me.maxmods.learnfabric.features.module.impl.movement;

import me.maxmods.learnfabric.features.module.Module;
import me.maxmods.learnfabric.features.module.ModuleRegistry;
import me.maxmods.learnfabric.features.module.impl.Categories.Movement;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;

public class Hover extends Module {
    private static KeyBinding keyBinding;
    public Hover(){
        super("Hover", ModuleRegistry.getInstance().getCategoryByName("Movement"),": Makes you hover at a fixed height!");
    }

    @Override
    protected void enable(){
        MinecraftClient.getInstance().player.sendMessage(Text.of("Hoverboard has turned on!"), true);
    }

    @Override
    protected void disable() {

    }

    @Override
    public void tick() {
        double velX = MinecraftClient.getInstance().player.getVelocity().x;
        double velZ = MinecraftClient.getInstance().player.getVelocity().z;
        MinecraftClient.getInstance().player.setVelocity(velX, 0, velZ);
    }

    @Override
    public void renderWorld(MatrixStack stack) {

    }

    @Override
    public void renderHud() {

    }
}
