package com.peak.fallacy.core.index;

import com.peak.fallacy.core.networking.serverbound.UseAbilityPayload;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;

/**
 * @author Chemthunder
 */
public interface FallacyNetworking {
    static void init() {
        PayloadTypeRegistry.serverboundPlay().register(
                UseAbilityPayload.TYPE,
                UseAbilityPayload.CODEC
        );
    }

    static void serverbound() {
        ServerPlayNetworking.registerGlobalReceiver(
                UseAbilityPayload.TYPE,
                new UseAbilityPayload.Endpoint()
        );
    }
}
