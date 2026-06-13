package com.peak.fallacy.datagen.provider;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

public class FallacyResources {
    public static class Language extends FabricLanguageProvider {
        public Language(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
            super(packOutput, registryLookup);
        }

        public void generateTranslations(HolderLookup.Provider provider, TranslationBuilder translationBuilder) {
            translationBuilder.add("patron.fallacy.empty", "Empty.");
            translationBuilder.add("patron.fallacy.empty.title", "Nothing lies in this basin.");

            translationBuilder.add("patron.fallacy.fatespeaker", "The Fatespeaker");
            translationBuilder.add("patron.fallacy.fatespeaker.title", "Queen of What Becomes");
        }
    }
}
