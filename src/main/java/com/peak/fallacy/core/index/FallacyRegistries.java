package com.peak.fallacy.core.index;

import com.peak.fallacy.core.Fallacy;
import com.peak.fallacy.api.Patron;
import net.fabricmc.fabric.api.event.registry.FabricRegistryBuilder;
import net.fabricmc.fabric.api.event.registry.RegistryAttribute;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;

@SuppressWarnings("NullableProblems")
public interface FallacyRegistries {
    ResourceKey<Registry<Patron>> PATRON_KEY = ResourceKey.createRegistryKey(Fallacy.id("patron"));
    Registry<Patron> PATRON = FabricRegistryBuilder.create(PATRON_KEY)
            .attribute(RegistryAttribute.MODDED)
            .buildAndRegister();

    static void init() {}
}
