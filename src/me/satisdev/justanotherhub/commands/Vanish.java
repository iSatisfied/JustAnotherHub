package me.satisdev.justanotherhub.commands;

import me.satisdev.justanotherhub.JustAnotherHub;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class Vanish implements CommandExecutor {

	public Vanish() {
		JustAnotherHub justAnotherHub = JavaPlugin.getPlugin(JustAnotherHub.class);
		justAnotherHub.getCommand("vanish").setExecutor(this);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		sender.sendMessage("Vanish works");

		return true;
	}
}