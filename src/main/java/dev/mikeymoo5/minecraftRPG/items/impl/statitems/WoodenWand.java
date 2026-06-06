package dev.mikeymoo5.minecraftRPG.items.impl.statitems;

import dev.mikeymoo5.minecraftRPG.items.statitems.AbstractWand;
import dev.mikeymoo5.minecraftRPG.stats.Stat;
import dev.mikeymoo5.minecraftRPG.stats.impl.item.Damage;
import dev.mikeymoo5.minecraftRPG.stats.impl.item.ManaUse;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class WoodenWand extends AbstractWand {

    public WoodenWand(JavaPlugin plugin) {
        super(plugin, "WOODEN_WAND",
                new Damage(10, 10, 50),
                new ManaUse(10));
    }

    public void use(PlayerInteractEvent e) {
        Player p = e.getPlayer();

    }
}
