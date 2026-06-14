package com.peak.fallacy.core.item;

import com.peak.fallacy.api.Patron;
import com.peak.fallacy.core.index.FallacyDataComponentTypes;
import com.peak.fallacy.core.index.FallacyPatrons;
import com.peak.fallacy.core.index.FallacyRegistries;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import org.jspecify.annotations.Nullable;

import java.util.Random;
import java.util.function.Consumer;

/**
 * @author Chemthunder
 */
@SuppressWarnings("deprecation")
public class CursedTabletItem extends Item {
    public CursedTabletItem(Properties properties) {
        super(properties
                .component(
                        FallacyDataComponentTypes.HELD_PATRON, FallacyPatrons.EMPTY
                )
        );
    }

    public void inventoryTick(ItemStack itemStack, ServerLevel level, Entity owner, @Nullable EquipmentSlot slot) {
        Patron patron = itemStack.get(FallacyDataComponentTypes.HELD_PATRON);

        if (patron.isEmpty()) {
            Holder.Reference<Patron> toSet = FallacyRegistries.PATRON.get(new Random().nextInt(FallacyRegistries.PATRON.size())).get();

            itemStack.set(FallacyDataComponentTypes.HELD_PATRON, toSet.value());
        }
        super.inventoryTick(itemStack, level, owner, slot);
    }

    public void appendHoverText(ItemStack itemStack, TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag tooltipFlag) {
        Patron patron = itemStack.get(FallacyDataComponentTypes.HELD_PATRON);

        if (!patron.isEmpty()) {
            builder.accept(Component.literal("Tablet of ").withStyle(ChatFormatting.DARK_GRAY).append(patron.getName()).withColor(patron.getColor()));
            builder.accept(patron.getTitle().copy().withStyle(ChatFormatting.DARK_GRAY));

            if (patron.isCursed()) {
                builder.accept(Component.translatable("item.fallacy.cursed_tablet.cursed").withStyle(ChatFormatting.DARK_GRAY));
            }
        }
    }

    public Component getName(ItemStack itemStack) {
        if (itemStack.get(FallacyDataComponentTypes.HELD_PATRON).isCursed()) {
            return super.getName(itemStack).copy().withStyle(ChatFormatting.RED);
        }
        return super.getName(itemStack);
    }
}
