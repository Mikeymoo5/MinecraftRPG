package dev.mikeymoo5.minecraftRPG.commands;

import dev.mikeymoo5.minecraftRPG.items.AbstractItem;
import dev.mikeymoo5.minecraftRPG.items.CustomItemManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class GetCustomItemCommand implements CommandExecutor {
    // TODO: Should this be final?
    private CustomItemManager customItemManager;

    public GetCustomItemCommand(CustomItemManager customItemManager) {
        this.customItemManager = customItemManager;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        String itemArg;
        if(args.length == 0 || args.length > 1) {
            return false;
        }
        itemArg = args[0];
        Player p;
        if(sender instanceof Player) {
            p = (Player) sender;
        } else {
            sender.sendMessage("This command can only be run by a player");
            return true;
        }
        AbstractItem handler = customItemManager.getHandler(itemArg);
        if(handler == null) {
            p.sendMessage("That item does not exist!");
            return true;
        }
        ItemStack item = handler.getItem();

        p.getInventory().addItem(item);
        return true;
    }
}
