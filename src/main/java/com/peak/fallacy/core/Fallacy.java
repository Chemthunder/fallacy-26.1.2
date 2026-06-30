package com.peak.fallacy.core;

import com.peak.fallacy.core.index.*;
import net.acoyt.acornlib.api.ALib;
import net.fabricmc.api.ModInitializer;
import net.minecraft.resources.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Chemthunder
 */
public class Fallacy implements ModInitializer {
	public static final String MOD_ID = "fallacy";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public void onInitialize() {
        FallacyRegistries.init();
        FallacyPatrons.init();
        FallacyItems.init();
        FallacyCreativeModeTabs.init();
        FallacyDataComponentTypes.init();
        FallacyNetworking.init();

        FallacyNetworking.serverbound();

		LOGGER.info("Registration Completed");

        ALib.registerModIcon(
                MOD_ID,
                Fallacy.id("textures/item/cursed_tablet_guy.png")
        );

        ALib.registerModMenu(
                MOD_ID,
                0xFF4e1e3b
        );
	}

    public static Identifier id(String path) {
        return Identifier.fromNamespaceAndPath(MOD_ID, path);
    }
}