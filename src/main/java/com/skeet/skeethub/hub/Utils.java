package com.skeet.skeethub.hub;

import com.skeet.skeethub.Main;

public class Utils {
	
	private static Main plugin;
	
	public static String prefix = plugin.getConfig().getString("prefix");
	
	public static String scoreboardtitle = plugin.getConfig().getString("scoreboardtitle");

}
