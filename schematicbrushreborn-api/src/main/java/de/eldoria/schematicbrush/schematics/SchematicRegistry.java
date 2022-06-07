/*
 *     SPDX-License-Identifier: AGPL-3.0-only
 *
 *     Copyright (C) 2021 EldoriaRPG Team and Contributor
 */

package de.eldoria.schematicbrush.schematics;

/**
 * A registry to register, manage and retrieve a {@link SchematicCache}.
 */
public interface SchematicRegistry extends SchematicCacheHolder {

    /**
     * Reloads all registered caches.
     */
    void reload();

    /**
     * Returns the total amount of registered schematics
     *
     * @return schematic count.
     */
    int schematicCount();

    /**
     * Returns the total amount of registered directories
     *
     * @return directory count
     */
    int directoryCount();
}
