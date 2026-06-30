package com.peak.fallacy.datagen.provider;

import com.peak.fallacy.api.Patron;
import com.peak.fallacy.core.client.item.tint.TabletTintSource;
import com.peak.fallacy.core.index.FallacyItems;
import com.peak.fallacy.core.index.FallacyPatrons;
import com.peak.fallacy.core.index.FallacyRegistries;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.client.color.item.Constant;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.*;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.core.HolderLookup;
import net.minecraft.resources.Identifier;

import java.util.concurrent.CompletableFuture;

public class FallacyResources {
    public static class Language extends FabricLanguageProvider {
        public Language(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
            super(packOutput, registryLookup);
        }

        public void generateTranslations(HolderLookup.Provider provider, TranslationBuilder translationBuilder) {
            FallacyItems.ITEMS.registerLang(provider, translationBuilder);

            translatePatron(FallacyPatrons.EMPTY,
                    "Empty.",
                    "Nothing lies in this basin.",
                    "",
                    translationBuilder
            );

            translatePatron(FallacyPatrons.FATESPEAKER,
                    "The Fatespeaker",
                    "Queen of What Is, Becomes, and Will Be.",
                    "Look to the Future.",
                    translationBuilder
            );

            translatePatron(FallacyPatrons.WINDSEEKER,
                    "Mistress Windseeker",
                    "Fox of the Nine Winds.",
                    "Sail the Skies.",
                    translationBuilder
            );

            translatePatron(FallacyPatrons.MOSSWALKER,
                    "The Ancestral Mosswalker",
                    "Ruler of the Divine Groves.",
                    "Seek the Woods.",
                    translationBuilder
            );

            translatePatron(FallacyPatrons.FORSAKEN,
                    "The Forsaken Echo",
                    "The Banished One.",
                    "Forget Me.",
                    translationBuilder
            );

            translationBuilder.add("item.fallacy.cursed_tablet.cursed", "This tablet is cursed!");
        }
    }

    public static void translatePatron(Patron patron, String name, String title, String slogan, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        Identifier id = FallacyRegistries.PATRON.getKey(patron);

        translationBuilder.add("patron." + id.getNamespace() + "." + id.getPath(), name);
        translationBuilder.add("patron." + id.getNamespace() + "." + id.getPath() + ".title", title);
        translationBuilder.add("patron." + id.getNamespace() + "." + id.getPath() + ".slogan", slogan);
    }

    public static class Model extends FabricModelProvider {
        public Model(FabricPackOutput output) {
            super(output);
        }

        public void generateBlockStateModels(BlockModelGenerators blockModelGenerators) {}

        public void generateItemModels(ItemModelGenerators gen) {
            createTablet(gen);
        }

        private static void createTablet(ItemModelGenerators generator) {
            Identifier itemId = ModelLocationUtils.getModelLocation(FallacyItems.CURSED_TABLET);

            ModelTemplates.TWO_LAYERED_ITEM.create(
                    itemId,
                    TextureMapping.layer0(new Material(itemId))
                            .put(TextureSlot.LAYER1, new Material(itemId.withSuffix("_guy"))),
                    generator.modelOutput
            );

            generator.itemModelOutput.accept(FallacyItems.CURSED_TABLET, ItemModelUtils.tintedModel(itemId, new Constant(0xFFFFFFFF), new TabletTintSource()));
        }
    }
}
