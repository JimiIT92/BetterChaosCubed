package org.hendrix.betterchaoscubed.core;

import net.fabricmc.fabric.api.registry.OxidizableBlocksRegistry;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.hendrix.betterchaoscubed.BetterChaosCubed;
import org.hendrix.betterchaoscubed.block.WaxedPotentSulfurBlock;
import org.hendrix.betterchaoscubed.utils.IdentifierUtils;

import java.util.function.Function;

/**
 * {@link BetterChaosCubed} {@link Block Blocks}
 */
public final class BCCBlocks {

    //#region Blocks

    public static final Block WAXED_POTENT_SULFUR = register("waxed_potent_sulfur", WaxedPotentSulfurBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.POTENT_SULFUR));

    //#endregion

    /**
     * Register a {@link Block} without registering a {@link BlockItem}
     *
     * @param name The block name
     * @param blockFactory The block factory
     * @param properties The {@link BlockBehaviour.Properties block properties}
     * @return The registered {@link Block}
     */
    private static Block registerBlockWithoutBlockItem(final String name, final Function<BlockBehaviour.Properties, Block> blockFactory, final BlockBehaviour.Properties properties) {
        final ResourceKey<Block> blockResourceKey = ResourceKey.create(Registries.BLOCK, IdentifierUtils.modded(name));
        final Block block = blockFactory.apply(properties.setId(blockResourceKey));
        return Registry.register(BuiltInRegistries.BLOCK, blockResourceKey, block);
    }

    /**
     * Register a {@link Block}
     *
     * @param name The block name
     * @param blockFactory The block factory
     * @param properties The {@link BlockBehaviour.Properties block properties}
     * @return The registered {@link Block}
     */
    private static Block register(final String name, final Function<BlockBehaviour.Properties, Block> blockFactory, final BlockBehaviour.Properties properties) {
        final Block block = registerBlockWithoutBlockItem(name, blockFactory, properties);
        final ResourceKey<Item> blockItemResourceKey = ResourceKey.create(Registries.ITEM, IdentifierUtils.modded(name));
        final BlockItem blockItem = new BlockItem(block, new Item.Properties().setId(blockItemResourceKey).useBlockDescriptionPrefix());
        Registry.register(BuiltInRegistries.ITEM, blockItemResourceKey, blockItem);
        return block;
    }

    /**
     * Register all {@link Block Blocks}
     */
    public static void register() {
        OxidizableBlocksRegistry.registerWaxable(Blocks.POTENT_SULFUR, WAXED_POTENT_SULFUR);
    }
}