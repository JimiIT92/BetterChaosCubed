package org.hendrix.betterchaoscubed.utils;

import net.minecraft.resources.Identifier;
import org.hendrix.betterchaoscubed.BetterChaosCubed;

/**
 * Utility methods for {@link Identifier}
 */
public final class IdentifierUtils {

    /**
     * Get a modded {@link Identifier}
     *
     * @param name The resource name
     * @return The modded {@link Identifier}
     */
    public static Identifier modded(final String name) {
        return Identifier.fromNamespaceAndPath(BetterChaosCubed.MOD_ID, name);
    }

}