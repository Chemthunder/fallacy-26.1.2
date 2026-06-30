package com.peak.fallacy.mixin;

import com.peak.fallacy.core.cca.entity.FollowerComponent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * @author Chemthunder
 */
@Mixin(value = Player.class)
public abstract class PlayerMixin {

    @Inject(method = "attack", at = @At(value = "HEAD"))
    private void fallacy$hit(Entity entity, CallbackInfo ci) {
        Player self = (Player) (Object) this;

        if (entity instanceof LivingEntity target) {
            FollowerComponent.KEY.get(self).getPatron().onAttack(
                    self,
                    target,
                    self.level(),
                    self.swingingArm
            );
        }
    }
}
