package io.github.cputnama11y.antipothicspawners.impl.util;

import com.google.common.collect.MapMaker;
import net.minecraft.server.packs.resources.PreparableReloadListener;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.function.Function;

public class StatefulPreparableReloadListener implements PreparableReloadListener {
    private final Map<SharedState, PreparableReloadListener> delegates = new MapMaker()
            .weakKeys()
            .weakValues()
            .makeMap();
    private final Function<SharedState, PreparableReloadListener> factory;
    private final String name;

    public StatefulPreparableReloadListener(String name, Function<SharedState, PreparableReloadListener> factory) {
        this.factory = factory;
        this.name = name;
    }

    @Override
    public void prepareSharedState(SharedState sharedState) {
        delegates.computeIfAbsent(sharedState, factory);
    }

    @Override
    public String getName() {
        return "StatefulWrapper(" + name + ")";
    }

    @Override
    public CompletableFuture<Void> reload(SharedState sharedState, Executor executor, PreparationBarrier preparationBarrier, Executor executor2) {
        return delegates.computeIfAbsent(sharedState, factory).reload(sharedState, executor, preparationBarrier, executor2);
    }
}
