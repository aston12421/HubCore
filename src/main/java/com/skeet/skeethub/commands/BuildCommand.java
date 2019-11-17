package com.skeet.skeethub.commands;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Player;

import com.skeet.skeethub.Main;
import com.skeet.skeethub.hub.Utils;

public class BuildCommand implements CommandExecutor {
	private Main plugin;

	public BuildCommand(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("build").setExecutor(this);
	}

	public static ArrayList<Player> buildmode = new ArrayList<Player>();

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		Player player = (Player) sender;

		if (!player.hasPermission("hub.build")) {
			player.sendMessage(Utils.prefix + Utils.nopermission);
		}
		if (player.hasPermission("hub.build")) {
			if (!buildmode.contains(player)) {
				buildmode.add(player);
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&abuildmode enabled"));
			} else
				if (player.hasPermission("hub.build")) {
					if (buildmode.contains(player)) {
						buildmode.remove(player);
						player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cbuildmode disabled"));
				}
			}
		}

		return false;
	}
}
