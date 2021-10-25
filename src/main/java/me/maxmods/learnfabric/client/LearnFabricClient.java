package me.maxmods.learnfabric.client;

import me.maxmods.learnfabric.features.gui.TestGUI;
import me.maxmods.learnfabric.features.module.impl.Categories.GUI;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;

@Environment(EnvType.CLIENT)
public class LearnFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient(){
        System.out.println("Client Initialized!");


    }


}
