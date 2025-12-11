package io.github.cputnama11y.apothicspawners.impl;

import net.fabricmc.fabric.api.attachment.v1.AttachmentRegistry;
import net.fabricmc.fabric.api.attachment.v1.AttachmentSyncPredicate;
import net.fabricmc.fabric.api.attachment.v1.AttachmentType;
import net.minecraft.util.Unit;

import static io.github.cputnama11y.apothicspawners.impl.ApothicSpawners.id;

@SuppressWarnings("UnstableApiUsage")
public class ApothicAttachments {
    public static final AttachmentType<Unit> REDSTONE_CONTROL = AttachmentRegistry.create(
            id("redstone_control"),
            builder -> builder
                    .persistent(Unit.CODEC)
                    .syncWith(Unit.STREAM_CODEC, AttachmentSyncPredicate.all())
    );
}
