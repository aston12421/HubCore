package com.skeet.skeethub.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.skeet.skeethub.Main;
import com.skeet.skeethub.hub.HubScoreboard;

public class ConfigReloadCommand implements CommandExecutor {

	public ConfigReloadCommand(Main plugin) {
		plugin.getCommand("hubreload").setExecutor(this);
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player) sender;
		Main.getInstance().reloadConfig();
		HubScoreboard.createScoreboard(player);
		player.sendMessage(Main.getInstance().getName() + " was reloaded");

		return false;
	}
}
