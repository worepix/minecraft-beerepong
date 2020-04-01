package com.radimkozak.beerpong;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class CommandReset implements CommandExecutor {
    Game game;

    public CommandReset(Game game) {
        this.game = game;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!sender.isOp())
        {
            return false;
        }

        this.game.reset_game("BeerPong: User reset game and teams");
        return true;
    }
}