package com.radimkozak.beerpong;

import java.util.ArrayList;
import java.util.Iterator;
//import java.util.ArrayList;
import java.util.HashMap;
import java.lang.Math;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Location;

public class Config {
    ArrayList<String> team_blue = new ArrayList<String>();
    ArrayList<String> team_red = new ArrayList<String>();
    ArrayList<String> player_queue = new ArrayList<String>();
    ArrayList<Location> drunk_cups = new ArrayList<Location>();

    Iterator player_queue_iterator;
    String current_playing = "";

    final double FailSpotX1 = 8.7;
    final double FailSpotZ1 = -164.7;

    final double FailSpotX2 = -26.7;
    final double FailSpotZ2 = -98.3;

    final double FailZ = 5.0;

    Location location_blue_spawn = new Location(Bukkit.getWorld("world"), -8.45, 23, -170);
    Location location_red_spawn = new Location(Bukkit.getWorld("world"), -8.45, 23, -95);
    Location location_red_tribune = new Location(Bukkit.getWorld("world"), -33.49, 8, -131.7);

    int drunkcups_blue = 0;
    int drunkcups_red = 0;

    boolean in_game = false;

    boolean load(String path) {
        return true;
    }

    void pure()
    {
        this.team_blue.clear();
        this.team_red.clear();
        this.current_playing = "";
        this.drunkcups_blue = 0;
        this.drunkcups_red = 0;
        this.drunk_cups.clear();
    }

    boolean add_player_blue(String name)
    {
        if (team_blue.contains(name) || team_red.contains(name))
        {
            return false;
        }
        team_blue.add(name);
        return true;
    }

    boolean add_player_red(String name)
    {
        if (team_red.contains(name) || team_blue.contains(name))
        {
            return false;
        }
        team_red.add(name);
        return true;
    }

    boolean remove_player_blue(String name)
    {
        if (!team_blue.contains(name))
        {
            return false;
        }
        team_blue.remove(name);
        return true;
    }

    boolean remove_player_red(String name)
    {
        if (!team_red.contains(name))
        {
            return false;
        }
        team_red.remove(name);
        return true;
    }

    boolean isBlueBukket(Material material, String player) {
        if ((material == Material.WATER || material == Material.STATIONARY_WATER) && team_blue.contains(player))
        {
            return true;
        }
        return false;
    }

    boolean isRedBukket(Material material, String player) {
        if ((material == Material.LAVA || material == Material.STATIONARY_LAVA) && team_red.contains(player))
        {
            return true;
        }
        return false;
    }

    boolean isFailSpot(double[] coordinates) {
        if ((FailSpotX2 <= coordinates[0] && coordinates[0] <= FailSpotX1) &&
            (FailSpotZ1 <= coordinates[2] && coordinates[2] <= FailSpotZ2) &&
            coordinates[1] == FailZ)
        {
            return true;
        }

        return false;
    }

    String nextPlayer()
    {
        if(!this.player_queue_iterator.hasNext())
        {
            this.player_queue_iterator = this.player_queue.iterator();
        }

        return this.current_playing = this.player_queue_iterator.next().toString();
    }

    Location hometown(String name) {
        if (team_blue.contains(name))
        {
            return location_blue_spawn;
        }

        else if (team_red.contains(name))
        {
            return location_red_spawn;
        }

        return location_red_tribune;
    }
}