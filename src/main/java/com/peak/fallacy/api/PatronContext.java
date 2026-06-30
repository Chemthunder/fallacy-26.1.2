package com.peak.fallacy.api;

import com.peak.fallacy.core.cca.entity.FollowerComponent;
import com.peak.fallacy.core.index.FallacyDataComponentTypes;
import com.peak.fallacy.core.index.FallacyItems;
import com.peak.fallacy.core.item.utilities.TabletTooltipDisp;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.components.Tooltip;
import net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;

import java.util.List;
import java.util.Optional;

/**
 * @author Chemthunder
 */
public class PatronContext {

    public static void renderInventoryTooltip(GuiGraphicsExtractor context, int x, int y, Minecraft client) {
        Patron patron = FollowerComponent.KEY.get(client.player).getPatron();

        int py = context.guiHeight() - 40;

        List<Component> components = List.of(
                patron.getName(),
                patron.getTitle(),
                patron.getSlogan()
        );

        ItemStack toRender = new ItemStack(FallacyItems.CURSED_TABLET);

        toRender.set(FallacyDataComponentTypes.HELD_PATRON, patron);

        context.item(
                toRender,
                10,
                py
        );

        for (Component c : components) {
            int index = components.indexOf(c);

            context.textWithWordWrap(
                    Minecraft.getInstance().font,
                    c,
                    30,
                    py - 5 + (index * 15),
                    c.getString().length() * 15,
                    patron.getColor()
            );
        }
    }
}
