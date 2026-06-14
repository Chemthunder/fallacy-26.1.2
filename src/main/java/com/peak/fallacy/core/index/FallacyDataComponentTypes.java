package com.peak.fallacy.core.index;

import com.peak.fallacy.api.Patron;
import com.peak.fallacy.core.Fallacy;
import net.acoyt.acornlib.api.registrants.DataComponentTypeRegistrant;
import net.minecraft.core.component.DataComponentType;

/**
 * @author Chemthunder
 */
public interface FallacyDataComponentTypes {
    DataComponentTypeRegistrant TYPES = new DataComponentTypeRegistrant(Fallacy.MOD_ID);

    DataComponentType<Patron> HELD_PATRON = TYPES.register("held_patron", Patron.CODEC, Patron.PACKET_CODEC);

    static void init() {}
}
