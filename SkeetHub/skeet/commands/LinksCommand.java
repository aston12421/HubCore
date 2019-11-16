package skeet.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Player;
import skeet.Main;

public class LinksCommand implements CommandExecutor
{
  private Main plugin;
  
  public LinksCommand(Main plugin)
  {
    this.plugin = plugin;
    plugin.getCommand("links").setExecutor(this);
  }
  

  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    Player player = (Player)sender;
    
    player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7&m------------------------------------"));
    player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7* &2&lForums: &7https://skeet.best"));
    player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7* &2&lTwitter: &7twitter.com/skeetnetwork"));
    player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7* &2&lDiscord: &7https://discord.gg/6fhEqWF"));
    player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7* &2&lStore: &7store.skeet.best"));
    player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7&m-------------------------------------"));
    
    return false;
  }
}
