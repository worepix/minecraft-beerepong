package com.radimkozak.beerpong;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class CommandAddBlue implements CommandExecutor {
    Config config;

    public CommandAddBlue(Config config) {
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
            if (config.add_player_blue(player))
            {
                Bukkit.broadcastMessage("BeerPong: Player " + player + " was added to BLUE team");
            }

            else
            {
                sender.sendMessage("BeerPong: Player " + player + " is already in some team");
            }
        }
        return true;
    }
}