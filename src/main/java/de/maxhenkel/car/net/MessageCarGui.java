package de.maxhenkel.car.net;

import java.util.UUID;

import de.maxhenkel.car.entity.car.base.EntityCarBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

public class MessageCarGui implements Message<MessageCarGui> {

    private UUID uuid;

    public MessageCarGui() {
        this.uuid = new UUID(0, 0);
    }

    public MessageCarGui(PlayerEntity player) {
        this.uuid = player.getUniqueID();
    }


    @Override
    public void executeServerSide(NetworkEvent.Context context) {
        if (!context.getSender().getUniqueID().equals(uuid)) {
            System.out.println("---------UUID was not the same-----------");
            return;
        }

        Entity e = context.getSender().getRidingEntity();
        if (e instanceof EntityCarBase) {
            ((EntityCarBase) e).openCarGUI(context.getSender());
        }
    }

    @Override
    public void executeClientSide(NetworkEvent.Context context) {

    }

    @Override
    public MessageCarGui fromBytes(PacketBuffer buf) {
        this.uuid = buf.readUniqueId();
        return this;
    }

    @Override
    public void toBytes(PacketBuffer buf) {
        buf.writeUniqueId(uuid);
    }
}
