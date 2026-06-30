package org.hendrix.betterchaoscubed.block;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.PotentSulfurBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.hendrix.betterchaoscubed.block.entity.WaxedPotentSulfurBlockEntity;
import org.hendrix.betterchaoscubed.core.BCCBlockEntityTypes;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

/**
 * Implementation class for a waxed {@link PotentSulfurBlock}
 */
public final class WaxedPotentSulfurBlock extends PotentSulfurBlock {

    /**
     * Constructor. Set the Block properties
     * 
     * @param properties The {@link Properties}
     */
    public WaxedPotentSulfurBlock(final Properties properties) {
        super(properties);
    }

    /**
     * Get the {@link BlockEntity} attached to this Block
     *
     * @param worldPosition The current {@link BlockPos}
     * @param blockState The current {@link BlockState}
     * @return The {@link BlockEntity}
     */
    @Override
    public @Nullable BlockEntity newBlockEntity(final @NonNull BlockPos worldPosition, final @NonNull BlockState blockState) {
        return new WaxedPotentSulfurBlockEntity(worldPosition, blockState);
    }

    /**
     * Get the Block ticker
     *
     * @param level The {@link Level} reference
     * @param blockState The current {@link BlockState}
     * @param type The {@link BlockEntityType}
     * @return The Block ticker
     * @param <T> The Block Entity type
     */
    @Override
    public <T extends BlockEntity> @Nullable BlockEntityTicker<T> getTicker(final Level level, final BlockState blockState, final @NonNull BlockEntityType<T> type) {
        final boolean isClientSide = level.isClientSide();
        BlockEntityType<WaxedPotentSulfurBlockEntity> blockEntity = BCCBlockEntityTypes.WAXED_POTENT_SULFUR;
        BlockEntityTicker blockEntityTicker;
        switch (blockState.getValue(STATE)) {
            case DRY -> blockEntityTicker = null;
            case WET -> blockEntityTicker = isClientSide ? WaxedPotentSulfurBlockEntity.CLIENT_NOXIOUS_GAS_TICKER : WaxedPotentSulfurBlockEntity.SERVER_NO_NAUSEA_EFFECT_TICKER;
            case DORMANT -> blockEntityTicker = isClientSide ? WaxedPotentSulfurBlockEntity.CLIENT_NOXIOUS_GAS_TICKER : WaxedPotentSulfurBlockEntity.SERVER_WAITING_COUNTDOWN_TICKER.andThen(WaxedPotentSulfurBlockEntity.SERVER_NO_NAUSEA_EFFECT_TICKER);
            case ERUPTING -> blockEntityTicker = isClientSide ? ((BlockEntityTicker)WaxedPotentSulfurBlockEntity.CLIENT_GEYSER_PLUME_TICKER.apply(SoundEvents.GEYSER_ERUPTION_ACTIVE)).andThen(WaxedPotentSulfurBlockEntity.LAUNCH_ENTITY_TICKER) : WaxedPotentSulfurBlockEntity.LAUNCH_ENTITY_TICKER.andThen(WaxedPotentSulfurBlockEntity.SERVER_WAITING_COUNTDOWN_TICKER);
            case CONTINUOUS -> blockEntityTicker = isClientSide ? ((BlockEntityTicker)WaxedPotentSulfurBlockEntity.CLIENT_GEYSER_PLUME_TICKER.apply(SoundEvents.GEYSER_CONTINUOUS_ACTIVE)).andThen(WaxedPotentSulfurBlockEntity.LAUNCH_ENTITY_TICKER) : WaxedPotentSulfurBlockEntity.LAUNCH_ENTITY_TICKER;
            default -> throw new MatchException(null, null);
        }

        return createTickerHelper(type, blockEntity, blockEntityTicker);
    }

}
