package org.hendrix.betterchaoscubed.core;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import org.hendrix.betterchaoscubed.BetterChaosCubed;
import org.hendrix.betterchaoscubed.utils.IdentifierUtils;

/**
 * {@link BetterChaosCubed} {@link ParticleType Particle Types}
 */
public final class BCCParticleTypes {

    //#region Particle Types

    public static final SimpleParticleType SULFUR_FIRE_FLAME = register("sulfur_fire_flame");

    //#endregion

    private static SimpleParticleType register(final String name) {
        final ResourceKey<ParticleType<?>> particleResourceKey = ResourceKey.create(Registries.PARTICLE_TYPE, IdentifierUtils.modded(name));
        return Registry.register(BuiltInRegistries.PARTICLE_TYPE, particleResourceKey, FabricParticleTypes.simple());
    }

    public static void register() {

    }

}