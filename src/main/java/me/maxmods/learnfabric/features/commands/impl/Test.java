package me.maxmods.learnfabric.features.commands.impl;

import me.maxmods.learnfabric.features.commands.Command;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Overwrite;

public class Test extends Command {
    public Test(){
        super("Test", "Amogus", "test", "sus", "amog", "stuff");
    }

    public void execute(String[] args){
        MinecraftClient.getInstance().player.sendMessage(Text.of("amog"), false);
    }
}
