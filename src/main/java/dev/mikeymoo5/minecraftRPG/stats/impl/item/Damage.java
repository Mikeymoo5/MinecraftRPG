package dev.mikeymoo5.minecraftRPG.stats.impl.item;

import dev.mikeymoo5.minecraftRPG.stats.Stat;

public class Damage extends Stat {
    private final double maxDamage;
    private final double minDamage;
    private double damage;

    public double GetMaxDamage() { return maxDamage; }
    public double GetMinDamage() { return minDamage; }
    public double GetDamage() { return damage; }

    public Damage(double initialValue, double minDamage, double maxDamage) {
        super("Damage", 0);

        this.damage = GetValue();
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
    }
}
