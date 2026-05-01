package io.github.cputnama11y.antipothicspawners.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import io.github.cputnama11y.antipothicspawners.impl.mixinsupport.StateHolder;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.animal.golem.IronGolem;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(IronGolem.class)
public class IronGolemMixin {
    @WrapOperation(
            method = "checkSpawnObstruction",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/state/BlockState;entityCanStandOn(Lnet/minecraft/world/level/BlockGetter;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/entity/Entity;)Z")
    )
    private boolean ironGolemsAreStupid(BlockState instance, BlockGetter blockGetter, BlockPos blockPos, Entity entity, Operation<Boolean> original) {
        return original.call(instance, blockGetter, blockPos, entity) || StateHolder.SPAWNING_WITHOUT_MOJANK_STUPIDITY.get().isPresent();
    }
}
