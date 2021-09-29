package me.maxmods.learnfabric.features.module;



import me.maxmods.learnfabric.features.module.impl.movement.Freeze;
import me.maxmods.learnfabric.features.module.impl.movement.Hover;
import me.maxmods.learnfabric.features.module.impl.movement.Glide;

import java.util.ArrayList;
import java.util.List;

public class ModuleRegistry {

    private static ModuleRegistry INSTANCE = null;
    List<Module> MODULES = new ArrayList<>();
    public ModuleRegistry(){
        if(INSTANCE != null){
            throw new IllegalStateException("Module registry already exists");
        }
        INSTANCE = this;
        registerModules();
    }

    void register(Module module){
        MODULES.add(module);
    }

    void registerModules(){
        register(new Freeze());
        register(new Hover());
        register(new Glide());
    }

    public Module getByName(String name){
        for (Module module : MODULES){
            if (module.getName().equalsIgnoreCase(name)) return module;
        }
        return null;
    }

    public static ModuleRegistry getInstance(){
        if (INSTANCE == null) new ModuleRegistry();
        return INSTANCE;
    }

    public List<Module> getAll(){
        return MODULES;
    }



}
