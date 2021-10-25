package me.maxmods.learnfabric.features.module.impl.movement;

import me.maxmods.learnfabric.features.module.Module;
import me.maxmods.learnfabric.features.module.ModuleRegistry;
import me.maxmods.learnfabric.features.module.impl.Categories.Movement;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.widget.ClickableWidget;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.text.Text;

public class Speed extends Module {
    public Speed(){super("speed", ModuleRegistry.getInstance().getCategoryByName("Movement"), ": Makes you go brrrrt");}

    ClientPlayerEntity player = MinecraftClient.getInstance().player;

    @Override
    public void enable() {
        player.sendMessage(Text.of("Not ready yet"), false);
        this.disable();
    }

    public void disable(){

    }

    @Override
    public void tick() {
        if(player.isSprinting()){

        }
    }



    @Override
    public void renderHud() {

    }

    @Override
    public void renderWorld(MatrixStack stack) {

    }
}
