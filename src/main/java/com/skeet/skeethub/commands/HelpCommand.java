package com.skeet.skeethub.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Player;

import com.skeet.skeethub.Main;

public class HelpCommand implements CommandExecutor {

	public HelpCommand(Main plugin) {
		plugin.getCommand("help").setExecutor(this);
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player) sender;

		player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7&m----------------Help----------------"));
		
		player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7&m-------------------------------------"));

		return false;
	}
}
