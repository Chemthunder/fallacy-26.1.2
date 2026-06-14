package com.peak.fallacy.core.patron;

import com.peak.fallacy.api.Patron;
import net.minecraft.network.chat.Component;

/**
 * @author Chemthunder
 */
public class FatespeakerPatron extends Patron {
    public FatespeakerPatron() {
        super(
                Component.translatable("patron.fallacy.fatespeaker"),
                Component.translatable("patron.fallacy.fatespeaker.title"),
                true,
                0xFFaa07ff
        );
    }
}
