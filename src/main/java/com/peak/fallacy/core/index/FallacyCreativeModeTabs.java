package com.peak.fallacy.core.index;

import com.peak.fallacy.api.Patron;
import com.peak.fallacy.core.Fallacy;
import net.acoyt.acornlib.api.registrants.CreativeModeTabRegistrant;
import net.acoyt.acornlib.api.util.MiscUtils;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTabOutput;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import java.util.Optional;
import java.util.Random;

/**
 * @author Chemthunder
 */
public interface FallacyCreativeModeTabs {
    CreativeModeTabRegistrant TABS = new CreativeModeTabRegistrant(Fallacy.MOD_ID);

    ResourceKey<CreativeModeTab> TAB_KEY = ResourceKey.create(BuiltInRegistries.CREATIVE_MODE_TAB.key(), Fallacy.id(Fallacy.MOD_ID));
    CreativeModeTab TAB = TABS.register(TAB_KEY.identifier().getPath(), FabricCreativeModeTab.builder()
            .icon(FallacyCreativeModeTabs::getIcon)
            .title(Component.literal(MiscUtils.formatString(Fallacy.MOD_ID)))
            .build()
    );

    private static ItemStack getIcon() {
        ItemStack stack = new ItemStack(FallacyItems.CURSED_TABLET);
        Optional<Holder.Reference<Patron>> disp = FallacyRegistries.PATRON.get(new Random().nextInt(FallacyRegistries.PATRON.size()));
        disp.ifPresent(patronReference -> stack.set(FallacyDataComponentTypes.HELD_PATRON, patronReference.value()));
        return stack;
    }

    private static void build(FabricCreativeModeTabOutput entries) {
        for (Patron patron : FallacyRegistries.PATRON) {
            ItemStack disp = new ItemStack(FallacyItems.CURSED_TABLET);

            disp.set(FallacyDataComponentTypes.HELD_PATRON, patron);

            entries.accept(disp);
        }
    }

    static void init() {
        CreativeModeTabEvents.modifyOutputEvent(TAB_KEY).register(FallacyCreativeModeTabs::build);
    }
}
