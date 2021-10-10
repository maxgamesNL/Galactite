package me.maxmods.learnfabric.features.module;



import me.maxmods.learnfabric.features.module.impl.Categories.GUI;
import me.maxmods.learnfabric.features.module.impl.Categories.HUD;
import me.maxmods.learnfabric.features.module.impl.Categories.Movement;
import me.maxmods.learnfabric.features.module.impl.GUI.OpenGUI;
import me.maxmods.learnfabric.features.module.impl.hud.Speedometer;
import me.maxmods.learnfabric.features.module.impl.movement.*;

import java.util.ArrayList;
import java.util.List;

public class ModuleRegistry {

    private static ModuleRegistry INSTANCE = null;
    List<Module> MODULES = new ArrayList<>();
    List<Category> CATEGORIES = new ArrayList<>();
    public ModuleRegistry(){
        if(INSTANCE != null){
            throw new IllegalStateException("Module registry already exists");
        }
        INSTANCE = this;
        registerCategories();
        registerModules();
    }

    void register(Module module){
        MODULES.add(module);
    }

    void registerCategories(){
        CATEGORIES.add(new GUI());
        CATEGORIES.add(new Movement());
        CATEGORIES.add(new HUD());
    }

    void registerModules(){
        //movement
        register(new Freeze());
        register(new Hover());
        register(new Glide());
        register(new AutoSprint());
        register(new Speed());
        //hud
        register(new Speedometer());
        //GUI
        register(new OpenGUI());
    }

    public Module getByName(String name){
        for (Module module : MODULES){
            if (module.getName().equalsIgnoreCase(name)) return module;
        }
        return null;
    }

    public Category getCategoryByName(String name){
        for (Category category : CATEGORIES){
            if (category.getName().equalsIgnoreCase(name)) return category;
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

    public List<Category> getCATEGORIES(){return CATEGORIES;}



}
