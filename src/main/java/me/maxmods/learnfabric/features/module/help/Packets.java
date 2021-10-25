package me.maxmods.learnfabric.features.module.help;

import net.minecraft.client.MinecraftClient;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

public class Packets {
    public static void sendServerSideLookPacket(Vec3d target1){
        double vec = 57.2957763671875;
        Vec3d target = target1.subtract(MinecraftClient.getInstance().player.getEyePos());
        double square = Math.sqrt(target.x * target.x + target.z * target.z);
        float pitch = MathHelper.wrapDegrees((float) (-(MathHelper.atan2(target.y, square) * vec)));
        float yaw = MathHelper.wrapDegrees((float) (MathHelper.atan2(target.z, target.x) * vec) - 90.0F);
        PlayerMoveC2SPacket p = new PlayerMoveC2SPacket.LookAndOnGround(yaw, pitch, MinecraftClient.getInstance().player.isOnGround());
        MinecraftClient.getInstance().getNetworkHandler().sendPacket(p);
    }
}
