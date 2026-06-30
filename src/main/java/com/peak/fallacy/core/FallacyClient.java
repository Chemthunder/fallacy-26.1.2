package com.peak.fallacy.core;

import com.peak.fallacy.core.client.item.tint.TabletTintSource;
import com.peak.fallacy.core.index.ext.FallacyKeybindings;
import com.peak.fallacy.core.item.utilities.TabletTooltipData;
import com.peak.fallacy.core.item.utilities.TabletTooltipDisp;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.ClientTooltipComponentCallback;
import net.minecraft.client.color.item.ItemTintSources;
import net.minecraft.world.item.ItemStack;

/**
 * @author Chemthunder
 */
public class FallacyClient implements ClientModInitializer {
    public void onInitializeClient() {
        FallacyKeybindings.clientInit();

        ItemTintSources.ID_MAPPER.put(Fallacy.id("tablet_tint"), TabletTintSource.CODEC);

        ClientTooltipComponentCallback.EVENT.register(data -> {
            if (data instanceof TabletTooltipData(ItemStack stack)) {
                return new TabletTooltipDisp(stack);
            }
            return null;
        });
    }
}
