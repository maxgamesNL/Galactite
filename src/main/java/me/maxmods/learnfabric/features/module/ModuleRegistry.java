package me.maxmods.learnfabric.features.module;



import me.maxmods.learnfabric.features.gui.TestGUI;
import me.maxmods.learnfabric.features.module.impl.Categories.*;
import me.maxmods.learnfabric.features.module.impl.GUI.OpenGUI;
import me.maxmods.learnfabric.features.module.impl.combat.KillAura;
import me.maxmods.learnfabric.features.module.impl.exploits.NoFall;
import me.maxmods.learnfabric.features.module.impl.exploits.Phase;
import me.maxmods.learnfabric.features.module.impl.hud.Speedometer;
import me.maxmods.learnfabric.features.module.impl.misc.Panic;
import me.maxmods.learnfabric.features.module.impl.movement.*;
import net.minecraft.client.gui.screen.Screen;

import java.util.ArrayList;
import java.util.List;

public class ModuleRegistry {

    private static ModuleRegistry INSTANCE = null;
    List<Module> MODULES = new ArrayList<>();
    List<Category> CATEGORIES = new ArrayList<>();
    public Screen loadedGUI = new TestGUI();
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
        CATEGORIES.add(new Combat());
        CATEGORIES.add(new Exploit());
        CATEGORIES.add(new Misc());

    }

    void registerModules(){
        //movement
        register(new Freeze());
        register(new Hover());
        register(new Glide());
        register(new AutoSprint());
        register(new Speed());
        register(new Fly());
        //hud
        register(new Speedometer());
        //GUI
        register(new OpenGUI());
        //Combat
        register(new KillAura());
        //Exploits
        register(new NoFall());
        register(new Phase());
        //Misc
        register(new Panic());
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
