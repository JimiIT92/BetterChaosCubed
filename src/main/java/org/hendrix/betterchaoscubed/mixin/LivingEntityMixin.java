package org.hendrix.betterchaoscubed.mixin;

import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import org.hendrix.betterchaoscubed.core.BCCTags;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Mixin for the LivingEntity class
 */
@Mixin(LivingEntity.class)
public final class LivingEntityMixin {

    /**
     * Make monster randomly stops if affected by nausea
     *
     * @param callbackInfo The CallbackInfo
     */
    @Inject(at = @At(value = "HEAD"), method = "aiStep", cancellable = true)
    private void aiStep(final CallbackInfo callbackInfo) {
        var entity = (LivingEntity) (Object) this;
        if(entity.hasEffect(MobEffects.NAUSEA) && entity.getRandom().nextInt(10) < 8 && !entity.is(BCCTags.EntityTags.UNAFFECTED_BY_NAUSEA)) {
            callbackInfo.cancel();
        }
    }

}