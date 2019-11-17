package com.skeet.skeethub;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import com.skeet.skeethub.commands.BuildCommand;
import com.skeet.skeethub.commands.ConfigReloadCommand;
import com.skeet.skeethub.commands.HelpCommand;
import com.skeet.skeethub.commands.LinksCommand;
import com.skeet.skeethub.commands.PrivateMessageCommand;
import com.skeet.skeethub.file.CustomFile;
import com.skeet.skeethub.file.FileManager;
import com.skeet.skeethub.hub.HubBoost;
import com.skeet.skeethub.hub.HubScoreboard;
import com.skeet.skeethub.listeners.BlockedCommandsListener;
import com.skeet.skeethub.listeners.PlayerChat;
import com.skeet.skeethub.listeners.PlayerEvents;
import com.skeet.skeethub.listeners.VanishtoolListener;
import com.skeet.skeethub.listeners.Welcome;

import net.milkbowl.vault.chat.Chat;

public class Main extends JavaPlugin implements Listener {
	public static Plugin plugin;
	public String getCommand;
	private Chat chat;
	private FileManager fileManager = new FileManager(this);
	private static Main instance;

	public Main() {

	}

	private void registerConfig() {
		CustomFile config = fileManager.getFile("config");
		config.saveDefaultConfig();
	}

	private void registerListeners() {
		Bukkit.getPluginManager().registerEvents(new VanishtoolListener(), this);
		getServer().getPluginManager().registerEvents(new VanishtoolListener(), this);
		getServer().getPluginManager().registerEvents(new Welcome(), this);
		getServer().getPluginManager().registerEvents(new PlayerChat(), this);
		getServer().getPluginManager().registerEvents(new HubBoost(), this);
		getServer().getPluginManager().registerEvents(new HubScoreboard(), this);
		getServer().getPluginManager().registerEvents(new BlockedCommandsListener(), this);
		getServer().getPluginManager().registerEvents(new PlayerEvents(), this);
	}
	

	private void registerCommands() {
		getCommand("message").setExecutor(new PrivateMessageCommand(this));
		getCommand("links").setExecutor(new LinksCommand(this));
		getCommand("hubreload").setExecutor(new ConfigReloadCommand(this));
		getCommand("build").setExecutor(new BuildCommand(this));
		getCommand("help").setExecutor(new HelpCommand(this));
	}
	
	public void onEnable() {
		instance = this;

		setupChat();
		registerConfig();
		registerListeners();
		registerCommands();
	}



	public void onDisable() {
		instance = null;
	}


	private boolean setupChat() {
		RegisteredServiceProvider<Chat> chatProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.chat.Chat.class);
		if (chatProvider != null) {
			chat = chatProvider.getProvider();
		}

		return (chat != null);
	}

	public static Main getInstance() {
		return instance;
	}

	public FileManager getFileManager() {
		return getFileManager();
	}

	public Chat getChat() {
		return chat;
	}
}
