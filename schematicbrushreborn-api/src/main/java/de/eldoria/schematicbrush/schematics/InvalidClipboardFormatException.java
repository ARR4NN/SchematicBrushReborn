/*
 *     SPDX-License-Identifier: AGPL-3.0-only
 *
 *     Copyright (C) 2021-2023 EldoriaRPG Team and Contributor
 */

package de.eldoria.schematicbrush.schematics;

public class InvalidClipboardFormatException extends RuntimeException {
    public InvalidClipboardFormatException(String message) {
        super(message);
    }
}
