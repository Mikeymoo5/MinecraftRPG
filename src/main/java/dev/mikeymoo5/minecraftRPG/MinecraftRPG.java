package dev.mikeymoo5.minecraftRPG;

import dev.mikeymoo5.minecraftRPG.commands.GetCustomItemCommand;
import dev.mikeymoo5.minecraftRPG.commands.LevelCommand;
import dev.mikeymoo5.minecraftRPG.commands.RpgCommand;
import dev.mikeymoo5.minecraftRPG.items.CustomItemManager;
import dev.mikeymoo5.minecraftRPG.listeners.BlockListener;
import dev.mikeymoo5.minecraftRPG.listeners.PlayerListener;
import dev.mikeymoo5.minecraftRPG.listeners.PlayerStatChangeListener;
import dev.mikeymoo5.minecraftRPG.stats.StatManager;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.checkerframework.checker.units.qual.C;

public final class MinecraftRPG extends JavaPlugin {
    private StatManager manager;
    public CustomItemManager customItemManager;
    private FileConfiguration config;
    @Override
    public void onEnable() {
        this.manager = new StatManager(getConfig(), this);
        // create the config.yml file if it does not yet exist
        this.saveDefaultConfig();
        this.config = getConfig();
        this.customItemManager = new CustomItemManager(this);


        // Register Commands
        getCommand("rpg").setExecutor(new RpgCommand());
        getCommand("level").setExecutor(new LevelCommand(manager));
        getCommand("rpgget").setExecutor(new GetCustomItemCommand(customItemManager));

        // Register Events
        getServer().getPluginManager().registerEvents(new PlayerListener(manager), this);
        getServer().getPluginManager().registerEvents(new BlockListener(manager), this);
        getServer().getPluginManager().registerEvents(new PlayerStatChangeListener(), this);

        getLogger().info("MinecraftRPG plugin started");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        // TODO: Not sure this.config is just a pointer to getConfig() or not
        saveConfig();
    }
    // This is still a bit foreign to me. Thanks to @MitchGB on Github for the tutorial
    public void registerListener(Listener... listeners){
        for(Listener listener : listeners){
            getServer().getPluginManager().registerEvents(listener, this);
        }
    }
}