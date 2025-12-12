package io.github.cputnama11y.apothicspawners.impl.datagen;

import io.github.cputnama11y.apothicspawners.impl.ApothicSpawners;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;

import java.util.concurrent.CompletableFuture;

public class ApothicEnchantmentProvider extends FabricDynamicRegistryProvider {
    public ApothicEnchantmentProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(HolderLookup.Provider registries, Entries entries) {
        entries.add(
                registries.lookupOrThrow(Registries.ENCHANTMENT)
                        .getOrThrow(
                                ResourceKey.create(
                                        Registries.ENCHANTMENT,
                                        Identifier.fromNamespaceAndPath(
                                                ApothicSpawners.MOD_ID,
                                                "capturing"
                                        )
                                )
                        )
        );
    }

    @Override
    public String getName() {
        return "EnchantmentProvider";
    }
}
