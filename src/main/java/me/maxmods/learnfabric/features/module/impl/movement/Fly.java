package me.maxmods.learnfabric.features.module.impl.movement;

import me.maxmods.learnfabric.features.module.Module;
import me.maxmods.learnfabric.features.module.ModuleRegistry;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;
import net.minecraft.text.Text;
import net.minecraft.util.math.Vec3d;

public class Fly extends Module {
    public Fly(){
        super("Fly", ModuleRegistry.getInstance().getCategoryByName("Movement"),": Makes you fly");
    }

    ClientPlayerEntity player = MinecraftClient.getInstance().player;
    ClientPlayNetworkHandler NWH = MinecraftClient.getInstance().getNetworkHandler();
    int bypassTimer = 0;



    @Override
    protected void enable() {
        bypassTimer = 0;
        player.addVelocity(0, 1, 0);
        player.getAbilities().flying = true;
        player.sendMessage(Text.of("You are flying!!"), false);
    }

    @Override
    protected void disable() {
        player.getAbilities().flying = false;
        player.sendMessage(Text.of("You landed."), false);
    }

    @Override
    public void tick() {
        bypassTimer ++;
        if (bypassTimer > 10) {
            bypassTimer = 0;
            Vec3d velocity = player.getVelocity();
            NWH.sendPacket(new PlayerMoveC2SPacket.PositionAndOnGround(player.getX(), player.getY() - 0.2, player.getZ(), false));
            NWH.sendPacket(new PlayerMoveC2SPacket.PositionAndOnGround(player.getX(), player.getY() + 0.2, player.getZ(), false));

        }
        if (player.getY() % 1 == 0 ){
            if (player.isOnGround()){
                if (player.getVelocity().y == 0){
                    this.setEnabled(false);
                }
            }
        }

    }

    @Override
    public void renderWorld(MatrixStack stack) {

    }

    @Override
    public void renderHud() {

    }
}
