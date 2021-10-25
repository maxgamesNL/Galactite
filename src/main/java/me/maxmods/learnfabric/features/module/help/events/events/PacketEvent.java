package me.maxmods.learnfabric.features.module.help.events.events;

import me.maxmods.learnfabric.features.module.help.events.Events;
import net.minecraft.network.Packet;

public class PacketEvent extends Events {
    private final Packet<?> packet;

    public PacketEvent(Packet<?> packet) {
        this.packet = packet;
    }

    public Packet<?> getPacket() {
        return packet;
    }
}
