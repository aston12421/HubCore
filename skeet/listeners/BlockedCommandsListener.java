package skeet.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class BlockedCommandsListener implements org.bukkit.event.Listener
{
  public BlockedCommandsListener() {}
  
  @EventHandler
  public void onJoin(PlayerCommandPreprocessEvent event) {
    Player player = event.getPlayer();
    String message = event.getMessage();
    if (!player.hasPermission("skeet.staff.admin")) {
    	if (message.equalsIgnoreCase("/?") || message.equalsIgnoreCase("/plugins") || message.equalsIgnoreCase("/pl") || message.equalsIgnoreCase("/about") || message.equalsIgnoreCase("/ver") || message.equalsIgnoreCase("/version")) {
    		player.sendMessage(ChatColor.DARK_GREEN + "i dont think so...");
    		event.setCancelled(true);
    	}}
  }}