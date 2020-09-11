package me.satisdev.justanotherhub.commands;

import me.satisdev.justanotherapi.JustAnotherAPI;
import me.satisdev.justanotherapi.permissions.PermissionManager;
import me.satisdev.justanotherapi.utils.ServerMessages;
import me.satisdev.justanotherhub.JustAnotherHub;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Fly implements CommandExecutor {

	private final JustAnotherAPI justAnotherApi;
	private final PermissionManager permissionManager;
	private final ServerMessages serverMessages;

	public Fly() {
		JustAnotherHub justAnotherHub = JavaPlugin.getPlugin(JustAnotherHub.class);
		justAnotherHub.getCommand("fly").setExecutor(this);

		justAnotherApi = justAnotherHub.getJustAnotherApi();
		permissionManager = justAnotherApi.getPermissionManager();
		serverMessages = justAnotherApi.getServerMessages();
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(justAnotherApi.color("&cYou must be a player to use this command."));
		}

		assert sender instanceof Player;
		Player player = (Player) sender;

		if (!permissionManager.hasPerms(player, "justanother.donor")) {
			justAnotherApi.sendLogMessage(player, serverMessages.getServerName() + serverMessages.getNoPerms());
			return true;
		}


		player.setAllowFlight(true);
		player.setFlying(true);

		return true;
	}
}