package dev.mikeymoo5.minecraftRPG.stats;

public class Level extends Stat {
    double xp;
        public double GetXp() { return xp; }

    public Level(double initialValue) {
        super("Level", initialValue);

    }
//    @Override
//    public double getValue() {
//        return Math.floor(super.getValue());
//    }
    // Maybe make private?
    public void addXP(double diff) {
        xp += diff;
        // Should be correcting any irregularities in level too
        setValue(Math.floor(calculateLevel()));
    }

    private double calculateLevel() {
        int c = 7;
        return Math.pow(xp / c, 0.5);
    }

    //TODO: Having all stats have to be a double could be an issue?
    private double minimumXpForLevel(double level) {
        int c = 7;
        return Math.pow(level, 2) * c;
    }


}
