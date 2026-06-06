package dev.mikeymoo5.minecraftRPG.events;

import dev.mikeymoo5.minecraftRPG.stats.PlayerProfile;
import dev.mikeymoo5.minecraftRPG.stats.Stat;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;


public class PlayerStatChangeEvent extends Event {
    private static final HandlerList handlers = new HandlerList();

    private final PlayerProfile profile;
    private final Stat stat;
    private final double oldValue;
    private final double newValue;

    public PlayerStatChangeEvent(PlayerProfile profile, Stat stat, double oldValue, double newValue) {
        this.profile = profile;
        this.stat = stat;
        this.oldValue = oldValue;
        this.newValue = newValue;
    }

    public PlayerProfile getProfile() { return profile; }
    public Stat getStat() { return stat; }
    public double getOldValue() { return oldValue; }
    public double getNewValue() { return newValue; }

    @Override
    public HandlerList getHandlers() { return handlers; }
    public static HandlerList getHandlerList() { return handlers; }

}
