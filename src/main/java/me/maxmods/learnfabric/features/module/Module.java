package me.maxmods.learnfabric.features.module;


import net.minecraft.client.util.math.MatrixStack;

public abstract class Module {
    boolean isEnabled = false;
    String name ,description;
    Category category;
    public Module(String name, Category category, String description){
        this.name = name;
        this.category = category;
        this.description = description;
    }
    protected abstract void enable();
    protected abstract void disable();
    public abstract void tick();
    public abstract void renderWorld(MatrixStack stack);
    public abstract void renderHud();

    public String getDescription(){
        return description;
    }
    public String getName(){
        return name;
    }
    public Category getCategory(){
        return category;
    }
    public boolean isEnabled(){
        return isEnabled;}

    public void setEnabled(boolean enabled){
        if(enabled) enable();
        else disable();
        this.isEnabled = enabled;
    }

}
