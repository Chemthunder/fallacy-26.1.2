package com.peak.fallacy.core.index;

import com.peak.fallacy.core.Fallacy;
import com.peak.fallacy.core.item.ModTestItem;
import net.acoyt.acornlib.api.registrants.ItemRegistrant;
import net.minecraft.world.item.Item;

/**
 * @author Chemthunder
 */
public interface FallacyItems {
    ItemRegistrant ITEMS = new ItemRegistrant(Fallacy.MOD_ID);

    Item MOD_TEST = ITEMS.register("mod_test", ModTestItem::new, new Item.Properties()
            .stacksTo(1)
    );

    static void init() {}
}
