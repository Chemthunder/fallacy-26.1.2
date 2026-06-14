package com.peak.fallacy.core.index;

import com.peak.fallacy.core.Fallacy;
import net.acoyt.acornlib.api.registrants.CreativeModeTabRegistrant;
import net.acoyt.acornlib.api.util.MiscUtils;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

/**
 * @author Chemthunder
 */
public interface FallacyCreativeModeTabs {
    CreativeModeTabRegistrant TABS = new CreativeModeTabRegistrant(Fallacy.MOD_ID);

//    CreativeModeTab TAB = TABS.register("main", FabricCreativeModeTab.builder()
//            .icon(() -> new ItemStack(FallacyItems.MOD_TEST))
//            .title(Component.literal(MiscUtils.formatString(Fallacy.MOD_ID)))
//            .displayItems(((parameters, output) -> {
//                FallacyItems.ITEMS.toRegister.forEach(output::accept);
//
//                FallacyPatrons.PATRONS.toRegister.forEach(patron -> {
//                    ItemStack toAdd = new ItemStack(FallacyItems.CURSED_TABLET);
//
//                    toAdd.set(FallacyDataComponentTypes.HELD_PATRON, patron);
//
//                    output.accept(toAdd);
//                });
//            }))
//            .build()
//    );

    static void init() {}
}
