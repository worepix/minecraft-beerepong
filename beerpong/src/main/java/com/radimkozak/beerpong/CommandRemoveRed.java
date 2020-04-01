package com.radimkozak.beerpong;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class CommandRemoveRed implements CommandExecutor {
    Config config;

    public CommandRemoveRed(Config config) {
        this.config = config;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!sender.isOp())
        {
            return false;
        }

        if (args.length == 0)
        {
            sender.sendMessage("BeerPong: No given name");
            return true;
        }

        String player = args[0];
        if (Bukkit.getPlayerExact(player) != null)
        {
            if (config.remove_player_red(player))
            {
                Bukkit.broadcastMessage("BeerPong: Player " + player + " was removed from RED team");
            }

            else
            {
                sender.sendMessage("BeerPong: Player " + player + " not in RED team");
            }
        }
        return true;
    }
}