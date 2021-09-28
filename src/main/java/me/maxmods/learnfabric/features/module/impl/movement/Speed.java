package me.maxmods.learnfabric.features.module.impl.movement;

import me.maxmods.learnfabric.features.module.Module;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.Vec3d;

public class Speed extends Module {
    public Speed(){
        super("Speed", ": Makes you go brrrrt!");
    }

    @Override
    protected void enable(){

    }

    @Override
    protected void disable() {

    }

    @Override
    public void tick() {
        Vec3d vel = MinecraftClient.getInstance().player.getVelocity();
        double newVelX = vel.x * 2;
        double newVelY = vel.y;
        double newVelZ = vel.z * 2;
        if (newVelX > 1){
            newVelX = 1;
        }
        if (newVelY > 1){
            newVelY = 1;
        }
        MinecraftClient.getInstance().player.setVelocity(newVelX, newVelY, newVelZ);

    }

    @Override
    public void renderWorld(MatrixStack stack) {

    }

    @Override
    public void renderHud() {

    }
}
