package io.github.cputnama11y.apothicspawners.impl.datagen;

import io.github.cputnama11y.apothicspawners.impl.ApothicEnchantments;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import org.jetbrains.annotations.NotNull;

public class ApothicSpawnersDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(@NotNull FabricDataGenerator fabricDataGenerator) {
        var pack = fabricDataGenerator.createPack();
        pack.addProvider(ApothicEnchantmentProvider::new);
    }

    @Override
    public void buildRegistry(@NotNull RegistrySetBuilder registryBuilder) {
        registryBuilder.add(Registries.ENCHANTMENT, ApothicEnchantments::bootstrap);
    }
}
