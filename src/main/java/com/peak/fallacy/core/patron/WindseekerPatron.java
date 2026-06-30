package com.peak.fallacy.core.patron;

import com.peak.fallacy.api.Patron;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

import static com.peak.fallacy.core.Fallacy.id;

/**
 * @author Chemthunder
 */
public class WindseekerPatron extends Patron {
    public WindseekerPatron() {
        super(id("windseeker"),false, 0xFF34ebbd);
    }

    public void onAttack(Player player, LivingEntity target, Level level, InteractionHand hand) {
        //
    }
}
