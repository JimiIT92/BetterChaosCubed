package org.hendrix.betterchaoscubed.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.CampfireBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.hendrix.betterchaoscubed.core.BCCBlockEntityTypes;
import org.jspecify.annotations.NonNull;

/**
 * Implementation class for a sulfur {@link CampfireBlockEntity}
 */
public final class SulfurCampfireBlockEntity extends CampfireBlockEntity {

    /**
     * Constructor. Set the block entity properties
     *
     * @param worldPosition The block entity {@link BlockPos}
     * @param blockState The block entity {@link BlockState}
     */
    public SulfurCampfireBlockEntity(final BlockPos worldPosition, final BlockState blockState) {
        super(worldPosition, blockState);
    }

    /**
     * Check whether the current {@link BlockState} is valid for the block entity
     *
     * @param blockState The current {@link BlockState}
     * @return {@link Boolean True} if the current {@link BlockState} is valid
     */
    @Override
    public boolean isValidBlockState(final @NonNull BlockState blockState) {
        return this.getType().isValid(blockState);
    }

    /**
     * Get the block entity type
     *
     * @return {@link BCCBlockEntityTypes#SULFUR_CAMPFIRE}
     */
    @Override
    public @NonNull BlockEntityType<?> getType() {
        return BCCBlockEntityTypes.SULFUR_CAMPFIRE;
    }

}