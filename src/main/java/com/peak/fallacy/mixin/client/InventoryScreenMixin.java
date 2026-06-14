package com.peak.fallacy.mixin.client;

import com.peak.fallacy.api.PatronContext;
import com.peak.fallacy.core.cca.entity.FollowerComponent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * @author Chemthunder
 */
@Mixin(value = InventoryScreen.class)
public class InventoryScreenMixin {

    @Inject(method = "extractBackground", at = @At(value = "TAIL"))
    private void fallacy$inventorySprites(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float a, CallbackInfo ci) {
        Minecraft client = Minecraft.getInstance();

        if (client.player != null) {
            if (!FollowerComponent.KEY.get(client.player).getPatron().isEmpty()) {
                PatronContext.renderInventoryTooltip(
                        graphics,
                        mouseX,
                        mouseY,
                        client
                );
            }
        }
    }
}
