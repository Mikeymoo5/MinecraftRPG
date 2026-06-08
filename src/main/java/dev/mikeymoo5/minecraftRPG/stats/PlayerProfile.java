package dev.mikeymoo5.minecraftRPG.stats;

import dev.mikeymoo5.minecraftRPG.events.PlayerStatChangeEvent;
import dev.mikeymoo5.minecraftRPG.stats.impl.player.Level;
import dev.mikeymoo5.minecraftRPG.stats.impl.player.Mana;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.UUID;

public class PlayerProfile {
    private UUID uuid;

    public UUID GetUUID() { return uuid; }
    // Stats
    private Level level;
    // TODO: Mana should not be transient, but the value should be? Potentially refactor.
    private transient Mana mana;


    public Level GetLevel() { return level; }
    public Mana GetMana() { return mana; }

    private transient FileConfiguration config;

    public PlayerProfile(FileConfiguration config, UUID uuid) {
        this.uuid = uuid;
        this.config = config;
        this.mana = new Mana(100, 200);
        this.level = new Level(config.getDouble("leveling.leveling_constant"), 1);
        this.level.SetRunnableListener(() -> {
            double currentVal = this.level.GetValue();
            PlayerStatChangeEvent event = new PlayerStatChangeEvent(this, this.level, 0, currentVal);
            Bukkit.getPluginManager().callEvent(event);
        });
    }


}
