package com.skeet.skeethub.file;


import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public class FileManager {
    private JavaPlugin plugin;
    private HashMap<String, CustomFile> fileMap = new HashMap<>();

    public FileManager(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public boolean fileExists(String fileName) { return fileMap.containsKey(fileName); }

    public CustomFile getFile(String fileName) {
        if (!fileExists(fileName)) registerFile(fileName);

        return fileMap.get(fileName);
    }

    public CustomFile registerFile(String fileName) {
        if (fileExists(fileName)) return getFile(fileName);
        CustomFile customFile = new CustomFile(plugin, fileName);

        fileMap.put(fileName, customFile);
        customFile.saveDefaultConfig();

        return customFile;
    }
}