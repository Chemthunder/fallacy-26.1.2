package com.peak.fallacy.api;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipComponent;
import net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipPositioner;
import net.minecraft.client.gui.screens.inventory.tooltip.MenuTooltipPositioner;
import net.minecraft.network.chat.Component;
import net.minecraft.world.inventory.tooltip.TooltipComponent;

import java.util.List;

/**
 * @author Chemthunder
 */
public class PatronContext {

    public static void renderInventoryWhatnots(GuiGraphicsExtractor context, int x, int y, Minecraft client) {
        context.setTooltipForNextFrame(
                client.font,
                Component.literal("hi"),
                x,
                y
        );
    }
}
