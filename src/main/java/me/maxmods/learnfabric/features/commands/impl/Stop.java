package me.maxmods.learnfabric.features.commands.impl;

import me.maxmods.learnfabric.features.commands.Command;
import me.maxmods.learnfabric.features.module.Module;
import me.maxmods.learnfabric.features.module.ModuleRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;

public class Stop extends Command {
    public Stop(){
        super("Stop", "Disables all modules.", "stop", "cancel", "end");
    }

    @Override
    public void execute(String[] args) {
        for(Module module : ModuleRegistry.getInstance().getAll()){
            if (module.isEnabled()){
                module.setEnabled(false);
                MinecraftClient.getInstance().player.sendMessage(Text.of(module.getName() + " was turned off."), false);
            }
        }

    }
}
