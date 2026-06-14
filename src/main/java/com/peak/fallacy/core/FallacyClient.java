package com.peak.fallacy.core;

import com.peak.fallacy.core.client.item.tint.TabletTintSource;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.color.item.ItemTintSources;

/**
 * @author Chemthunder
 */
public class FallacyClient implements ClientModInitializer {
    public void onInitializeClient() {
        ItemTintSources.ID_MAPPER.put(Fallacy.id("tablet_tint"), TabletTintSource.CODEC);
    }
}
