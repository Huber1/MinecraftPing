package de.moritzhuber.minecraftping;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandMinecraftPing implements CommandExecutor {
    @Override
    public boolean onCommand(final CommandSender sender, final Command command, final String label, final String[] args) {
        Config.getInstance().reload();
        sender.sendMessage("MinecraftPing config reloaded");
        return true;
    }
}
