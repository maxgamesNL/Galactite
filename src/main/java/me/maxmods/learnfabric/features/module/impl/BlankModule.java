package me.maxmods.learnfabric.features.module.impl;

import me.maxmods.learnfabric.features.module.Module;
import net.minecraft.client.util.math.MatrixStack;

public class BlankModule extends Module {
    public BlankModule(){
        super("BlankModule", "Description");
    }

    @Override
    protected void enable(){

    }

    @Override
    protected void disable() {

    }

    @Override
    public void tick() {

    }

    @Override
    public void renderWorld(MatrixStack stack) {

    }

    @Override
    public void renderHud() {

    }
}
