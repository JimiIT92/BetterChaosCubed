package org.hendrix.betterchaoscubed.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.particle.v1.ParticleProviderRegistry;
import net.minecraft.client.particle.FlameParticle;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.CampfireRenderer;
import org.hendrix.betterchaoscubed.BetterChaosCubed;
import org.hendrix.betterchaoscubed.core.BCCBlockEntityTypes;
import org.hendrix.betterchaoscubed.core.BCCParticleTypes;

/**
 * {@link BetterChaosCubed} {@link ClientModInitializer}
 */
@Environment(EnvType.CLIENT)
public class BetterChaosCubedClient implements ClientModInitializer {

    /**
     * Initialize the mod's client stuffs
     */
    @Override
    public void onInitializeClient() {
        ParticleProviderRegistry.getInstance().register(BCCParticleTypes.SULFUR_FIRE_FLAME, FlameParticle.Provider::new);
        BlockEntityRenderers.register(BCCBlockEntityTypes.SULFUR_CAMPFIRE, CampfireRenderer::new);
    }

}