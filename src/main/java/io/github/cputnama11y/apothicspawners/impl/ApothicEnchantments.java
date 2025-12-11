package io.github.cputnama11y.apothicspawners.impl;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.item.enchantment.Enchantment;
import org.jetbrains.annotations.NotNull;

import static io.github.cputnama11y.apothicspawners.impl.ApothicSpawners.id;
import static net.minecraft.world.item.enchantment.Enchantment.enchantment;

public class ApothicEnchantments {
    public static final ResourceKey<@NotNull Enchantment> CAPTURING = ResourceKey.create(
            Registries.ENCHANTMENT,
            id("capturing")
    );

    public static void bootstrap(BootstrapContext<@NotNull Enchantment> bootstrapContext) {

        register(
                bootstrapContext,
                CAPTURING,
                enchantment(
                        Enchantment.definition(
                                bootstrapContext.lookup(Registries.ITEM)
                                        .getOrThrow(ItemTags.SHARP_WEAPON_ENCHANTABLE),
                                bootstrapContext.lookup(Registries.ITEM).getOrThrow(ItemTags.SWORDS),
                                2,
                                3,
                                Enchantment.dynamicCost(15, 10),
                                Enchantment.dynamicCost(200, 0),
                                1,
                                EquipmentSlotGroup.MAINHAND
                        )
                ).withEffect(
                        ApothicEnchantmentEffectComponents.CAPTURING
                )
        );
    }

    private static void register(BootstrapContext<@NotNull Enchantment> bootstrapContext, ResourceKey<@NotNull Enchantment> resourceKey, Enchantment.Builder builder) {
        bootstrapContext.register(resourceKey, builder.build(resourceKey.identifier()));
    }
}
