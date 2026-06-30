package org.hendrix.betterchaoscubed.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.PotentSulfurBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.hendrix.betterchaoscubed.core.BCCBlockEntityTypes;
import org.jspecify.annotations.NonNull;

/**
 * Implementation class for a waxed {@link PotentSulfurBlockEntity}
 */
public final class WaxedPotentSulfurBlockEntity extends PotentSulfurBlockEntity {

    public static BlockEntityTicker<PotentSulfurBlockEntity> SERVER_NO_NAUSEA_EFFECT_TICKER;

    /**
     * Constructor. Set the block entity properties
     *
     * @param worldPosition The {@link BlockPos}
     * @param blockState The {@link BlockState}
     */
    public WaxedPotentSulfurBlockEntity(final BlockPos worldPosition, final BlockState blockState) {
        super(worldPosition, blockState);
        SERVER_NO_NAUSEA_EFFECT_TICKER = (level, pos, state, potentSulfur) -> { };
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
     * Get the Block Entity Type
     *
     * @return {@link BCCBlockEntityTypes#WAXED_POTENT_SULFUR}
     */
    @Override
    public @NonNull BlockEntityType<?> getType() {
        return BCCBlockEntityTypes.WAXED_POTENT_SULFUR;
    }
}
