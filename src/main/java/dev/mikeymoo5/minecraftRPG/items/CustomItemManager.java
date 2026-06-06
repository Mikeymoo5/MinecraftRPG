package dev.mikeymoo5.minecraftRPG.items;

import dev.mikeymoo5.minecraftRPG.MinecraftRPG;
import dev.mikeymoo5.minecraftRPG.items.impl.statitems.WoodenWand;

import java.util.HashSet;
import java.util.Set;

public class CustomItemManager {
    private final MinecraftRPG plugin;
    private final Set<AbstractItem> itemRegistery = new HashSet<>();
    // Maybe make this private
    public enum CUSTOM_ITEMS {
        WAND,
    }
    public CustomItemManager(MinecraftRPG plugin) {
        this.plugin = plugin;
        registerHandler(new WoodenWand(plugin, ));
    }

    public void registerHandler(AbstractItem... handlers) {
        for(AbstractItem handler : handlers) {
            this.registerHandler(handler);
        }
    }

    public void registerHandler(AbstractItem handler) {
        itemRegistery.add(handler);
        plugin.registerListener(handler);
    }

    // This is yet again some more wizardry; thanks (again) to @MitchGB on spigot for the tutorial
    public <T> T getHandler(Class<? extends T> clazz) {
        for(AbstractItem handler : itemRegistery) {
            if(handler.getClass().equals(clazz))
                return (T) handler;
        }
        return null;
    }

    public AbstractItem getHandler(String itemId) {
        for(AbstractItem handler : itemRegistery) {
            // TODO: Determine if ignore case should be required here
            if(handler.itemID.equalsIgnoreCase(itemId))
                return handler;
        }
        return null;
    }
}
