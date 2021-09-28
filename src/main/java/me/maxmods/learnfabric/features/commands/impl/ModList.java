package me.maxmods.learnfabric.features.commands.impl;

import me.maxmods.learnfabric.features.commands.Command;
import me.maxmods.learnfabric.features.module.Module;
import me.maxmods.learnfabric.features.module.ModuleRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;

public class ModList extends Command {
    public ModList(){
        super("ModList", "Tells all Modules", "Modules", "Mods", "List");
    }

    @Override
    public void execute(String[] args) {
        for (Module module : ModuleRegistry.getInstance().getAll()){
            MinecraftClient.getInstance().player.sendMessage(Text.of(module.getName() + module.getDescription()), false);
        }
    }
}
