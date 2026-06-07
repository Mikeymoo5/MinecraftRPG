package dev.mikeymoo5.minecraftRPG.items.impl.statitems;

import dev.mikeymoo5.minecraftRPG.MinecraftRPG;
import dev.mikeymoo5.minecraftRPG.items.statitems.AbstractWand;
import dev.mikeymoo5.minecraftRPG.stats.PlayerProfile;
import dev.mikeymoo5.minecraftRPG.stats.StatManager;
import dev.mikeymoo5.minecraftRPG.stats.impl.item.Damage;
import dev.mikeymoo5.minecraftRPG.stats.impl.item.ManaCost;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

public class WoodenWand extends AbstractWand {

    StatManager statManager;
    public WoodenWand(MinecraftRPG plugin) {
        super(plugin, "WOODEN_WAND",
                new Damage(10, 10, 50),
                new ManaCost(10));

        statManager = ((MinecraftRPG) this.plugin).GetStatManager();
    }

    public void cast(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        PlayerProfile prof = statManager.getProfile(p);
//        if(prof.GetMana().spendMana(GetManaCost().GetValue())) {
            p.getWorld().strikeLightningEffect(p.getTargetBlockExact(10).getLocation());
//        }
    }
}
