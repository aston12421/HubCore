package com.skeet.skeethub.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;

import com.skeet.skeethub.commands.BuildCommand;

public class BuildModeListener implements Listener {
	public BuildModeListener() {
	}

	@EventHandler
	public void BlockPlace(BlockPlaceEvent event) {
		Player player = event.getPlayer();

		if (player.hasPermission("hub.build")) {
			if (BuildCommand.buildmode.contains(player)) {
				event.setCancelled(false);
			}
		}
	}

	@EventHandler
	public void onBlockBreak(BlockBreakEvent event) {
		Player player = event.getPlayer();

		if (player.hasPermission("hub.build")) {
			if (BuildCommand.buildmode.contains(player)) {
				event.setCancelled(false);
			}
		}
	}

	@EventHandler
	public void onItemPickup(PlayerPickupItemEvent event) {
		Player player = event.getPlayer();

		if (player.hasPermission("hub.build")) {
			if (BuildCommand.buildmode.contains(player)) {
				event.setCancelled(false);
			}
		}
	}

	@EventHandler
	public void onInvMove(InventoryClickEvent event) {
		Player player = (Player) event.getWhoClicked();

		if (player.hasPermission("hub.build")) {
			if (BuildCommand.buildmode.contains(player)) {
				event.setCancelled(false);
			}
		}
	}

	@EventHandler
	public void onItemDrop(PlayerDropItemEvent event) {
		Player player = event.getPlayer();

		if (player.hasPermission("hub.build")) {
			if (BuildCommand.buildmode.contains(player)) {
				event.setCancelled(false);
			}
		}
	}
}
