package io.github.cputnama11y.apothicspawners.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BaseSpawner;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(BaseSpawner.class)
public class BaseSpawnerMixin {
    @WrapOperation(
            method = {"serverTick", "clientTick"},
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/level/BaseSpawner;isNearPlayer(Lnet/minecraft/world/level/Level;Lnet/minecraft/core/BlockPos;)Z"
            )
    )
    protected boolean checkRedstoneControl(BaseSpawner instance, Level level, BlockPos blockPos, Operation<Boolean> original) {
        return original.call(instance, level, blockPos);
    }
}
