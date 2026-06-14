package com.peak.fallacy.core.patron;

import com.peak.fallacy.api.Patron;
import net.minecraft.network.chat.Component;

/**
 * @author Chemthunder
 */
public class MosswalkerPatron extends Patron {
    public MosswalkerPatron() {
        super(
                Component.translatable("patron.fallacy.mosswalker"),
                Component.translatable("patron.fallacy.mosswalker.title"),
                false,
                0xFF17472d
        );
    }
}
