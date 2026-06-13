package com.peak.fallacy.core.primary;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.peak.fallacy.core.index.FallacyPatrons;

public record Cult(String name, String slogan, int color, Patron patron) {
    public static final Codec<Cult> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.STRING.optionalFieldOf("name", "").forGetter(Cult::name),
            Codec.STRING.optionalFieldOf("slogan", "").forGetter(Cult::slogan),
            Codec.INT.optionalFieldOf("color", 0xFFffffff).forGetter(Cult::color),
            Patron.CODEC.optionalFieldOf("patron", FallacyPatrons.EMPTY).forGetter(Cult::patron)
    ).apply(instance, Cult::new));
}
