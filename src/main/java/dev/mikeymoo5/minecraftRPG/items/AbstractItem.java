package dev.mikeymoo5.minecraftRPG.items;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;

import javax.xml.stream.events.Namespace;

public abstract class AbstractItem implements Listener {
    protected final JavaPlugin plugin;
    public final String itemID;
    public final Material material;

    public AbstractItem(JavaPlugin plugin, String itemID, Material material) {
        this.plugin = plugin;
        this.itemID = itemID;
        this.material = material;
    }

    public boolean isApplicable(ItemStack itemStack) {
        if(itemStack==null) return false;
        if(!itemStack.hasItemMeta()) return false;

        ItemMeta meta = itemStack.getItemMeta();
        PersistentDataContainer pdc = meta.getPersistentDataContainer();

        String pdcId = pdc.get(new NamespacedKey(plugin, "ITEM_ID"), PersistentDataType.STRING);
        return itemID.equals(pdcId);
    }

    public ItemStack getItem() {
        ItemStack itemStack = new ItemStack(material);
        ItemMeta meta = itemStack.getItemMeta();

        PersistentDataContainer pdc = meta.getPersistentDataContainer();
        pdc.set(new NamespacedKey(plugin, "ITEM_ID"), PersistentDataType.STRING, itemID);

        itemStack.setItemMeta(meta);

        return generateItem(itemStack);
    }

    protected abstract ItemStack generateItem(ItemStack itemStack);
}
