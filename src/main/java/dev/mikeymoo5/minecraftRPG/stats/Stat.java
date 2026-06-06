package dev.mikeymoo5.minecraftRPG.stats;

import dev.mikeymoo5.minecraftRPG.events.StatChangeEvent;
import org.bukkit.Bukkit;

public abstract class Stat {
    private String name;
    private double value;
    private Runnable onChange;

    public String GetName() { return name;}
    public double GetValue() { return value; }

    public void SetRunnableListener(Runnable onChange) { this.onChange = onChange; }

    public Stat(String name, double initialValue) {
        this.name = name;
        this.value = initialValue;
    }


    public void add(double diff) {
        setValue(this.value + diff);
    }

    public void setValue(double newValue) {
        double oldValue = this.value;
        this.value = newValue;
        Bukkit.getLogger().info("Set a value. Old: " + oldValue + " New: " + newValue + " This.value: " + this.value);

        if (oldValue != newValue && onChange != null) {
            Bukkit.getLogger().info("Running onChange");
            onChange.run();
        }
    }
}
