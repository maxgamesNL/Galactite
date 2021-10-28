package me.maxmods.learnfabric.features.module.impl.misc;

import me.maxmods.learnfabric.features.module.Module;
import me.maxmods.learnfabric.features.module.ModuleRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;

public class Panic extends Module {

    public Panic() {
        super("Panic", ModuleRegistry.getInstance().getCategoryByName("Misc"), "Disables all modules!");
    }
    private final ClientPlayerEntity player = MinecraftClient.getInstance().player;

    @Override
    protected void enable() {
        player.sendMessage(Text.of("Panic!!!"), false);
    }

    @Override
    protected void disable() {
        player.sendMessage(Text.of("All modules disabled!"), false);
    }

    @Override
    public void tick() {
        for (Module module : ModuleRegistry.getInstance().getAll()){
            if (module.isEnabled()){
                module.setEnabled(false);
            }
        }
    }

    @Override
    public void renderWorld(MatrixStack stack) {

    }

    @Override
    public void renderHud() {

    }
}
