package com.skeet.skeethub;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import com.skeet.skeethub.commands.ConfigReloadCommand;
import com.skeet.skeethub.commands.LinksCommand;
import com.skeet.skeethub.commands.PrivateMessageCommand;
import com.skeet.skeethub.hub.HubBoost;
import com.skeet.skeethub.hub.HubScoreboard;
import com.skeet.skeethub.listeners.BlockedCommandsListener;
import com.skeet.skeethub.listeners.PlayerChat;
import com.skeet.skeethub.listeners.PlayerEvents;
import com.skeet.skeethub.listeners.Welcome;
import com.skeet.skeethub.listeners.Armour;
import com.skeet.skeethub.listeners.VanishtoolListener;

import net.milkbowl.vault.chat.Chat;

public class Main extends JavaPlugin implements Listener {
	public static Plugin plugin;
	public String getCommand;
	private Chat chat;
	private static Main instance;

	public Main() {
	}

	public void onEnable() {
		instance = this;

		setupChat();
		getConfig().options().copyDefaults(true);
		saveConfig();
		reloadConfig();

		Bukkit.getPluginManager().registerEvents(new VanishtoolListener(null), this);

		getCommand("message").setExecutor(new PrivateMessageCommand(this));
		getCommand("links").setExecutor(new LinksCommand(this));
		getCommand("gloom").setExecutor(new ConfigReloadCommand(this));

		getServer().getPluginManager().registerEvents(new Welcome(this), this);
		getServer().getPluginManager().registerEvents(new PlayerChat(), this);
		getServer().getPluginManager().registerEvents(new Armour(), this);

		getServer().getPluginManager().registerEvents(new HubBoost(), this);
		getServer().getPluginManager().registerEvents(new HubScoreboard(this), this);
		getServer().getPluginManager().registerEvents(new BlockedCommandsListener(), this);

		getServer().getPluginManager().registerEvents(new PlayerEvents(this), this);
	}

	private boolean setupChat() {
		RegisteredServiceProvider<Chat> chatProvider = getServer().getServicesManager()
				.getRegistration(net.milkbowl.vault.chat.Chat.class);
		if (chatProvider != null) {
			chat = chatProvider.getProvider();
		}

		return (chat != null);
	}

	public static Main getInstance() {
		return instance;
	}
	
	public Chat getChat() {
		return chat;
	}
}
