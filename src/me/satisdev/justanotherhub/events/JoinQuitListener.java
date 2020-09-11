package me.satisdev.justanotherhub.events;

import me.satisdev.justanotherapi.JustAnotherAPI;
import me.satisdev.justanotherapi.inventories.Inventories;
import me.satisdev.justanotherapi.inventories.LobbyInventory;
import me.satisdev.justanotherhub.JustAnotherHub;
import me.satisdev.justanotherhub.utils.HubScoreboard;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class JoinQuitListener implements Listener {

	private final JustAnotherHub justAnotherHub = JavaPlugin.getPlugin(JustAnotherHub.class);
	private final HubScoreboard hubScoreboard;
	private final LobbyInventory lobbyInventory;

	public JoinQuitListener() {
		justAnotherHub.getServer().getPluginManager().registerEvents(this, justAnotherHub);
		hubScoreboard = justAnotherHub.getScoreboard();

		JustAnotherAPI justAnotherApi = justAnotherHub.getJustAnotherApi();
		Inventories inventories = justAnotherApi.getInventories();
		lobbyInventory = inventories.getLobbyInventory();
	}

	@EventHandler
	public void PlayerJoinListener(PlayerJoinEvent event) {
		event.setJoinMessage(null);

		Player player = event.getPlayer();

		lobbyInventory.setInventory(player);

		justAnotherHub.setOnline(justAnotherHub.getOnline() + 1);
		hubScoreboard.setSideScoreboard(player);
	}

	@EventHandler
	public void PlayerQuitListener(PlayerQuitEvent event) {
		event.setQuitMessage(null);

		justAnotherHub.setOnline(justAnotherHub.getOnline() - 1);
	}
}