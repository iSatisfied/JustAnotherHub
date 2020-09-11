package me.satisdev.justanotherhub.utils;

import me.satisdev.justanotherapi.JustAnotherAPI;
import me.satisdev.justanotherapi.ranks.RankManager;
import me.satisdev.justanotherapi.utils.SideScoreboard;
import me.satisdev.justanotherhub.JustAnotherHub;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class HubScoreboard extends SideScoreboard {

	private final JustAnotherHub justAnotherHub = JavaPlugin.getPlugin(JustAnotherHub.class);
	private final JustAnotherAPI justAnotherApi;

	private final RankManager rankManager;

	public HubScoreboard(String scoreboardName, String objectiveName) {
		super(scoreboardName, objectiveName);

		justAnotherApi = justAnotherHub.getJustAnotherApi();
		rankManager = justAnotherApi.getRankManager();

	}

	@Override
	public void setSideScoreboard(Player player) {
		setObjectiveDisplays();

		new BukkitRunnable() {

			@Override
			public void run() {

				getObjective().getScore(justAnotherApi.color("&6Online:")).setScore(7);
				getObjective().getScore(justAnotherApi.color("&7" + justAnotherHub.getOnline() + "/" + justAnotherHub.getServer().getMaxPlayers())).setScore(6);
				getObjective().getScore(justAnotherApi.color("&2")).setScore(5);
				getObjective().getScore(justAnotherApi.color("&6Rank:")).setScore(4);
				getObjective().getScore(justAnotherApi.color(rankManager.getPlayerRank(player))).setScore(3);
				getObjective().getScore(justAnotherApi.color("&1")).setScore(2);
				getObjective().getScore(justAnotherApi.color("&fNo Website")).setScore(1);

				player.setScoreboard(getScoreboard());
			}
		}.runTaskAsynchronously(justAnotherHub.getJustAnotherHub());
	}
}
