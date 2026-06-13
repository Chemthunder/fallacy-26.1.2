package com.peak.fallacy.core.index;

import com.peak.fallacy.compat.regist.PatronRegistrant;
import com.peak.fallacy.core.Fallacy;
import com.peak.fallacy.core.primary.Patron;
import net.minecraft.network.chat.Component;

public interface FallacyPatrons {
    PatronRegistrant PATRONS = new PatronRegistrant(Fallacy.MOD_ID);

    Patron EMPTY = PATRONS.register("empty", new Patron(Component.empty(), Component.empty(), false));

    static void init() {}
}
