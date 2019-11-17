package com.skeet.skeethub.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import com.skeet.skeethub.Main;

import net.milkbowl.vault.chat.Chat;

public class PlayerChat implements Listener {
	public PlayerChat() {
	}

	@EventHandler
	public void chatFormat(AsyncPlayerChatEvent event) {
		Player player = event.getPlayer();
		Chat chat = Main.getInstance().getChat();
		event.setFormat(ChatColor.translateAlternateColorCodes('&',
				chat.getPlayerPrefix(player) + "&7 " + player.getDisplayName() + "&8: " + "&f" + event.getMessage()));
	}
}
