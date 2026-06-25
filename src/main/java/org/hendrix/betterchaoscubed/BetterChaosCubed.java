package org.hendrix.betterchaoscubed;

import net.fabricmc.api.ModInitializer;
import org.hendrix.betterchaoscubed.core.BCCCreativeModeTabs;
import org.hendrix.betterchaoscubed.core.BCCItems;

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
        BCCItems.register();
        BCCCreativeModeTabs.register();
    }

}