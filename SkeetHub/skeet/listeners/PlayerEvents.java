package skeet.listeners;

import org.bukkit.ChatColor;

import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.weather.WeatherChangeEvent;

import skeet.Main;

public class PlayerEvents implements Listener
{
  private Main plugin;
  
  public PlayerEvents(Main pl) {
	  plugin = pl;
  }
  
  @EventHandler
  public void onBlockBreak(BlockBreakEvent event)
  {
    Player player = event.getPlayer();
    if (!player.isOp()) {
      event.setCancelled(true);
    } else {
      event.setCancelled(false);
    }
  }
  
  @EventHandler
  public void onBlockPlace(BlockPlaceEvent event) {
    Player player = event.getPlayer();
    if (!player.isOp()) {
      event.setCancelled(true);
    } else {
      event.setCancelled(false);
    }
  }
  
  @EventHandler
  public void onChat(AsyncPlayerChatEvent event)
  {
    Player player = event.getPlayer();
    if (!player.hasPermission("skeet.staff")) {
      event.setCancelled(true);
      String prefix = plugin.getConfig().getString("prefix");
      player.sendMessage(ChatColor.translateAlternateColorCodes('&', (prefix + " &7You cannot chat in this area!")));
    }
    else if (player.hasPermission("skeet.staff")) {
      event.setCancelled(false);
    }
  }
  
  @EventHandler
  public void onItemPickup(PlayerPickupItemEvent event)
  {
    Player player = event.getPlayer();
    if (!player.isOp()) {
      event.setCancelled(true);
    } else {
      event.setCancelled(false);
    }
  }
  
  @EventHandler
  public void onInvMove(InventoryClickEvent event) {
    HumanEntity player = event.getWhoClicked();
    if (!player.isOp()) {
      event.setCancelled(true);
    } else {
      event.setCancelled(false);
    }
  }
  
  @EventHandler
  public void onItemDrop(PlayerDropItemEvent event)
  {
    Player player = event.getPlayer();
    if (!player.isOp()) {
      event.setCancelled(true);
    } else {
      event.setCancelled(false);
    }
  }
  
  @EventHandler
  public void onDamage(EntityDamageEvent event)
  {
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
