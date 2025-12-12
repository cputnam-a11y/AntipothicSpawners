package io.github.cputnama11y.apothicspawners.impl.enchantment;

import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.Unit;

import java.util.function.UnaryOperator;

import static io.github.cputnama11y.apothicspawners.impl.ApothicSpawners.id;

public interface ApothicEnchantmentEffectComponents {
    DataComponentType<Unit> CAPTURING = register(
            "capturing",
            builder -> builder
                    .persistent(Unit.CODEC)
                    .networkSynchronized(StreamCodec.unit(Unit.INSTANCE))
                    .cacheEncoding()
    );

    private static <T> DataComponentType<T> register(String name, UnaryOperator<DataComponentType.Builder<T>> unaryOperator) {
        return Registry.register(
                BuiltInRegistries.ENCHANTMENT_EFFECT_COMPONENT_TYPE,
                ResourceKey.create(
                        Registries.ENCHANTMENT_EFFECT_COMPONENT_TYPE,
                        id(name)
                ),
                unaryOperator
                        .apply(DataComponentType.builder())
                        .build()
        );
    }

    static void init() {

    }
}
