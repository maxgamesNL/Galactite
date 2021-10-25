package me.maxmods.learnfabric.features.module.impl.combat;

import me.maxmods.learnfabric.features.module.Module;
import me.maxmods.learnfabric.features.module.ModuleRegistry;
import me.maxmods.learnfabric.features.module.help.Packets;
import me.maxmods.learnfabric.features.module.help.Rotations;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;

import java.util.ArrayList;
import java.util.List;

public class KillAura extends Module {
    public KillAura(){
        super("KillAura", ModuleRegistry.getInstance().getCategoryByName("Combat"),": Kills everyone in hitrange");
    }
    ClientPlayNetworkHandler NWH = MinecraftClient.getInstance().getNetworkHandler();
    ClientPlayerEntity player = MinecraftClient.getInstance().player;

    @Override
    protected void enable() {
        player.sendMessage(Text.of("KillAura enabled"), false);
    }

    @Override
    protected void disable() {
        player.sendMessage(Text.of("KillAura disabled"), false);
    }

    @Override
    public void tick() {
        List<Entity> attackableEntities = new ArrayList<>();

            for (Entity entity : MinecraftClient.getInstance().world.getEntities()){
                if (!entity.isAttackable()){continue;}
                if (!entity.isAlive()){continue;}
                if (entity.getUuid() == player.getUuid()) continue;
                if(entity.getPos().distanceTo(player.getPos()) < 5) {
                    attackableEntities.add(entity);
                }
            }
            for (Entity attack : attackableEntities){
                if (!attack.isAttackable()){continue;}
                if (!attack.isAlive()){continue;}
                Packets.sendServerSideLookPacket(attack.getEyePos());
                Rotations.lookAtV3(attack.getPos().add(0, attack.getHeight() / 2, 0));
                if(player.getAttackCooldownProgress(1) == 1){
                    MinecraftClient.getInstance().interactionManager.attackEntity(player, attack);
                    player.swingHand(Hand.MAIN_HAND);
                }
        }
            attackableEntities.clear();
    }

    @Override
    public void renderWorld(MatrixStack stack) {

    }

    @Override
    public void renderHud() {

    }
}
