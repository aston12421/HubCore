package com.skeet.skeethub.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.weather.WeatherChangeEvent;

import com.skeet.skeethub.Main;
import com.skeet.skeethub.commands.BuildCommand;

public class PlayerEvents implements Listener {


	@EventHandler
	public void onBlockBreak(BlockBreakEvent event) {
		Player player = event.getPlayer();
		if (!BuildCommand.buildmode.contains(player)) {
			event.setCancelled(true);
		}
	}

	@EventHandler
	public void onBlockPlace(BlockPlaceEvent event) {
		Player player = event.getPlayer();
		if (!BuildCommand.buildmode.contains(player)) {
			event.setCancelled(true);
		}
	}

	@EventHandler
	public void onItemPickup(PlayerPickupItemEvent event) {
		Player player = event.getPlayer();
		if (!BuildCommand.buildmode.contains(player)) {
			event.setCancelled(true);
		}
	}

	@EventHandler
	public void onInvMove(InventoryClickEvent event) {
		Player player = (Player) event.getWhoClicked();
		if (!BuildCommand.buildmode.contains(player)) {
			event.setCancelled(true);
		}
	}

	@EventHandler
	public void onItemDrop(PlayerDropItemEvent event) {
		Player player = event.getPlayer();
		if (!BuildCommand.buildmode.contains(player)) {
			event.setCancelled(true);
		}
	}

	@EventHandler
	public void onDamage(EntityDamageEvent event) {
		event.setCancelled(true);
	}

	@EventHandler
	public void onFood(FoodLevelChangeEvent event) {
		event.setCancelled(true);
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		player.setFoodLevel(20);
		player.setHealth(20);
	}

	@EventHandler
	public void onMobSpawn(CreatureSpawnEvent event) {
		event.setCancelled(true);
	}

	@EventHandler
	public void onWeather(WeatherChangeEvent event) {
		event.setCancelled(true);
	}

}
