package dev.mikeymoo5.minecraftRPG.stats;

import dev.mikeymoo5.minecraftRPG.events.PlayerStatChangeEvent;
import dev.mikeymoo5.minecraftRPG.stats.impl.player.Level;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.UUID;

// TODO: Remove uuid field. It is redundant as you need the uuid to lookup the profile
public class PlayerProfile {
    private UUID uuid;
    private Level level;
    private FileConfiguration config;

    public Level GetLevel() { return level; }
    public UUID GetUUID() { return uuid; }

    public PlayerProfile(FileConfiguration config, UUID uuid) {
        this.uuid = uuid;
        this.config = config;
        this.level = new Level(config.getDouble("levling_constant"), 1);
        this.level.SetRunnableListener(() -> {
            double currentVal = this.level.GetValue();
            PlayerStatChangeEvent event = new PlayerStatChangeEvent(this, this.level, 0, currentVal);
            Bukkit.getPluginManager().callEvent(event);
        });
    }


}
