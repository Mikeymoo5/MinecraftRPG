package dev.mikeymoo5.minecraftRPG;

import dev.mikeymoo5.minecraftRPG.commands.LevelCommand;
import dev.mikeymoo5.minecraftRPG.commands.RpgCommand;
import dev.mikeymoo5.minecraftRPG.listeners.BlockListener;
import dev.mikeymoo5.minecraftRPG.listeners.PlayerListener;
import dev.mikeymoo5.minecraftRPG.listeners.PlayerStatChangeListener;
import dev.mikeymoo5.minecraftRPG.stats.StatManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class MinecraftRPG extends JavaPlugin {
    private StatManager manager;

    @Override
    public void onEnable() {
        // Plugin startup logic
        manager = new StatManager(this);
        getLogger().info("Hello!");

        // Register Commands
        getCommand("rpg").setExecutor(new RpgCommand());
        getCommand("level").setExecutor(new LevelCommand(manager));

        // Register Events
        getServer().getPluginManager().registerEvents(new PlayerListener(manager), this);
        getServer().getPluginManager().registerEvents(new BlockListener(manager), this);
        getServer().getPluginManager().registerEvents(new PlayerStatChangeListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
