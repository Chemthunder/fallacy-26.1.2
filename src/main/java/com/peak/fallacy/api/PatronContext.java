package com.peak.fallacy.api;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.network.chat.Component;

import java.util.List;
import java.util.Optional;

/**
 * @author Chemthunder
 */
public class PatronContext {

    public static void renderInventoryTooltip(GuiGraphicsExtractor context, int x, int y, Minecraft client) {
        Patron activePatron = Patron.getPatron(client.player);

        List<Component> TEXTS = List.of(
            activePatron.getName(),
            activePatron.getTitle()
        );

        context.setTooltipForNextFrame(
                client.font,
                TEXTS,
                Optional.empty(),
                x,
                y
        );
    }
}
