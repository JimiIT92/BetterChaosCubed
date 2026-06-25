package org.hendrix.betterchaoscubed.core;

import net.fabricmc.fabric.api.registry.FabricPotionBrewingBuilder;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.alchemy.Potion;
import org.hendrix.betterchaoscubed.BetterChaosCubed;
import org.hendrix.betterchaoscubed.utils.IdentifierUtils;

/**
 * {@link BetterChaosCubed} {@link Potion Potions}
 */
public final class BCCPotions {

    //#region Potions

    public static final Holder<Potion> NAUSEA = register(new Potion("nausea", new MobEffectInstance(MobEffects.NAUSEA, 3600)));

    //#endregion

    /**
     * Register a Potion
     *
     * @param potion The Potion to register
     * @return The registered Potion
     */
    private static Holder<Potion> register(final Potion potion) {
        return register(potion.name(), potion);
    }

    /**
     * Register a Potion
     *
     * @param name The Potion name
     * @param potion The Potion to register
     * @return The registered Potion
     */
    private static Holder<Potion> register(final String name, final Potion potion) {
        final ResourceKey<Potion> key = ResourceKey.create(Registries.POTION, IdentifierUtils.modded(name));
        return Registry.registerForHolder(BuiltInRegistries.POTION, key, potion);
    }

    /**
     * Register all potions
     */
    public static void register() {
        FabricPotionBrewingBuilder.BUILD.register(builder -> builder.addStartMix(BCCItems.SULFUR_POWDER, NAUSEA));
    }

}