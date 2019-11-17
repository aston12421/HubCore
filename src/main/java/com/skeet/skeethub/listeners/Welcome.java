package com.skeet.skeethub.listeners;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import com.skeet.skeethub.Main;

public class Welcome implements Listener {

	private Main plugin;

	public Welcome(Main pl) {
		this.plugin = pl;
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		List<String> list = new ArrayList<String>();
		list = (List<String>) plugin.getConfig().getList("welcome.message");
		Player player = event.getPlayer();
		if (player.hasPlayedBefore()) {
			event.setJoinMessage(null);
			player.sendMessage(ChatColor.translateAlternateColorCodes('&',
					"&7&m----------------------------------------------------"));
			player.sendMessage(ChatColor.translateAlternateColorCodes('&',
					"&7 Welcome to " + plugin.getConfig().getString("welcome.servername") + "&7, " + player.getName()));
			for (String string : list) {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', "" + string));
			}
			player.sendMessage(ChatColor.translateAlternateColorCodes('&',
					"&7&m----------------------------------------------------"));
		}
	}

	@EventHandler
	public void onQuit(PlayerQuitEvent event) {
		event.setQuitMessage(null);
	}
}
