package org.hendrix.betterchaoscubed.core;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import org.hendrix.betterchaoscubed.BetterChaosCubed;
import org.hendrix.betterchaoscubed.block.entity.WaxedPotentSulfurBlockEntity;
import org.hendrix.betterchaoscubed.utils.IdentifierUtils;

/**
 * {@link BetterChaosCubed} {@link BlockEntityType Block Entity Types}
 */
public final class BCCBlockEntityTypes {

    //#region Block Entity Types

    public static final BlockEntityType<WaxedPotentSulfurBlockEntity> WAXED_POTENT_SULFUR = register("waxed_potent_sulfur", WaxedPotentSulfurBlockEntity::new, BCCBlocks.WAXED_POTENT_SULFUR);

    //#endregion

    /**
     * Register a {@link BlockEntityType}
     *
     * @param name The block entity name
     * @param entityFactory The {@link FabricBlockEntityTypeBuilder.Factory}
     * @param blocks The block entity valid blocks
     * @return The registered {@link BlockEntityType}
     * @param <T> The block entity type
     */
    private static <T extends BlockEntity> BlockEntityType<T> register(final String name, final FabricBlockEntityTypeBuilder.Factory<? extends T> entityFactory, final Block... blocks) {
        return Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, IdentifierUtils.modded(name), FabricBlockEntityTypeBuilder.<T>create(entityFactory, blocks).build());
    }

    /**
     * Register all {@link BlockEntityType}
     */
    public static void register() {

    }

}
