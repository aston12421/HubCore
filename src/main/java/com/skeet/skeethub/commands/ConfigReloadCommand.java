package com.skeet.skeethub.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Player;

import com.skeet.skeethub.Main;
import com.skeet.skeethub.hub.HubScoreboard;

public class ConfigReloadCommand implements CommandExecutor {
	private Main plugin;

	public ConfigReloadCommand(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("gloom").setExecutor(this);
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player) sender;
		plugin.reloadConfig();
		HubScoreboard.createScoreboard(player);
		player.sendMessage(plugin.getName() + " was reloaded");

		return false;
	}
}
