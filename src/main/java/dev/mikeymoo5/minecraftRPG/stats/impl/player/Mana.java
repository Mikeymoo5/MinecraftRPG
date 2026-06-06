package dev.mikeymoo5.minecraftRPG.stats.impl.player;

import dev.mikeymoo5.minecraftRPG.stats.Stat;

public class Mana extends Stat {
    double maxMana;

    public Mana(double initialValue, double maxMana) {
        super("Mana", initialValue);

        this.maxMana = maxMana;
    }

    @Override
    // Override as to not exceed the maximum amount of allowed mana
    public void add(double diff) {
        super.add(diff);
        if(GetValue() > this.maxMana) {
            SetValue(maxMana);
        }
    }
}
