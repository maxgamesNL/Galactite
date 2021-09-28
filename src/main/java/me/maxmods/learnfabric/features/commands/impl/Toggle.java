package me.maxmods.learnfabric.features.commands.impl;

import me.maxmods.learnfabric.features.commands.Command;
import me.maxmods.learnfabric.features.module.Module;
import me.maxmods.learnfabric.features.module.ModuleRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Overwrite;

public class Toggle extends Command {
    public Toggle(){
        super("Toggle", "Toggles Modules", "toggle", "t", "enable", "disable");
    }

    public void execute(String[] args){
        if (args.length==0){
            MinecraftClient.getInstance().player.sendMessage(Text.of("You need to specify a module!"), false);
            return;
        }
        Module toToggle = ModuleRegistry.getInstance().getByName(String.join(" ", args));
        if(toToggle == null){
            MinecraftClient.getInstance().player.sendMessage(Text.of("Didnt find that module."), false);
            return;
        }
        toToggle.setEnabled(!toToggle.isEnabled());
        System.out.println(toToggle.getName()+":enabled "+!toToggle.isEnabled()+"-> "+toToggle.isEnabled());
    }
}
