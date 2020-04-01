package com.radimkozak.beerpong;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class CommandStart implements CommandExecutor {
    Config config;
    Game game;

    public CommandStart(Config config, Game game) {
        this.config = config;
        this.game = game;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!sender.isOp())
        {
            return false;
        }

        if (this.game.start())
        {
            return true;
        }

        return false;
    }
}