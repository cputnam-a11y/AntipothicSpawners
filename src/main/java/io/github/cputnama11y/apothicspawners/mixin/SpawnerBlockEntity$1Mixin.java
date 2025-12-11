package io.github.cputnama11y.apothicspawners.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import io.github.cputnama11y.apothicspawners.impl.ApothicAttachments;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BaseSpawner;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.SpawnerBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@SuppressWarnings("UnstableApiUsage")
@Mixin(targets = "net.minecraft.world.level.block.entity.SpawnerBlockEntity$1")
public class SpawnerBlockEntity$1Mixin extends BaseSpawnerMixin {
    @Unique
    private SpawnerBlockEntity spawner;

    @Inject(
            method = "<init>",
            at = @At("TAIL")
    )
    private void storeSpawner(SpawnerBlockEntity spawner, CallbackInfo ci) {
        this.spawner = spawner;
    }

    @Override
    protected boolean checkRedstoneControl(BaseSpawner instance, Level level, BlockPos blockPos, Operation<Boolean> original) {
        return super.checkRedstoneControl(instance, level, blockPos, original) && (!this.spawner.hasAttached(ApothicAttachments.REDSTONE_CONTROL) || (spawner.getLevel() != null && spawner.getLevel().hasNeighborSignal(spawner.getBlockPos())));
    }
}
