package dev.mikeymoo5.minecraftRPG.commands;

import dev.mikeymoo5.minecraftRPG.stats.PlayerProfile;
import dev.mikeymoo5.minecraftRPG.stats.StatManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LevelCommand implements CommandExecutor {
    private final StatManager manager;
    public LevelCommand(StatManager manager) {
        this.manager = manager;
    }
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        PlayerProfile prof = manager.getProfile((Player) commandSender);
        commandSender.sendMessage("Your current level is: " + prof.GetLevel().GetValue() + " And your current XP is: " + prof.GetLevel().GetXp());
        return true;
    }
}
