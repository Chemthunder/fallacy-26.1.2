package com.peak.fallacy.core.item;

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

    public @NotNull InteractionResult use(Level level, Player player, InteractionHand hand) {

        player.sendOverlayMessage(Component.literal("test!"));

        level.explode(
                player,
                player.getX(),
                player.getY(),
                player.getZ(),
                5,
                Level.ExplosionInteraction.TRIGGER
        );

        return super.use(level, player, hand);
    }
}
