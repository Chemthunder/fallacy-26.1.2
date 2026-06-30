package com.peak.fallacy.compat.regist;

import com.peak.fallacy.api.Patron;
import com.peak.fallacy.core.index.FallacyRegistries;
import net.acoyt.acornlib.api.template.RegistrantBase;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.HolderLookup;

public class PatronRegistrant extends RegistrantBase<Patron> {
    public PatronRegistrant(String modId) {
        super(modId, FallacyRegistries.PATRON);
    }

    public void registerLang(HolderLookup.Provider provider, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        //
    }
}
