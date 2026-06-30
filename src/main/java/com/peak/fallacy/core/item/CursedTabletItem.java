package com.peak.fallacy.core.item;

import com.peak.fallacy.api.Patron;
import com.peak.fallacy.core.Fallacy;
import com.peak.fallacy.core.cca.entity.FollowerComponent;
import com.peak.fallacy.core.index.FallacyDataComponentTypes;
import com.peak.fallacy.core.index.FallacyPatrons;
import com.peak.fallacy.core.index.FallacyRegistries;
import com.peak.fallacy.core.item.utilities.TabletTooltipData;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.tooltip.TooltipComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Blocks;
import org.jspecify.annotations.Nullable;

import java.util.Optional;
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

    public InteractionResult useOn(UseOnContext context) {
        Player player = context.getPlayer();
        ItemStack stack = context.getItemInHand();

        Patron patron = stack.get(FallacyDataComponentTypes.HELD_PATRON);

        if (patron != null && !patron.isEmpty()) {
            if (context.getLevel().getBlockState(context.getClickedPos()).getBlock() == Blocks.LODESTONE) {
                Fallacy.LOGGER.info("hi!");

                FollowerComponent.KEY.get(player).setPatron(stack.get(FallacyDataComponentTypes.HELD_PATRON));
                stack.shrink(1);
            }
        }
        return super.useOn(context);
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
        }
    }

    public Component getName(ItemStack itemStack) {
        if (itemStack.get(FallacyDataComponentTypes.HELD_PATRON).isCursed()) {
            return super.getName(itemStack).copy().withStyle(ChatFormatting.RED);
        }
        return super.getName(itemStack);
    }

    public Optional<TooltipComponent> getTooltipImage(ItemStack itemStack) {
        return Optional.of(new TabletTooltipData(itemStack));
    }
}
