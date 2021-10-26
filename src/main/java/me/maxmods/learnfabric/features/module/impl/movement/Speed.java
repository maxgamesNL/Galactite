package me.maxmods.learnfabric.features.module.impl.movement;

import me.maxmods.learnfabric.features.module.Module;
import me.maxmods.learnfabric.features.module.ModuleRegistry;
import me.maxmods.learnfabric.features.module.impl.Categories.Movement;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.widget.ClickableWidget;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.text.Text;

public class Speed extends Module {
    public Speed(){super("speed", ModuleRegistry.getInstance().getCategoryByName("Movement"), ": Makes you go brrrrt");}

    ClientPlayerEntity player = MinecraftClient.getInstance().player;
    EntityAttributeInstance playerSpeed = MinecraftClient.getInstance().player.getAttributes().getCustomInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED);
    double baseSprintSpeed = 1;

    @Override
    public void enable() {
        player.sendMessage(Text.of("Speed is enabled"), false);
    }

    public void disable(){
        player.sendMessage(Text.of("Speed is disabled"), false);
    }

    @Override
    public void tick() {
        if(player.isSprinting()){
            playerSpeed.setBaseValue(baseSprintSpeed/2);
        }
    }



    @Override
    public void renderHud() {

    }

    @Override
    public void renderWorld(MatrixStack stack) {

    }
}
