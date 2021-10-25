package me.maxmods.learnfabric.features.module;

public abstract class Category {
    boolean catLoaded = false;
    String name;
    public Category(String name){
        this.name = name;
    }

    public boolean isCatLoaded(){
        return catLoaded;
    }

    public void SetCatLoaded(boolean newCatLoaded){
        this.catLoaded = newCatLoaded;
    }

    public String getName(){
        return this.name;
    }
}
