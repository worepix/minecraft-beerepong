package com.radimkozak.beerpong;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class CommandTeamsList implements CommandExecutor {
    Config config;

    public CommandTeamsList(Config config) {
        this.config = config;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!sender.isOp())
        {
            return false;
        }

        sender.sendMessage("BeerPong: Team BLUE:" + config.team_blue);
        sender.sendMessage("BeerPong: Team RED:" + config.team_red);

        return true;
    }
}