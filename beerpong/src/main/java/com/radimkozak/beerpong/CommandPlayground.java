package com.radimkozak.beerpong;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class CommandPlayground implements CommandExecutor {
    Config config;

    public CommandPlayground(Config config) {
        this.config = config;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = Bukkit.getPlayer(sender.getName());

        player.teleport(config.location_blue_spawn);
        sender.sendMessage("BeerPong: Teleport to Playground");

        return true;
    } 
}