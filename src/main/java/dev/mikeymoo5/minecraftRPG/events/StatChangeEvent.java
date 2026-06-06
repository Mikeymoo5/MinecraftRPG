package dev.mikeymoo5.minecraftRPG.events;

import dev.mikeymoo5.minecraftRPG.stats.Stat;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;


public class StatChangeEvent extends Event {
    private static final HandlerList handlers = new HandlerList();

    private final Stat stat;
    private final double oldValue;
    private final double newValue;

    public StatChangeEvent(Stat stat, double oldValue, double newValue) {
        this.stat = stat;
        this.oldValue = oldValue;
        this.newValue = newValue;
    }

    public Stat GetStat() { return stat; }
    public double GetOldValue() { return oldValue; }
    public double GetNewValue() { return newValue; }

    @Override
    public HandlerList getHandlers() { return handlers; }
    public static HandlerList getHandlerList() { return handlers; }

}
