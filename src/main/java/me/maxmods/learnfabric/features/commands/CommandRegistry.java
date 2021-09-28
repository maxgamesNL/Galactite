package me.maxmods.learnfabric.features.commands;
//https://clients.0x150.cf/basics/modules#making-the-modules
import me.maxmods.learnfabric.features.commands.impl.ModList;
import me.maxmods.learnfabric.features.commands.impl.Test;
import me.maxmods.learnfabric.features.commands.impl.Toggle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandRegistry {
    private static CommandRegistry INSTANCE = null;
    List<Command> COMMANDS = new ArrayList<>();
    public CommandRegistry(){
        if (INSTANCE != null){
        throw new IllegalStateException("Command registry already exists!");
        }
        INSTANCE = this;
        registerCommands();
    }
    void register(Command command){
        COMMANDS.add(command);
    }
    void registerCommands(){
        register(new Test());
        register(new Toggle());
        register(new ModList());
    }

    public Command getByName(String name) {
        for (Command command : COMMANDS) {
            if (command.getName().equalsIgnoreCase(name)) return command;
        }
        return null;
    }
    public Command getByAlias(String search) {
        for (Command command : COMMANDS) {
            if (Arrays.stream(command.aliases).anyMatch(s -> s.equalsIgnoreCase(search))) return command;
        }
        return null;
    }
    public static CommandRegistry getInstance(){
        if (INSTANCE == null) new CommandRegistry();
        return INSTANCE;
    }
}
