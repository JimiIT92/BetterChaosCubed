package org.hendrix.betterchaoscubed;

import net.fabricmc.api.ModInitializer;
import org.hendrix.betterchaoscubed.core.*;

/**
 * Better Chaos Cubed.
 * Enhance Sulfur Cubes with redstone archetype, craftable nausea potions and more!
 */
public final class BetterChaosCubed implements ModInitializer {

    /**
     * The {@link String Mod ID}
     */
    public static final String MOD_ID = "betterchaoscubed";

    /**
     * Initialize the mod
     */
    @Override
    public void onInitialize() {
        BCCParticleTypes.register();
        BCCItems.register();
        BCCBlocks.register();
        BCCBlockEntityTypes.register();
        BCCPotions.register();
        BCCCreativeModeTabs.register();
    }

}