package com.peak.fallacy.mixin;

import com.peak.fallacy.core.cca.entity.FollowerComponent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * @author Chemthunder
 */
@Mixin(value = Entity.class)
public abstract class EntityMixin {
    @Inject(method = "setShiftKeyDown", at = @At(value = "HEAD"))
    private void fallacy$sneak(boolean shiftKeyDown, CallbackInfo ci) {
        if ((Object) this instanceof Player s) {
            FollowerComponent.KEY.get(s).getPatron().onSneak(
                    s,
                    s.level()
            );
        }
    }
}
