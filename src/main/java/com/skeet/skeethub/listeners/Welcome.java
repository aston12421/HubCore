package com.skeet.skeethub.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import com.skeet.skeethub.Main;

public class Welcome implements org.bukkit.event.Listener
{
	private Main plugin;
  public Welcome() {}
  
  @EventHandler
  public void onJoin(PlayerJoinEvent event)
  {
    Player player = event.getPlayer();
    if (player.hasPlayedBefore()) {
      event.setJoinMessage(null);
      player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7&m----------------------------------------------------"));
      player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7 Welcome to the " + plugin.getConfig().getString("welcome.servername")+ "&7, " + player.getName()));
      if (plugin.getConfig().getString("welcome.socials.toggle.forums") == "on") {
    	  player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7* &2&lForums: " + plugin.getConfig().getString("welcome.socials.url.forums")));
      }
      if (plugin.getConfig().getString("welcome.socials.toggle.twitter") == "on") {
    	  player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7* &2&lTwitter: " + plugin.getConfig().getString("welcome.socials.url.forums")));
      }
      if (plugin.getConfig().getString("welcome.socials.toggle.discord") == "on") {
    	  player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7* &2&lDiscord: " + plugin.getConfig().getString("welcome.socials.url.forums")));
      }
      if (plugin.getConfig().getString("welcome.socials.toggle.store") == "on") {
    	  player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7* &2&lStore: " + plugin.getConfig().getString("welcome.socials.url.forums")));
      }
      player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7&m----------------------------------------------------"));
    }
  }
  

  @EventHandler
  public void onQuit(PlayerQuitEvent event)
  {
    event.setQuitMessage(null);
  }
}
