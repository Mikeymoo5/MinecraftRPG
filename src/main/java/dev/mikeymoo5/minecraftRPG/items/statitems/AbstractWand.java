package dev.mikeymoo5.minecraftRPG.items.statitems;

import dev.mikeymoo5.minecraftRPG.items.AbstractItem;
import dev.mikeymoo5.minecraftRPG.stats.Stat;
import dev.mikeymoo5.minecraftRPG.stats.impl.item.Damage;
import dev.mikeymoo5.minecraftRPG.stats.impl.item.ManaUse;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public abstract class AbstractWand extends AbstractItem {
    private Damage damage;
    private ManaUse manaUse;

    // TODO: Figure out how only allow stat array of length 2
    public AbstractWand(JavaPlugin plugin, String itemID, Damage damage, ManaUse manaUse) {
        super(plugin, itemID, Material.STICK);

        this.damage = damage;
        this.manaUse = manaUse;

    }

    public abstract void use(PlayerInteractEvent e);

    @Override
    protected ItemStack generateItem(ItemStack itemStack) {
        ItemMeta meta = itemStack.getItemMeta();
        String name = ChatColor.translateAlternateColorCodes('&', "&eWand");
        meta.setDisplayName(name);

        itemStack.setItemMeta(meta);
        return itemStack;
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        ItemStack item = p.getInventory().getItemInMainHand();

        if(!isApplicable(item)) return;
        use(e);
//        String message = ChatColor.translateAlternateColorCodes('&', "&5Spell");
//        p.sendMessage(message);
    }
}
