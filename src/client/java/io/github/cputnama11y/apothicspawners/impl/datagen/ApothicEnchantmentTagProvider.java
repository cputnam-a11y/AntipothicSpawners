package io.github.cputnama11y.apothicspawners.impl.datagen;

import io.github.cputnama11y.apothicspawners.impl.enchantment.ApothicEnchantments;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.EnchantmentTags;
import net.minecraft.world.item.enchantment.Enchantment;

import java.util.concurrent.CompletableFuture;

public class ApothicEnchantmentTagProvider extends FabricTagProvider<Enchantment> {
    public ApothicEnchantmentTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, Registries.ENCHANTMENT, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {
        builder(EnchantmentTags.NON_TREASURE)
                .add(ApothicEnchantments.CAPTURING);
    }
}
