package com.peak.fallacy.core.index;

import com.peak.fallacy.core.Fallacy;
import com.peak.fallacy.core.item.CursedTabletItem;
import net.acoyt.acornlib.api.registrants.ItemRegistrant;
import net.minecraft.world.item.Item;

/**
 * @author Chemthunder
 */
public interface FallacyItems {
    ItemRegistrant ITEMS = new ItemRegistrant(Fallacy.MOD_ID);

    Item CURSED_TABLET = ITEMS.register("cursed_tablet", CursedTabletItem::new, new Item.Properties()
            .stacksTo(1)
            .component(FallacyDataComponentTypes.HELD_PATRON, FallacyPatrons.EMPTY)
    );

    static void init() {}
}
