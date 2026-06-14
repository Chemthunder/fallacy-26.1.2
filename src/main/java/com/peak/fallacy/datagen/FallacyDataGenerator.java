package com.peak.fallacy.datagen;

import com.peak.fallacy.datagen.provider.FallacyResources;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

/**
 * @author Chemthunder
 */
public class FallacyDataGenerator implements DataGeneratorEntrypoint {
	public void onInitializeDataGenerator(FabricDataGenerator fdg) {
        var pack = fdg.createPack();

        pack.addProvider(FallacyResources.Language::new);
        pack.addProvider(FallacyResources.Model::new);
	}
}
