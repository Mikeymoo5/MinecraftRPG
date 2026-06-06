package dev.mikeymoo5.minecraftRPG.commands;

import dev.mikeymoo5.minecraftRPG.MinecraftRPG;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class RpgCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

//        Todo: Add build time to the help command
        String version = MinecraftRPG.getPlugin(MinecraftRPG.class).getDescription().getVersion();
        commandSender.sendMessage("MinecraftRPG version: " + version + "\nCreated by Mikeymoo5");
        return true;
    }
}
