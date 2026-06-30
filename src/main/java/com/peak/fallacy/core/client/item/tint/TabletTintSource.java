package com.peak.fallacy.core.client.item.tint;

import com.mojang.serialization.MapCodec;
import com.peak.fallacy.api.Patron;
import com.peak.fallacy.core.index.FallacyDataComponentTypes;
import net.minecraft.client.color.item.ItemTintSource;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.util.ARGB;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import org.jspecify.annotations.Nullable;

/**
 * @author Chemthunder
 */
public record TabletTintSource() implements ItemTintSource {
    public static final MapCodec<TabletTintSource> CODEC = MapCodec.unit(new TabletTintSource());

    public int calculate(ItemStack itemStack, @Nullable ClientLevel level, @Nullable LivingEntity owner) {
        Patron patron = itemStack.get(FallacyDataComponentTypes.HELD_PATRON);
        return ARGB.color(1.0F, patron != null ? patron.getColor() : 0xffffff);
    }

    public MapCodec<? extends ItemTintSource> type() {
        return CODEC;
    }
}
