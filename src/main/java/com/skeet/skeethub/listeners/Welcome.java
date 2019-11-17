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
import com.skeet.skeethub.hub.Utils;

public class Welcome implements Listener {

	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		List<String> list = new ArrayList<String>();
		list = (List<String>) Main.getInstance().getConfig().getList("welcome.message");
		Player player = event.getPlayer();
		if (player.hasPlayedBefore()) {
			event.setJoinMessage(null);
			player.sendMessage(ChatColor.translateAlternateColorCodes('&',
					"&7&m----------------------------------------------------"));
			player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7 Welcome to " + Utils.welcome_servername + "&7, " + player.getName()));
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
