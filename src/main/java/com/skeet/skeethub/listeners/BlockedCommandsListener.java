package com.skeet.skeethub.listeners;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import com.skeet.skeethub.Main;
import com.skeet.skeethub.hub.Utils;

public class BlockedCommandsListener implements org.bukkit.event.Listener {
	private Main plugin;

	public BlockedCommandsListener(Main pl) {
		this.plugin = pl;
	}

	@EventHandler
	public void onJoin(PlayerCommandPreprocessEvent event) {
		List<String> list = new ArrayList<String>();
		list = (List<String>) plugin.getConfig().getList("hub.blockedcommands");
		Player player = event.getPlayer();
		String message = event.getMessage();
		if (!player.hasPermission("hub.admin")) {
			for (String string : list) {
				if (message.equalsIgnoreCase("/" + list)) {
					player.sendMessage(ChatColor.DARK_GREEN + Utils.unknowncommand);
					event.setCancelled(true);
				}
			}
		}
	}
}