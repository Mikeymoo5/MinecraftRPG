package dev.mikeymoo5.minecraftRPG.listeners;

import dev.mikeymoo5.minecraftRPG.events.PlayerStatChangeEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerStatChangeListener implements Listener {

    @EventHandler
    public void OnPlayerStatChange(PlayerStatChangeEvent e) {
        if(e.GetStat().GetName().equalsIgnoreCase("Level")) {
            Player p = Bukkit.getServer().getPlayer(e.GetPlayerProfile().GetUUID());
            p.sendMessage("Congratulations! You are now level " + e.GetNewValue());
        }
    }
}
