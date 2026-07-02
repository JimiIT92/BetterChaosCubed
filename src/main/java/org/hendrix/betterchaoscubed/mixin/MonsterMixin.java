package org.hendrix.betterchaoscubed.mixin;

import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.monster.Monster;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Mixin for the Monster class
 */
@Mixin(Monster.class)
public final class MonsterMixin {

    /**
     * Make monster randomly stops if affected by nausea
     *
     * @param callbackInfo The CallbackInfo
     */
    @Inject(at = @At(value = "HEAD"), method = "aiStep", cancellable = true)
    private void aiStep(final CallbackInfo callbackInfo) {
        var monster = (Monster) (Object) this;
        if(monster.hasEffect(MobEffects.NAUSEA) && monster.getRandom().nextInt(10) < 8) {
            callbackInfo.cancel();
        }
    }

}