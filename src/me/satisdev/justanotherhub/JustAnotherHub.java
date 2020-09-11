package me.satisdev.justanotherhub;

import me.satisdev.justanotherapi.JustAnotherAPI;
import me.satisdev.justanotherhub.commands.Fly;
import me.satisdev.justanotherhub.commands.Vanish;
import me.satisdev.justanotherhub.events.JoinQuitListener;
import me.satisdev.justanotherhub.utils.HubScoreboard;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;

public class JustAnotherHub extends JavaPlugin {

	private JustAnotherHub justAnotherHub;
	private HubScoreboard scoreboard;

	private JustAnotherAPI justAnotherApi;

	private int online = 0;

	@Override
	public void onEnable() {
		justAnotherHub = this;

		justAnotherApi = JustAnotherAPI.getAPI();
		scoreboard = new HubScoreboard(getJustAnotherApi().color("&4&l  JustAnotherHub  "), "dummy");

		registerCommands();
		registerEvents();
		registerWorld();
	}

	@Override
	public void onDisable() {
		justAnotherHub = null;
	}

	private void registerCommands() {

		new Fly();
		new Vanish();

	}

	private void registerEvents() {

		new JoinQuitListener();

	}

	private void registerWorld() {
		World world = getServer().getWorld("world");
		world.setTime(6000);
		world.setGameRuleValue("doDaylightCycle", "false");
	}

	public JustAnotherHub getJustAnotherHub() {
		return justAnotherHub;
	}

	public HubScoreboard getScoreboard() {
		return scoreboard;
	}

	public JustAnotherAPI getJustAnotherApi() {
		return justAnotherApi;
	}

	public int getOnline() {
		return online;
	}

	public void setOnline(int online) {
		this.online = online;
	}
}