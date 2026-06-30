package com.peak.fallacy.core.patron;

import com.peak.fallacy.api.Patron;
import com.peak.fallacy.core.Fallacy;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

import static com.peak.fallacy.core.Fallacy.id;

/**
 * @author Chemthunder
 */
public class FatespeakerPatron extends Patron {
    public FatespeakerPatron() {
        super(id("fatespeaker"),true, 0xFFaa07ff);
    }

    public void onSneak(Player player, Level level) {
        player.sendOverlayMessage(
                Component.literal("sneake")
        );

        Fallacy.LOGGER.info("Sneaked");
    }

    public void onUseKeybind(Player player, Level level) {
        player.sendOverlayMessage(
                Component.literal("<o>")
        );

        Fallacy.LOGGER.info("Help");
    }
}
