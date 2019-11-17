package com.skeet.skeethub.file;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;

public class CustomFile {
	private JavaPlugin plugin;
	private String fileName;
	private File file;
	private FileConfiguration fileConfig;

	public CustomFile(JavaPlugin plugin, String fileName) {
		this.plugin = plugin;
		this.fileName = fileName;
	}

	public void reloadConfig() {
		if (file == null) {
			file = new File(plugin.getDataFolder(), fileName + ".yml");
		}

		fileConfig = YamlConfiguration.loadConfiguration(file);

		InputStream defConfigStream = plugin.getResource(fileName + ".yml");
		if (defConfigStream != null) {
			YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(new InputStreamReader(defConfigStream));
			fileConfig.setDefaults(defConfig);
		}
	}

	public FileConfiguration getConfig() {
		if (fileConfig == null) {
			reloadConfig();
		}
		return fileConfig;
	}

	public void saveConfig() {
		if (fileConfig == null || file == null) {
			return;
		}
		try {
			getConfig().save(file);
		} catch (IOException ex) {
			plugin.getLogger().log(Level.SEVERE, "Could not save config to " + file, ex);
		}
	}

	public void saveDefaultConfig() {
		if (file == null) {
			file = new File(plugin.getDataFolder(), fileName + ".yml");
		}
		if (!file.exists()) {
			plugin.saveResource(fileName + ".yml", false);
		}
	}

}