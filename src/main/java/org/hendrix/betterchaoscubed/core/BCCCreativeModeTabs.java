package org.hendrix.betterchaoscubed.core;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import org.hendrix.betterchaoscubed.BetterChaosCubed;
import org.hendrix.betterchaoscubed.utils.IdentifierUtils;

import java.util.Arrays;

/**
 * {@link BetterChaosCubed} {@link CreativeModeTab Creative Mode Tabs}
 */
public final class BCCCreativeModeTabs {

    //#region Creative Mode Tabs

    public static final CreativeModeTab BETTER_CHAOS_CUBED = register(
            BetterChaosCubed.MOD_ID,
            FabricCreativeModeTab.builder()
                    .icon(() -> new ItemStack(Blocks.SULFUR))
                    .title(Component.translatable("creativeTab." + BetterChaosCubed.MOD_ID + "." + BetterChaosCubed.MOD_ID))
                    .displayItems((params, output) -> {
                        addContent(
                                output,
                                BCCItems.SULFUR_POWDER
                        );
                        addNauseaPotionItems(params, output);
                    })
                    .build()
    );

    //#endregion

    /**
     * Add some content to a creative mode tab
     *
     * @param output The {@link CreativeModeTab.Output}
     * @param content The {@link ItemLike content to add}
     */
    private static void addContent(final CreativeModeTab.Output output, final ItemLike... content) {
        Arrays.stream(content).forEach(output::accept);
    }

    /**
     * Add tipped arrow and potions of Nausea
     *
     * @param itemDisplayParameters The {@link CreativeModeTab.ItemDisplayParameters}
     * @param output The {@link CreativeModeTab.Output}
     */
    private static void addNauseaPotionItems(final CreativeModeTab.ItemDisplayParameters itemDisplayParameters, final CreativeModeTab.Output output) {
        output.accept(PotionContents.createItemStack(Items.TIPPED_ARROW, BCCPotions.NAUSEA));
        output.accept(PotionContents.createItemStack(Items.POTION, BCCPotions.NAUSEA));
        output.accept(PotionContents.createItemStack(Items.SPLASH_POTION, BCCPotions.NAUSEA));
        output.accept(PotionContents.createItemStack(Items.LINGERING_POTION, BCCPotions.NAUSEA));
    }

    /**
     * Register a {@link CreativeModeTab}
     *
     * @param name The creative mode tab name
     * @param creativeModeTab The {@link CreativeModeTab to register}
     * @return The registered {@link CreativeModeTab}
     */
    private static CreativeModeTab register(final String name, final CreativeModeTab creativeModeTab) {
        final ResourceKey<CreativeModeTab> resourceKey = ResourceKey.create(BuiltInRegistries.CREATIVE_MODE_TAB.key(), IdentifierUtils.modded(name));
        return Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, resourceKey, creativeModeTab);
    }

    /**
     * Check if the {@link ItemStack} has a Nausea potion content
     *
     * @param itemStack The {@link ItemStack}
     * @return True if the {@link ItemStack} has a Nausea potion content
     */
    private static boolean hasNauseaPotion(final ItemStack itemStack) {
        final PotionContents potionContents = itemStack.get(DataComponents.POTION_CONTENTS);
        if(potionContents != null) {
            return potionContents.is(BCCPotions.NAUSEA);
        }
        return false;
    }

    /**
     * Register all creative mode tabs
     */
    public static void register() {
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COMBAT).register(output -> {
            output.getSearchTabStacks().removeIf(BCCCreativeModeTabs::hasNauseaPotion);
            output.getDisplayStacks().removeIf(BCCCreativeModeTabs::hasNauseaPotion);
        });
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.FOOD_AND_DRINKS).register(output -> {
            output.getSearchTabStacks().removeIf(BCCCreativeModeTabs::hasNauseaPotion);
            output.getDisplayStacks().removeIf(BCCCreativeModeTabs::hasNauseaPotion);
        });
    }

}