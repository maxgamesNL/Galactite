package me.maxmods.learnfabric.features.module.impl.movement;

import me.maxmods.learnfabric.features.module.Module;
import me.maxmods.learnfabric.features.module.ModuleRegistry;
import me.maxmods.learnfabric.features.module.impl.Categories.Movement;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import net.minecraft.util.math.Vec3d;

public class Glide extends Module {
    public Glide(){
        super("Glide", ModuleRegistry.getInstance().getCategoryByName("Movement"),": Makes you Glide fast!");
    }

    @Override
    protected void enable(){
        MinecraftClient.getInstance().player.sendMessage(Text.of("You are now on ice!"), false);
    }

    @Override
    protected void disable() {

    }

    @Override
    public void tick() {
        if (!MinecraftClient.getInstance().player.isSneaking()) {
            Vec3d vel = MinecraftClient.getInstance().player.getVelocity();
            double newVelX = vel.x * 2;
            double newVelY = vel.y;
            double newVelZ = vel.z * 2;
            if (newVelX > 0.5) {
                newVelX = 0.5;
            } else if (newVelZ > 0.5) {
                newVelZ = 0.5;
            } else if (newVelX < -0.5) {
                newVelX = -0.5;
            } else if (newVelZ < -0.5) {
                newVelZ = -0.5;
            }
            MinecraftClient.getInstance().player.setVelocity(newVelX, newVelY, newVelZ);
            //MinecraftClient.getInstance().player.sendMessage(Text.of(" "+newVelX), false);
        }
    }

    @Override
    public void renderWorld(MatrixStack stack) {

    }

    @Override
    public void renderHud() {

    }
}
