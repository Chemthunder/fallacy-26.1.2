package com.peak.fallacy.core.index.ext;

import com.mojang.blaze3d.platform.InputConstants;
import com.peak.fallacy.core.Fallacy;
import com.peak.fallacy.core.networking.serverbound.UseAbilityPayload;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keymapping.v1.KeyMappingHelper;
import net.minecraft.client.KeyMapping;
import org.lwjgl.glfw.GLFW;

/**
 * @author Chemthunder
 */
public class FallacyKeybindings {
    public static final KeyMapping.Category MOD_CATEGORY = new KeyMapping.Category(Fallacy.id("fallacy"));

    public static KeyMapping USE_ABILITY;

    public static void clientInit() {
        USE_ABILITY = KeyMappingHelper.registerKeyMapping(new KeyMapping(
                "key.fallacy.use_ability",
                InputConstants.Type.KEYSYM,
                GLFW.GLFW_KEY_G,
                MOD_CATEGORY
        ));

        ClientTickEvents.START_CLIENT_TICK.register(minecraft -> {
            if (minecraft.player != null && USE_ABILITY.isDown()) {
                try {
                    UseAbilityPayload.send();
                } catch (Exception e) {
                    Fallacy.LOGGER.info("Failed to send UseAbilityPayload");
                }
            }
        });
    }
}
