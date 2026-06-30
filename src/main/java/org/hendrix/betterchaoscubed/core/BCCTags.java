package org.hendrix.betterchaoscubed.core;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import org.hendrix.betterchaoscubed.BetterChaosCubed;
import org.hendrix.betterchaoscubed.utils.IdentifierUtils;

/**
 * {@link BetterChaosCubed} {@link TagKey Tags}
 */
public final class BCCTags {

    public static class BlockTags {

        //#region Tags

        public static final TagKey<Block> SULFUR_FIRE_BASE_BLOCKS = register("sulfur_fire_base_blocks");

        //#endregion

        /**
         * Register a block {@link TagKey}
         *
         * @param name The tag name
         * @return The block {@link TagKey}
         */
        private static TagKey<Block> register(final String name) {
            return TagKey.create(Registries.BLOCK, IdentifierUtils.modded(name));
        }

    }
}