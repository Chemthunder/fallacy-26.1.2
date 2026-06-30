package com.peak.fallacy.core.index;

import com.peak.fallacy.api.Patron;
import com.peak.fallacy.compat.regist.PatronRegistrant;
import com.peak.fallacy.core.Fallacy;
import com.peak.fallacy.core.patron.FatespeakerPatron;
import com.peak.fallacy.core.patron.ForsakenPatron;
import com.peak.fallacy.core.patron.MosswalkerPatron;
import com.peak.fallacy.core.patron.WindseekerPatron;
import net.minecraft.network.chat.Component;

public interface FallacyPatrons {
    PatronRegistrant PATRONS = new PatronRegistrant(Fallacy.MOD_ID);

    // CORE
    Patron EMPTY = PATRONS.register("empty", new Patron(Component.empty(), Component.empty(), Component.empty(), false, 0xFFffffff));

    // OTHER
    Patron WINDSEEKER = PATRONS.register("windseeker", new WindseekerPatron());
    Patron FATESPEAKER = PATRONS.register("fatespeaker", new FatespeakerPatron());
    Patron MOSSWALKER = PATRONS.register("mosswalker", new MosswalkerPatron());
    Patron FORSAKEN = PATRONS.register("forsaken", new ForsakenPatron());

    static void init() {}
}
