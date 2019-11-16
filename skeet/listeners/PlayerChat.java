package skeet.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import ru.tehkode.permissions.PermissionUser;

public class PlayerChat implements Listener
{
  public PlayerChat() {}
  
  @EventHandler
  public void chatFormat(AsyncPlayerChatEvent event)
  {
    Player player = event.getPlayer();
    PermissionUser user = ru.tehkode.permissions.bukkit.PermissionsEx.getUser(player);
    if (player.hasPermission("skeet.chat.trial-moderator")) {
      event.setFormat(ChatColor.translateAlternateColorCodes('&', user.getPrefix() + "&7 " + player.getDisplayName() + "&8: " + "&f" + event.getMessage()));
    }
    if (player.hasPermission("skeet.chat.moderator")) {
      event.setFormat(ChatColor.translateAlternateColorCodes('&', user.getPrefix() + "&7 " + player.getDisplayName() + "&8: " + "&f" + event.getMessage()));
    }
    if (player.hasPermission("skeet.chat.admin")) {
      event.setFormat(ChatColor.translateAlternateColorCodes('&', user.getPrefix() + "&7 " + player.getDisplayName() + "&8: " + "&f" + event.getMessage()));
    }
    if (player.hasPermission("skeet.chat.owner")) {
      event.setFormat(ChatColor.translateAlternateColorCodes('&', user.getPrefix() + "&7 " + player.getDisplayName() + "&8: " + "&f" + event.getMessage()));
    }
  }
}
