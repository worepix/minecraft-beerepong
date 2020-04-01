package com.radimkozak.beerpong;

import java.util.HashMap;
import java.util.Date;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.Material;
import org.bukkit.block.Block;

public class MyListener implements Listener
{
     Config config;
     Game game;

     public MyListener(Config config, Game game) {
          this.config = config;
          this.game = game;
     }

     @EventHandler
     public void onPlayerJoin(PlayerJoinEvent event)
     {
          event.getPlayer().sendMessage("BeerPong: Welcome to BeerPong Minecraft Edition!");
     }

     @EventHandler
     public void onPlayerMove(PlayerMoveEvent event)
     {    
          String player = event.getPlayer().getName();

          if (this.config.current_playing.equals(player) && this.config.in_game)
          {
               Block material = event.getPlayer().getLocation().getBlock();
               if (config.isBlueBukket(material.getType(), player))
               {
                    event.getPlayer().teleport(config.location_blue_spawn);

                    Location location = new Location(Bukkit.getWorld("world"), material.getLocation().getX(),
                                                     material.getLocation().getY()+2,
                                                     material.getLocation().getZ());
                    location.getBlock().setType(Material.DIAMOND_BLOCK);
                    this.config.drunk_cups.add(location);
                    this.config.drunkcups_blue++;
                    this.game.play(this.config.nextPlayer(), true);
               }
     
               else if (config.isRedBukket(material.getType(), player))
               {
                    event.getPlayer().teleport(config.location_red_spawn);

                    Location location = new Location(Bukkit.getWorld("world"), material.getLocation().getX(),
                                                     material.getLocation().getY()+2,
                                                     material.getLocation().getZ());
                    location.getBlock().setType(Material.DIAMOND_BLOCK);
                    this.config.drunk_cups.add(location);
                    this.config.drunkcups_red++;
                    this.game.play(this.config.nextPlayer(), true);
               }
     
               double[] coordinates = {event.getPlayer().getLocation().getX(),
                                       event.getPlayer().getLocation().getY(),
                                       event.getPlayer().getLocation().getZ()};
               if (config.isFailSpot(coordinates))
               {
                    event.getPlayer().teleport(config.hometown(player));

                    this.game.play(this.config.nextPlayer(), false);
                    return;
               }
          }
     }
}