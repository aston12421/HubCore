package skeet.listeners;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;
import net.minecraft.server.v1_7_R4.ChatSerializer;
import net.minecraft.server.v1_7_R4.PacketPlayOutChat;

public class vanishtoolListener implements org.bukkit.event.Listener
{
  private PacketPlayOutChat packet;
  
  public vanishtoolListener(String message)
  {
    PacketPlayOutChat packet = new PacketPlayOutChat(ChatSerializer.a("{\"text\":\"" + message + "\"}"), (byte) 2);
    this.packet = packet;
  }
  
  public void Send(Player player) {
	  //((CraftPlayer) player).getHandle().playerConnection.sendPacket(packet); 	
	  }
  

  public static ArrayList<Player> hiding = new ArrayList <Player>();
  


  @EventHandler
  public void onPlayerJoin(PlayerJoinEvent event)
  {
    Player player = event.getPlayer();
    if (hiding.contains(player)) {
      ItemStack hidden = new ItemStack(Material.REDSTONE_TORCH_ON);
      ItemMeta hiddenMeta = hidden.getItemMeta();
      hiddenMeta.setDisplayName(ChatColor.DARK_GRAY + "�" + ChatColor.GREEN + "Show Players" + ChatColor.DARK_GRAY + "�");
      ArrayList<String> lore = new ArrayList();
      lore.add(ChatColor.GRAY + "Click to show all players");
      lore.add(ChatColor.DARK_GRAY + "(Toggles player visibility)");
      hiddenMeta.setLore(lore);
      hidden.setItemMeta(hiddenMeta);
      if (!player.getInventory().contains(hidden))
      {
        if ((!player.getInventory().contains(hidden)) && 
          (hiding.contains(player)))
          player.getInventory().setItem(8, hidden);
      }
    }
  }
  
  @EventHandler
  public void onPlayerJoin1(PlayerJoinEvent event) {
    Player player = event.getPlayer();
    if (!hiding.contains(player)) {
      ItemStack shown = new ItemStack(Material.LEVER);
      ItemMeta shownMeta = shown.getItemMeta();
      shownMeta.setDisplayName(ChatColor.DARK_GRAY + "�" + ChatColor.RED + "Hide Players" + ChatColor.DARK_GRAY + "�");
      ArrayList<String> lore = new ArrayList();
      lore.add(ChatColor.GRAY + "Click to hide all players");
      lore.add(ChatColor.DARK_GRAY + "(Toggles player visibility)");
      shownMeta.setLore(lore);
      shown.setItemMeta(shownMeta);
      if (!player.getInventory().contains(shown))
      {
        if ((!player.getInventory().contains(shown)) && 
          (!hiding.contains(player))) {
          player.getInventory().setItem(8, shown);
        }
      }
    }
  }
  
  @EventHandler
  public void OnHide(PlayerInteractEvent event)
  {
    Player player = event.getPlayer();
    Action action = event.getAction();
    ItemStack shown = new ItemStack(Material.LEVER);
    ItemMeta shownMeta = shown.getItemMeta();
    shownMeta.setDisplayName(ChatColor.DARK_GRAY + "�" + ChatColor.RED + "Hide Players" + ChatColor.DARK_GRAY + "�");
    ArrayList<String> lore = new ArrayList();
    lore.add(ChatColor.GRAY + "Click to hide all players");
    lore.add(ChatColor.DARK_GRAY + "(Toggles player visibility)");
    shownMeta.setLore(lore);
    shown.setItemMeta(shownMeta);
    
    if (player.getItemInHand().equals(shown)) {
      if ((action.equals(Action.RIGHT_CLICK_AIR)) || ((action.equals(Action.RIGHT_CLICK_BLOCK)) && (player.getItemInHand().equals(shown)))) {
        ItemStack hidden = new ItemStack(Material.REDSTONE_TORCH_ON);
        ItemMeta hiddenMeta = hidden.getItemMeta();
        hiddenMeta.setDisplayName(ChatColor.DARK_GRAY + "�" + ChatColor.GREEN + "Show Players" + ChatColor.DARK_GRAY + "�");
        ArrayList<String> lore1 = new ArrayList();
        lore1.add(ChatColor.GRAY + "Click to show all players");
        lore1.add(ChatColor.DARK_GRAY + "(Toggles player visibility)");
        hiddenMeta.setLore(lore1);
        hidden.setItemMeta(hiddenMeta);
        vanishtoolListener ab = new vanishtoolListener(ChatColor.DARK_GRAY + "�" + ChatColor.GRAY + "Toggled player visibility" + ChatColor.DARK_GRAY + "�");
        ab.Send(player);
        hiding.remove(player);
        player.getInventory().setItem(8, hidden);
        for (Player p : Bukkit.getOnlinePlayers()) {
          player.hidePlayer(p);
        }
      }
    } else {
      ItemStack hidden = new ItemStack(Material.REDSTONE_TORCH_ON);
      ItemMeta hiddenMeta = hidden.getItemMeta();
      hiddenMeta.setDisplayName(ChatColor.DARK_GRAY + "�" + ChatColor.GREEN + "Show Players" + ChatColor.DARK_GRAY + "�");
      ArrayList<String> lore1 = new ArrayList();
      lore1.add(ChatColor.GRAY + "Click to show all players");
      lore1.add(ChatColor.DARK_GRAY + "(Toggles player visibility)");
      hiddenMeta.setLore(lore1);
      hidden.setItemMeta(hiddenMeta);
      if ((player.getItemInHand().equals(hidden)) && ((action.equals(Action.RIGHT_CLICK_AIR)) || ((action.equals(Action.RIGHT_CLICK_BLOCK)) && (player.getItemInHand().equals(hidden))))) {
    	  vanishtoolListener ab = new vanishtoolListener(ChatColor.DARK_GRAY + "�" + ChatColor.GRAY + "Toggled player visibility" + ChatColor.DARK_GRAY + "�");
    	  ab.Send(player);
        hiding.add(player);
        player.getInventory().setItem(8, shown);
        for (Player p : Bukkit.getOnlinePlayers()) {
        		player.showPlayer(p);
        }
      }
    }
  }
}