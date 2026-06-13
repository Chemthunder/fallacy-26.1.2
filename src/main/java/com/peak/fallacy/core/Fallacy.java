package com.peak.fallacy.core;

import com.peak.fallacy.core.index.FallacyItems;
import com.peak.fallacy.core.index.FallacyRegistries;
import com.peak.fallacy.core.index.FallacyPatrons;
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

		LOGGER.info("Hello Fabric world!");
	}

    public static Identifier id(String path) {
        return Identifier.fromNamespaceAndPath(MOD_ID, path);
    }
}

/**
 * Cult mod if it was good
 */