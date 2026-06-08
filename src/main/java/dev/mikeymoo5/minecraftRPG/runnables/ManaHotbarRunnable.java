package dev.mikeymoo5.minecraftRPG.runnables;

import dev.mikeymoo5.minecraftRPG.stats.StatManager;
import dev.mikeymoo5.minecraftRPG.stats.impl.player.Mana;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class ManaHotbarRunnable extends BukkitRunnable {
    private StatManager manager;

    public ManaHotbarRunnable(StatManager manager) {
        this.manager = manager;
    }

    @Override
    public void run() {
        for(Player p : Bukkit.getOnlinePlayers()) {
            Mana mana = manager.getProfile(p).GetMana();
            p.spigot().sendMessage(ChatMessageType.ACTION_BAR,
                    new TextComponent(ChatColor.AQUA + "Mana: " + mana.GetValue()));
        }
    }
}
