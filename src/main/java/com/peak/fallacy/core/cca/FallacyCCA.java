package com.peak.fallacy.core.cca;

import com.peak.fallacy.core.cca.entity.FollowerComponent;
import org.ladysnake.cca.api.v3.entity.EntityComponentFactoryRegistry;
import org.ladysnake.cca.api.v3.entity.EntityComponentInitializer;
import org.ladysnake.cca.api.v3.entity.RespawnCopyStrategy;

/**
 * @author Chemthunder
 */
public class FallacyCCA implements EntityComponentInitializer {
    public void registerEntityComponentFactories(EntityComponentFactoryRegistry cca) {
        cca.registerForPlayers(
                FollowerComponent.KEY,
                FollowerComponent::new,
                RespawnCopyStrategy.NEVER_COPY
        );
    }
}
