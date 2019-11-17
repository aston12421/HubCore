package com.skeet.skeethub.hub;

import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;

public class HubBoost implements org.bukkit.event.Listener
{
  public HubBoost() {}
  
  @EventHandler
  public void onPlayerFlight(PlayerToggleFlightEvent event) throws InterruptedException
  {
    Player player = event.getPlayer();
    if (player.getGameMode() == GameMode.CREATIVE)
      return;
    event.setCancelled(true);
    player.setAllowFlight(false);
    player.setVelocity(player.getLocation().getDirection().multiply(2.2D).setY(1.1D));
    player.playSound(player.getLocation(), org.bukkit.Sound.ENDERDRAGON_WINGS, 1.0F, 1.0F);
    player.getWorld().playEffect(player.getLocation(), Effect.MOBSPAWNER_FLAMES, 1);
  }
  




  @EventHandler
  public void onPlayerMove(PlayerMoveEvent event)
  {
    Player player = event.getPlayer();
    
    if ((player.getGameMode() != GameMode.CREATIVE) && 
      (player.getLocation().subtract(0.0D, 1.0D, 0.0D).getBlock().getType() != org.bukkit.Material.AIR)) {
      player.setAllowFlight(true);
    }
  }
}
