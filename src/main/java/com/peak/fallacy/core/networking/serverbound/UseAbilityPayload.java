package com.peak.fallacy.core.networking.serverbound;

import com.mojang.datafixers.kinds.IdF;
import com.peak.fallacy.api.Patron;
import com.peak.fallacy.core.Fallacy;
import com.peak.fallacy.core.cca.entity.FollowerComponent;
import io.netty.buffer.ByteBuf;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.entity.player.Player;
import org.ladysnake.cca.internal.base.MorePacketCodecs;

/**
 * @author Chemthunder
 */
public record UseAbilityPayload() implements CustomPacketPayload {
    public static final Type<UseAbilityPayload> TYPE = new Type<>(Fallacy.id("use_ability"));
    public static final StreamCodec<RegistryFriendlyByteBuf, UseAbilityPayload> CODEC = StreamCodec.unit(new UseAbilityPayload());

    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void send() {
        ClientPlayNetworking.send(new UseAbilityPayload());
    }

    public static final class Endpoint implements ServerPlayNetworking.PlayPayloadHandler<UseAbilityPayload> {
        public void receive(UseAbilityPayload useAbilityPayload, ServerPlayNetworking.Context context) {
            Player player = context.player();

            Patron patron = FollowerComponent.KEY.get(player).getPatron();

            if (patron != null) {
                patron.onUseKeybind(player, player.level());

                Fallacy.LOGGER.info("Ran payload");
            }
        }
    }
}
