package com.skeet.skeethub.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Player;

import com.skeet.skeethub.Main;
import com.skeet.skeethub.hub.HubScoreboard;
import com.skeet.skeethub.hub.Utils;

public class ConfigReloadCommand implements CommandExecutor {
	private Main plugin;

	public ConfigReloadCommand(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("hub").setExecutor(this);
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player) sender;

		if (!player.hasPermission("hub.admin")) {
			player.sendMessage(Utils.prefix + Utils.nopermission);
			if (args[0] == "reload") {
				plugin.reloadConfig();
				HubScoreboard.createScoreboard(player);
				player.sendMessage(plugin.getName() + " was reloaded");
			}
		}

		return false;
	}
}
