package com.radimkozak.beerpong;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class Game
{
    Config cnf;
    public Game(Config config)
    {
        this.cnf = config;
    }

    private boolean validate()
    {
        if (this.cnf.team_blue.size() == this.cnf.team_red.size() &&
            !this.cnf.team_blue.isEmpty() && !this.cnf.team_red.isEmpty())
        {
            return true;
        }
        
        return false;
    }

    void reset_game(String message)
    {
        Bukkit.broadcastMessage(message);
        
        for (Location location : this.cnf.drunk_cups)
        {
            location.getBlock().setType(Material.AIR);
        }
        this.cnf.pure();

        this.cnf.in_game = false;
    }

    void play(String player, boolean drink)
    {
        if (this.cnf.drunkcups_blue == 10)
        {
            this.reset_game("BeerPong: Team RED win");
            return;
        }

        else if (this.cnf.drunkcups_red == 10)
        {
            this.reset_game("BeerPong: Team BLUE win");
            return;
        }

        Player pl = Bukkit.getPlayer(player);
        pl.teleport(this.cnf.hometown(player));

        if (drink)
        {
            Bukkit.broadcastMessage("BeerPong: Hit! Player " + player + " is drinking.");
        }

        Bukkit.broadcastMessage("BeerPong: Now playing " + player);
        pl.sendMessage("BeerPong: Your are now playing");
    }

    boolean start()
    {
        if (!this.validate())
        {
            Bukkit.broadcastMessage("BeerPong: Cannot start BeerPong. Your teams arent equal");
            return false;
        }

        if (this.cnf.in_game)
        {
            Bukkit.broadcastMessage("BeerPong: Cannot start already started game");
            return false;
        }

        Bukkit.broadcastMessage("BeerPong: Game just started");

        for(int i=0; i<this.cnf.team_blue.size(); i++)
        {
            this.cnf.player_queue.add(this.cnf.team_blue.get(i));
            this.cnf.player_queue.add(this.cnf.team_red.get(i));
        }

        this.cnf.player_queue_iterator = this.cnf.player_queue.iterator();
        this.cnf.in_game = true;
        this.play(this.cnf.nextPlayer(), false);
        return true;
    }
}