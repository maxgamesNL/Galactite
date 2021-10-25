package me.maxmods.learnfabric.features.commands.impl;

import me.maxmods.learnfabric.features.commands.Command;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.text.Text;

public class Help extends Command {
    public Help(){super("Help", "Helps people", "guide", "hello", "galactite", "help");}

    @Override
    public void execute(String[] args) {
        ClientPlayerEntity player = MinecraftClient.getInstance().player;
        player.sendMessage(Text.of("---------------------------------------------------------"), false);
        player.sendMessage(Text.of("Hello, this is Galactite."), false);
        player.sendMessage(Text.of("This client was made by maxgames_NL, also known as MaxMods."), false);
        player.sendMessage(Text.of("To type commands type an ~ and then the command."), false);
        player.sendMessage(Text.of("For a list of modules type ~modlist"), false);
        player.sendMessage(Text.of("To toggle the modules type ~toggle {the name of the module}"), false);
        player.sendMessage(Text.of("---------------------------------------------------------"), false);

    }
}
