package org.hendrix.betterchaoscubed.core;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
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

    public static class EntityTags {

        //#region Tags

        public static final TagKey<EntityType<?>> UNAFFECTED_BY_NAUSEA = register("unaffected_by_nausea");

        //#endregion

        /**
         * Register an entity {@link TagKey}
         *
         * @param name The tag name
         * @return The entity {@link TagKey}
         */
        private static TagKey<EntityType<?>> register(final String name) {
            return TagKey.create(Registries.ENTITY_TYPE, IdentifierUtils.modded(name));
        }

    }

}