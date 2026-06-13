package com.peak.fallacy.core.index;

import com.peak.fallacy.compat.regist.PatronRegistrant;
import com.peak.fallacy.core.Fallacy;
import com.peak.fallacy.api.Patron;
import com.peak.fallacy.core.patron.WindseekerPatron;
import net.minecraft.network.chat.Component;

public interface FallacyPatrons {
    PatronRegistrant PATRONS = new PatronRegistrant(Fallacy.MOD_ID);

    // CORE
    Patron EMPTY = PATRONS.register("empty", new Patron(Component.empty(), Component.empty(), false));

    // OTHER
    Patron WINDSEEKER = PATRONS.register("windseeker", new WindseekerPatron());

    static void init() {}
}
