package skeet.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class Welcome implements org.bukkit.event.Listener
{
  public Welcome() {}
  
  @EventHandler
  public void onJoin(PlayerJoinEvent event)
  {
    Player player = event.getPlayer();
    if (player.hasPlayedBefore()) {
      event.setJoinMessage(null);
      player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7&m----------------------------------------------------"));
      player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7 Welcome to the &2&lSkeet Network&7, " + player.getName()));
      player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7* &2&lForums: &7https://skeet.best"));
      player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7* &2&lTwitter: &7twitter.com/skeetnetwork"));
      player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7* &2&lDiscord: &7https://discord.gg/6fhEqWF"));
      player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7* &2&lStore: &7store.skeet.best"));
      player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7&m----------------------------------------------------"));
    }
  }
  

  @EventHandler
  public void onQuit(PlayerQuitEvent event)
  {
    Player player = event.getPlayer();
    event.setQuitMessage(null);
  }
}
