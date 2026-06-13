package com.peak.fallacy.core.item;

import com.peak.fallacy.core.cca.entity.FollowerComponent;
import com.peak.fallacy.core.index.FallacyPatrons;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

/**
 * @author Chemthunder
 */
public class ModTestItem extends Item {
    public ModTestItem(Properties properties) {
        super(properties);
    }

    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        player.sendOverlayMessage(Component.literal("test!"));

        FollowerComponent.KEY.get(player).setPatron(FallacyPatrons.WINDSEEKER);

        return super.use(level, player, hand);
    }
}
