package com.skeet.skeethub.hub;

import com.skeet.skeethub.Main;

public class Utils {
	
	private static Main plugin;
	
	public static String prefix = plugin.getConfig().getString("hub.sprefix") + " ";
	
	public static String nopermission = plugin.getConfig().getString("hub.nopermission");
	
	public static String unknowncommand = plugin.getConfig().getString("hub.unknowncommand");
	
	public static String scoreboardtitle = plugin.getConfig().getString("scoreboard.title");
	
	public static String scoreboardip = plugin.getConfig().getString("scoreboard.serverip");
	
	public static String scoreboardtheme = plugin.getConfig().getString("scoreboard.theme");
	
	public static String welcomeservername = plugin.getConfig().getString("welcome.servername");
	
	public static String welcomemessage = plugin.getConfig().getString("welcome.message");
	
}
