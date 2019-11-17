package com.skeet.skeethub.hub;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import com.skeet.skeethub.Main;

import net.milkbowl.vault.chat.Chat;

public class HubScoreboard implements Listener {
	
	  private static Main plugin;
	  
	  public HubScoreboard(Main pl) {
		  this.plugin = pl;
	  }

	public static ArrayList<Player> online = new ArrayList<Player>();

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		online.add(e.getPlayer());
		for (Player online : Bukkit.getOnlinePlayers()) {
			createScoreboard(online);
		}
	}

	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent e) {
		online.remove(e.getPlayer());
		for (Player online1 : Bukkit.getOnlinePlayers()) {
			createScoreboard(online1);
		}
	}

	public static void createScoreboard(Player player) {
		int online_int = online.size();
		Chat chat = Main.getInstance().getChat();
		Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
		Objective o = board.registerNewObjective("Skeet Network", "dummy");
		o.setDisplayName(ChatColor.translateAlternateColorCodes('&', Utils.scoreboardtitle));
		o.setDisplaySlot(DisplaySlot.SIDEBAR);
		Team test = board.registerNewTeam("test");
		test.setPrefix(ChatColor.translateAlternateColorCodes('&', "&7&m--------"));
		test.setSuffix("----------------");

		Team test1 = board.registerNewTeam("test1");
		test1.setPrefix(ChatColor.translateAlternateColorCodes('&', "&7&m--------"));
		test1.setSuffix("----------------");
		Team serverip = board.registerNewTeam("serverip");
		serverip.setPrefix(ChatColor.translateAlternateColorCodes('&', Utils.scoreboardip));
		Score spacer = o.getScore(ChatColor.translateAlternateColorCodes('&', "&r&7&m"));
		Score spacer3 = o.getScore(ChatColor.translateAlternateColorCodes('&', "&7&m"));
		Score rankt = o.getScore(ChatColor.translateAlternateColorCodes('&', Utils.scoreboardtheme + "Rank"));
		Score rank = o.getScore(ChatColor.translateAlternateColorCodes('&', "&f" + chat.getPlayerSuffix(player)));
		Score onlinet = o.getScore(ChatColor.translateAlternateColorCodes('&', Utils.scoreboardtheme + "Online"));
		Score online = o.getScore(
				ChatColor.translateAlternateColorCodes('&', "" + online_int + " / " + Bukkit.getMaxPlayers()));
		Score spacer1 = o.getScore(ChatColor.translateAlternateColorCodes('&', " "));
		Score spacer2 = o.getScore(ChatColor.translateAlternateColorCodes('&', "  "));
		Score ip = o.getScore(ChatColor.translateAlternateColorCodes('&', ""));
		spacer.setScore(8);
		rankt.setScore(7);
		rank.setScore(6);
		spacer2.setScore(5);
		onlinet.setScore(4);
		online.setScore(3);
		spacer1.setScore(2);
		ip.setScore(1);
		spacer3.setScore(0);
		test.addEntry(spacer.getEntry());
		test1.addEntry(spacer3.getEntry());
		serverip.addEntry(ip.getEntry());

		player.setScoreboard(board);
	}
}
