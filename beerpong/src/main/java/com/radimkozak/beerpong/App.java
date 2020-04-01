package com.radimkozak.beerpong;

import org.bukkit.plugin.java.JavaPlugin;

//import org.bukkit.configuration.file.FileConfiguration;
public class App extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("BeerPong: Let's get drunk");
        Config cnf = new Config();
        Game game = new Game(cnf);
        cnf.load("neco.yml");

        getCommand("AddBlue").setExecutor(new CommandAddBlue(cnf));
        getCommand("AddRed").setExecutor(new CommandAddRed(cnf));
        getCommand("PlayGround").setExecutor(new CommandPlayground(cnf));
        getCommand("RemoveBlue").setExecutor(new CommandRemoveBlue(cnf));
        getCommand("RemoveRed").setExecutor(new CommandRemoveRed(cnf));
        getCommand("TeamsList").setExecutor(new CommandTeamsList(cnf));
        getCommand("Start").setExecutor(new CommandStart(cnf, game));
        getCommand("Reset").setExecutor(new CommandReset(game));

        getServer().getPluginManager().registerEvents(new MyListener(cnf, game), this);
    }
    @Override
    public void onDisable() {
        getLogger().info("BeerPong: Seeya");
    }
}