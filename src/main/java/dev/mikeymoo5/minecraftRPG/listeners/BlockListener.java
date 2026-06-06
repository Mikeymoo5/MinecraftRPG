package dev.mikeymoo5.minecraftRPG.listeners;

import dev.mikeymoo5.minecraftRPG.stats.StatManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockListener implements Listener {
    private StatManager manager;

    public BlockListener(StatManager manager) {
        this.manager = manager;
    }

    @EventHandler
    public void OnBlockBreak(BlockBreakEvent e) {
        Player p = e.getPlayer();
        manager.getProfile(p).GetLevel().addXP(1);
    }
}
