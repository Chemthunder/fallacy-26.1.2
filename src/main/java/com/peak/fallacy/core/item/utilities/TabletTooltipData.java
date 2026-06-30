package com.peak.fallacy.core.item.utilities;

import net.minecraft.world.inventory.tooltip.TooltipComponent;
import net.minecraft.world.item.ItemStack;

/**
 * @author Chemthunder
 */
public record TabletTooltipData(ItemStack stack) implements TooltipComponent {}