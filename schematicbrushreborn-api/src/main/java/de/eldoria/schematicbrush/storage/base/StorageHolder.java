/*
 *     SPDX-License-Identifier: AGPL-3.0-only
 *
 *     Copyright (C) 2021 EldoriaRPG Team and Contributor
 */

package de.eldoria.schematicbrush.storage.base;

import de.eldoria.schematicbrush.brush.config.util.Nameable;
import de.eldoria.schematicbrush.storage.Storage;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * An interface which represents a Storageholder, holding any type of {@link Storage} implementation.
 * @param <T> type of storage
 */
public interface StorageHolder<T extends Storage> {
    /**
     * Get a storage type
     * @param key name of storage
     * @return storage type if it is present
     */
    @Nullable
    T getRegistry(Nameable key);

    /**
     * Registers a new storage type.
     *
     * @param key     key
     * @param storage the storage access provider
     * @throws IllegalStateException when a storage with this type is already registered.
     */
    void register(Nameable key, T storage) throws IllegalStateException;

    /**
     * Unregisters a storage type
     *
     * @param key key
     */
    void unregister(Nameable key);

    /**
     * Get an unmodifiable map of all registerd storagetypes.
     *
     * @return unmodifiable map
     */
    Map<Nameable, T> storages();

    /**
     * Migrate a source storage into a target storage
     *
     * @param source source
     * @param target target
     * @return Returns a future which completes once all underlying processes complete
     */
    CompletableFuture<Void> migrate(Nameable source, Nameable target);
}
