package com.skeet.skeethub;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import com.skeet.skeethub.commands.BuildCommand;
import com.skeet.skeethub.commands.ConfigReloadCommand;
import com.skeet.skeethub.commands.LinksCommand;
import com.skeet.skeethub.commands.PrivateMessageCommand;
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
	private static Main instance;

	public Main() {
	}

	public static String prefix = (plugin.getConfig().getString("hub.sprefix") + " ");

	public static String nopermission = plugin.getConfig().getString("hub.nopermission");

	public static String unknowncommand = plugin.getConfig().getString("hub.unknowncommand");

	public static String scoreboardtitle = plugin.getConfig().getString("scoreboard.title");

	public static String scoreboardip = plugin.getConfig().getString("scoreboard.serverip");

	public static String scoreboardtheme = plugin.getConfig().getString("scoreboard.theme");

	public static String welcomeservername = plugin.getConfig().getString("welcome.servername");

	public static String welcomemessage = plugin.getConfig().getString("welcome.message");

	public void onEnable() {

		instance = this;

		setupChat();
		getConfig().options().copyDefaults(true);
		saveConfig();
		reloadConfig();

		Bukkit.getPluginManager().registerEvents(new VanishtoolListener(), this);

		getCommand("message").setExecutor(new PrivateMessageCommand(this));

		getCommand("links").setExecutor(new LinksCommand(this));

		getCommand("hub").setExecutor(new ConfigReloadCommand(this));

		getCommand("build").setExecutor(new BuildCommand(this));

		getServer().getPluginManager().registerEvents(new Welcome(), this);

		getServer().getPluginManager().registerEvents(new PlayerChat(), this);

		// getServer().getPluginManager().registerEvents(new Armour(), this);

		getServer().getPluginManager().registerEvents(new HubBoost(), this);

		getServer().getPluginManager().registerEvents(new HubScoreboard(), this);

		getServer().getPluginManager().registerEvents(new BlockedCommandsListener(), this);

		getServer().getPluginManager().registerEvents(new PlayerEvents(), this);
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
