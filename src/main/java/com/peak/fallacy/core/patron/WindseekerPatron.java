package com.peak.fallacy.core.patron;

import com.peak.fallacy.api.Patron;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

/**
 * @author Chemthunder
 */
public class WindseekerPatron extends Patron {
    public WindseekerPatron() {
        super(
                Component.translatable("patron.fallacy.windseeker"),
                Component.translatable("patron.fallacy.windseeker.title"),
                false,
                0xFF34ebbd
        );
    }

    public void onAttack(Player player, LivingEntity target, Level level, InteractionHand hand) {
        //
    }
}
