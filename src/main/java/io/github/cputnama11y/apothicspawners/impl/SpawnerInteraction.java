package io.github.cputnama11y.apothicspawners.impl;

import net.minecraft.advancements.criterion.ItemPredicate;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public record SpawnerInteraction(ItemPredicate main, ItemPredicate offhand) {
    public static final SpawnerInteraction REDSTONE_CONTROL = new SpawnerInteraction(
            ItemPredicate.Builder.item().of(BuiltInRegistries.ITEM, Items.COMPARATOR).build(),
            ItemPredicate.Builder.item().of(BuiltInRegistries.ITEM, Items.AIR).build()
    );
    public static final SpawnerInteraction REMOVE_REDSTONE_CONTROL = new SpawnerInteraction(
            ItemPredicate.Builder.item().of(BuiltInRegistries.ITEM, Items.COMPARATOR).build(),
            ItemPredicate.Builder.item().of(BuiltInRegistries.ITEM, Items.QUARTZ).build()
    );

    public boolean test(ItemStack main, ItemStack offhand) {
        return this.main.test(main) && this.offhand.test(offhand);
    }

    public boolean consumesOffHand() {
        return this.offhand.test(ItemStack.EMPTY);
    }
}
