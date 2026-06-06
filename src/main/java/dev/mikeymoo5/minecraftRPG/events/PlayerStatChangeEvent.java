package dev.mikeymoo5.minecraftRPG.events;

import dev.mikeymoo5.minecraftRPG.stats.PlayerProfile;
import dev.mikeymoo5.minecraftRPG.stats.Stat;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class PlayerStatChangeEvent extends StatChangeEvent {
    private final PlayerProfile pf;
    public PlayerProfile GetPlayerProfile() { return pf; }
    public PlayerStatChangeEvent(PlayerProfile pf, Stat stat, double oldValue, double newValue) {
        super(stat, oldValue, newValue);
        this.pf = pf;
        Bukkit.getLogger().info("Event Fired");
    }

}
