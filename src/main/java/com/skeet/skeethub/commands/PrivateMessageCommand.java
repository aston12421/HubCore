package com.skeet.skeethub.commands;

import java.util.Arrays;
import java.util.LinkedList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.skeet.skeethub.Main;
import com.skeet.skeethub.hub.Utils;

public class PrivateMessageCommand implements CommandExecutor {

	public PrivateMessageCommand(Main plugin) {
		plugin.getCommand("message").setExecutor(this);
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player) sender;
		if (!player.hasPermission("skeet.pm")) {
			player.sendMessage(ChatColor.translateAlternateColorCodes('&', Utils.prefix + Utils.noperm));
		} else if (args.length == 0) {
			player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cUsage: /message <player> <message...>"));
		} else if (args.length >= 1) {
			Player target = Bukkit.getServer().getPlayer(args[0]);
			if (target.getName() == sender.getName()) {
				player.sendMessage(ChatColor.RED + "really?");
			} else if (args.length == 1) {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&',
						"&cUsage: /message " + target.getName() + " <message...>"));
			} else if ((args.length > 1) && (target != null)) {
				LinkedList<String> newArgs = new LinkedList(Arrays.asList(args));
				if (newArgs.contains(args[0])) {
					newArgs.remove(args[0]);
				}
				if (sender.hasPermission("skeet.pm.colour")) {
					target.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8(&2message&8) &7from &2"
							+ sender.getName() + " " + ChatColor.GRAY + String.join(" ", newArgs)));
					target.playSound(player.getLocation(), Sound.NOTE_PIANO, 999.0F, 1.0F);
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8(&2message&8) &7to &2"
							+ target.getName() + " " + ChatColor.GRAY + String.join(" ", newArgs)));
				} else if (!sender.hasPermission("skeet.pm.colour")) {
					target.sendMessage(ChatColor.DARK_GRAY + "(" + ChatColor.GREEN + "message" + ChatColor.DARK_GRAY
							+ ") " + ChatColor.GRAY + "from " + ChatColor.DARK_GREEN + sender.getName() + " "
							+ ChatColor.GRAY + String.join(" ", newArgs));
					target.playSound(player.getLocation(), Sound.NOTE_PIANO, 999.0F, 1.0F);
					sender.sendMessage(ChatColor.DARK_GRAY + "(" + ChatColor.GRAY + "message" + ChatColor.DARK_GRAY
							+ ") " + ChatColor.GRAY + "to " + ChatColor.DARK_GREEN + target.getName() + " "
							+ ChatColor.GRAY + String.join(" ", newArgs));
				}
			}
		}

		return false;
	}
}
