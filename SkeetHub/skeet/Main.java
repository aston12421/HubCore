package skeet;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import skeet.commands.LinksCommand;
import skeet.commands.PrivateMessageCommand;
import skeet.hub.HubBoost;
import skeet.hub.HubScoreboard;
import skeet.listeners.BlockedCommandsListener;
import skeet.listeners.PlayerChat;
import skeet.listeners.PlayerEvents;
import skeet.listeners.Welcome;
import skeet.listeners.armour;
import skeet.listeners.vanishtoolListener;


public class Main
  extends JavaPlugin
  implements Listener
{
  public static Plugin plugin;
  public String getCommand;
  
  public Main() {}
  
  public void onEnable()
  {
	  
	  getConfig().options().copyDefaults(true);
	  saveConfig();
	  reloadConfig();
	  
	  Bukkit.getPluginManager().registerEvents(new vanishtoolListener(null), this);
    


    getCommand("message").setExecutor(new PrivateMessageCommand(this));
    getCommand("links").setExecutor(new LinksCommand(this));

 


    getServer().getPluginManager().registerEvents(new Welcome(), this);
    getServer().getPluginManager().registerEvents(new PlayerChat(), this);
    getServer().getPluginManager().registerEvents(new armour(), this);
    


    getServer().getPluginManager().registerEvents(new HubBoost(), this);
    getServer().getPluginManager().registerEvents(new HubScoreboard(), this);
    getServer().getPluginManager().registerEvents(new BlockedCommandsListener(), this);
    
    
    getServer().getPluginManager().registerEvents(new PlayerEvents(this), this);
  }
}
