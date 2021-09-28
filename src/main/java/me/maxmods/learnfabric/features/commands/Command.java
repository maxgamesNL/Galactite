package me.maxmods.learnfabric.features.commands;
//https://clients.0x150.cf/basics/command-handler
public abstract class Command {
    String name;
    String description;
    String[] aliases;
    public Command(String name, String description, String ...aliases){
        this.name = name;
        this.description = description;
        this.aliases = aliases;
    }

    public abstract void execute(String[] args);

    public String getDescription(){
        return description;
    }
    public String getName(){
        return name;
    }
    public String[] getAliases(){
        return aliases;
    }
}
