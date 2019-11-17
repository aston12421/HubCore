package com.skeet.skeethub.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.skeet.skeethub.Main;
import com.skeet.skeethub.hub.Utils;

public class HelpCommand implements CommandExecutor {

	public HelpCommand(Main plugin) {
		plugin.getCommand("help").setExecutor(this);
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player) sender;

		List<String> list = new ArrayList<String>();
		list = (List<String>) Main.getInstance().getConfig().getList("help.message");

		if (player.hasPermission("hub.admin")) {
			player.sendMessage(ChatColor.translateAlternateColorCodes('&',
					"&7&m----------------" + Utils.theme + "Help&7&m----------------"));
			player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7 - &7"));
			player.sendMessage(
					ChatColor.translateAlternateColorCodes('&', "&7&m-------------------------------------"));
		} else {
			player.sendMessage(ChatColor.translateAlternateColorCodes('&',
					"&7&m----------------" + Utils.theme + "Help&7&m----------------"));
			for (String string : list) {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', "" + string));
			}
			player.sendMessage(
					ChatColor.translateAlternateColorCodes('&', "&7&m-------------------------------------"));
		}
		return false;
	}
}
