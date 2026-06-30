package com.peak.fallacy.core.item.utilities;

import com.peak.fallacy.api.Patron;
import com.peak.fallacy.core.index.FallacyDataComponentTypes;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;

/**
 * @author Chemthunder
 */
@Environment(EnvType.CLIENT)
public class TabletTooltipDisp implements ClientTooltipComponent {
    private final ItemStack stack;

    public TabletTooltipDisp(ItemStack stack) {
        this.stack = stack;
    }

    public int getHeight(Font font) {
        return 24;
    }

    public int getWidth(Font font) {
        return 24;
    }

    public boolean showTooltipWithItemInHand() {
        return true;
    }

    public void extractImage(Font font, int x, int y, int w, int h, GuiGraphicsExtractor graphics) {
        Patron patron = stack.get(FallacyDataComponentTypes.HELD_PATRON);

        stack.set(FallacyDataComponentTypes.HELD_PATRON, patron);

        graphics.item(stack, x, y);
    }

    public void extractText(GuiGraphicsExtractor graphics, Font font, int x, int y) {
        Patron patron = stack.get(FallacyDataComponentTypes.HELD_PATRON);

        stack.set(FallacyDataComponentTypes.HELD_PATRON, patron);

        graphics.text(
                Minecraft.getInstance().font,
                patron.getSlogan(),
                x + 20,
                y + 4,
                patron.getColor()
        );
    }
}
