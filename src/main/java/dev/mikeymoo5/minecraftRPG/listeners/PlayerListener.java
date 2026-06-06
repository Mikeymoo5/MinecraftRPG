package dev.mikeymoo5.minecraftRPG.listeners;

import dev.mikeymoo5.minecraftRPG.stats.StatManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerListener implements Listener {
    private final StatManager manager;

    public PlayerListener(StatManager manager) {
        this.manager = manager;
    }

    @EventHandler
    public void OnPlayerJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        p.sendMessage("Welcome");

        manager.loadProfile(p);

    }

    @EventHandler
    public void OnPlayerQuit(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        manager.saveProfile(p);
        manager.removeProfileByPlayer(p);
    }
}
