package me.maxmods.learnfabric.features.module.impl.GUI;

import me.maxmods.learnfabric.features.gui.TestGUI;
import me.maxmods.learnfabric.features.module.Module;
import me.maxmods.learnfabric.features.module.ModuleRegistry;
import me.maxmods.learnfabric.features.module.impl.Categories.GUI;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.math.MatrixStack;

public class OpenGUI extends Module {
    public OpenGUI(){
        super("OpenGui", ModuleRegistry.getInstance().getCategoryByName("GUI"), ": Open the gui");
    }


    int x = 0;
    @Override
    protected void enable(){

    }

    @Override
    protected void disable() {

    }

    @Override
    public void tick() {
        if (x > 4) {
            MinecraftClient.getInstance().setScreen(TestGUI.INSTANCE);
            this.disable();
        }
        x++;
    }

    @Override
    public void renderWorld(MatrixStack stack) {

    }

    @Override
    public void renderHud() {

    }

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
    }
}
