package dev.mikeymoo5.minecraftRPG.stats.impl.player;

import dev.mikeymoo5.minecraftRPG.stats.Stat;
import org.bukkit.Bukkit;

public class Level extends Stat {
    private transient double levelingConstant;
    private double xp;
        public double GetXp() { return xp; }

    public Level(double levelingConstant, double initialValue) {
        super("Level", initialValue);
        Bukkit.getLogger().info("Const = " + levelingConstant);
        this.levelingConstant = levelingConstant;
    }
//    @Override
//    public double getValue() {
//        return Math.floor(super.getValue());
//    }
    // Maybe make private?
    public void addXP(double diff) {
        xp += diff;
        // Should be correcting any irregularities in level too
        SetValue(Math.floor(calculateLevel()));
    }

    private double calculateLevel() {
        return Math.pow(xp / this.levelingConstant, 0.5);
    }

    //TODO: Having all stats have to be a double could be an issue?
    private double minimumXpForLevel(double level) {
        return Math.pow(level, 2) * this.levelingConstant;
    }


}
