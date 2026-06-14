package com.peak.fallacy.datagen.provider;

import com.peak.fallacy.core.client.item.tint.TabletTintSource;
import com.peak.fallacy.core.index.FallacyItems;
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
import net.minecraft.world.item.Item;

import java.util.concurrent.CompletableFuture;

public class FallacyResources {
    public static class Language extends FabricLanguageProvider {
        public Language(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
            super(packOutput, registryLookup);
        }

        public void generateTranslations(HolderLookup.Provider provider, TranslationBuilder translationBuilder) {
            FallacyItems.ITEMS.registerLang(provider, translationBuilder);

            translationBuilder.add("patron.fallacy.empty", "Empty.");
            translationBuilder.add("patron.fallacy.empty.title", "Nothing lies in this basin.");

            translationBuilder.add("patron.fallacy.fatespeaker", "The Fatespeaker");
            translationBuilder.add("patron.fallacy.fatespeaker.title", "Queen of What Becomes");

            translationBuilder.add("patron.fallacy.windseeker", "Mistress Windseeker");
            translationBuilder.add("patron.fallacy.windseeker.title", "Fox of the Nine Winds");

            translationBuilder.add("item.fallacy.cursed_tablet.cursed", "This tablet is cursed!");
        }
    }

    public static class Model extends FabricModelProvider {
        public Model(FabricPackOutput output) {
            super(output);
        }

        public void generateBlockStateModels(BlockModelGenerators blockModelGenerators) {}

        public void generateItemModels(ItemModelGenerators gen) {
            createTablet(gen, FallacyItems.CURSED_TABLET);
        }

        private static void createTablet(ItemModelGenerators generator, Item item) {
            Identifier itemId = ModelLocationUtils.getModelLocation(item);

            ModelTemplates.TWO_LAYERED_ITEM.create(
                    itemId,
                    TextureMapping.layer0(new Material(itemId))
                            .put(TextureSlot.LAYER1, new Material(itemId.withSuffix("_guy"))),
                    generator.modelOutput
            );

            generator.itemModelOutput.accept(item, ItemModelUtils.tintedModel(itemId, new Constant(0xFFFFFFFF), new TabletTintSource()));
        }
    }
}
