package io.github.cputnama11y.anitpothicspawners.impl.datagen;

import io.github.cputnama11y.antipothicspawners.impl.enchantment.AntipothicEnchantments;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.EnchantmentTags;
import net.minecraft.world.item.enchantment.Enchantment;

import java.util.concurrent.CompletableFuture;

public class AntipothicEnchantmentTagProvider extends FabricTagsProvider<Enchantment> {
    public AntipothicEnchantmentTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, Registries.ENCHANTMENT, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {
        builder(EnchantmentTags.NON_TREASURE)
                .add(AntipothicEnchantments.CAPTURING);
    }
}
