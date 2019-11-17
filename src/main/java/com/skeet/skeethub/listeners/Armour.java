package com.skeet.skeethub.listeners;

import java.util.ArrayList;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import com.skeet.skeethub.Main;

import net.md_5.bungee.api.ChatColor;
import net.milkbowl.vault.chat.Chat;

public class Armour implements Listener {

	@EventHandler
	public void onFirstJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		Chat chat = Main.getInstance().getChat();
		if (chat.playerInGroup(player, "owner")) {
			ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
			LeatherArmorMeta meta = (LeatherArmorMeta) helm.getItemMeta();
			meta.setColor(Color.fromRGB(255, 0, 0));
			meta.setDisplayName(ChatColor.GRAY + player.getName());
			ArrayList<String> lore = new ArrayList();
			lore.add(ChatColor.translateAlternateColorCodes('&', "&7Rank: " + chat.getPlayerSuffix(player)));
			meta.setLore(lore);
			helm.setItemMeta(meta);
			player.getInventory().setHelmet(helm);

		} else if (chat.playerInGroup(player, "default")) {
			ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
			LeatherArmorMeta meta = (LeatherArmorMeta) helm.getItemMeta();
			meta.setColor(Color.fromRGB(100, 100, 100));
			meta.setDisplayName(ChatColor.GRAY + player.getName());
			ArrayList<String> lore = new ArrayList();
			lore.add(ChatColor.translateAlternateColorCodes('&', "&7Rank: " + chat.getPlayerSuffix(player)));
			meta.setLore(lore);
			helm.setItemMeta(meta);
			player.getInventory().setHelmet(helm);

		} else if (chat.playerInGroup(player, "admin")) {
			ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
			LeatherArmorMeta meta = (LeatherArmorMeta) helm.getItemMeta();
			meta.setColor(Color.fromRGB(255, 112, 112));
			meta.setDisplayName(ChatColor.GRAY + player.getName());
			ArrayList<String> lore = new ArrayList();
			lore.add(ChatColor.translateAlternateColorCodes('&', "&7Rank: " + chat.getPlayerSuffix(player)));
			meta.setLore(lore);
			helm.setItemMeta(meta);
			player.getInventory().setHelmet(helm);

		} else if (chat.playerInGroup(player, "moderator")) {
			ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
			LeatherArmorMeta meta = (LeatherArmorMeta) helm.getItemMeta();
			meta.setColor(Color.fromRGB(0, 149, 255));
			meta.setDisplayName(ChatColor.GRAY + player.getName());
			ArrayList<String> lore = new ArrayList();
			lore.add(ChatColor.translateAlternateColorCodes('&', "&7Rank: " + chat.getPlayerSuffix(player)));
			meta.setLore(lore);
			helm.setItemMeta(meta);
			player.getInventory().setHelmet(helm);

		} else if (chat.playerInGroup(player, "trial-moderator")) {
			ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
			LeatherArmorMeta meta = (LeatherArmorMeta) helm.getItemMeta();
			meta.setColor(Color.fromRGB(212, 0, 255));
			meta.setDisplayName(ChatColor.GRAY + player.getName());
			ArrayList<String> lore = new ArrayList();
			lore.add(ChatColor.translateAlternateColorCodes('&', "&7Rank: " + chat.getPlayerSuffix(player)));
			meta.setLore(lore);
			helm.setItemMeta(meta);
			player.getInventory().setHelmet(helm);
		}
	}
}
