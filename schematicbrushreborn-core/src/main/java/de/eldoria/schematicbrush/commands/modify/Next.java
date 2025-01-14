/*
 *     SPDX-License-Identifier: AGPL-3.0-only
 *
 *     Copyright (C) 2021 EldoriaRPG Team and Contributor
 */

package de.eldoria.schematicbrush.commands.modify;

import de.eldoria.eldoutilities.commands.command.AdvancedCommand;
import de.eldoria.eldoutilities.commands.command.CommandMeta;
import de.eldoria.eldoutilities.commands.command.util.Arguments;
import de.eldoria.eldoutilities.commands.command.util.CommandAssertions;
import de.eldoria.eldoutilities.commands.exceptions.CommandException;
import de.eldoria.eldoutilities.commands.executor.IPlayerTabExecutor;
import de.eldoria.eldoutilities.messages.MessageChannel;
import de.eldoria.eldoutilities.messages.MessageType;
import de.eldoria.schematicbrush.brush.SchematicBrush;
import de.eldoria.schematicbrush.util.WorldEditBrush;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class Next extends AdvancedCommand implements IPlayerTabExecutor {
    public Next(Plugin plugin) {
        super(plugin, CommandMeta.builder("next")
                .build());
    }

    @Override
    public void onCommand(@NotNull Player player, @NotNull String alias, @NotNull Arguments args) throws CommandException {
        Optional<SchematicBrush> schematicBrush = WorldEditBrush.getSchematicBrush(player);
        CommandAssertions.isTrue(schematicBrush.isPresent(), "You are not holding a schematic brush");
        if (schematicBrush.get().nextPaste().nextSchematic()) {
            messageSender().send(MessageChannel.ACTION_BAR, MessageType.NORMAL, player, "§2Skipped Schematic.");
        } else {
            messageSender().send(MessageChannel.ACTION_BAR, MessageType.ERROR, player, "The brush contains only 1 schematic");
        }
    }
}
