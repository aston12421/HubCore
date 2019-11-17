package com.skeet.skeethub.hub;

import com.skeet.skeethub.Main;

public class Utils {
	
	public static String prefix = (Main.getInstance().getConfig().getString("hub.prefix") + " ");

	public static String noperm = Main.getInstance().getConfig().getString("hub.nopermission");
	
	public static String unknown = Main.getInstance().getConfig().getString("hub.unknowncomamnd");
	
	public static String theme = Main.getInstance().getConfig().getString("hub.theme");
	

	public static String welcome_servername = Main.getInstance().getConfig().getString("welcome.servername");
	
	public static String welcome_message = Main.getInstance().getConfig().getString("welcome.message");
	
	
	public static String scoreboard_title = Main.getInstance().getConfig().getString("scoreboard.title");
	
	public static String scoreboard_theme = Main.getInstance().getConfig().getString("scoreboard.theme");
	
	public static String scoreboard_serverip = Main.getInstance().getConfig().getString("scoreboard.serverip");
	

}
