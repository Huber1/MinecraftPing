package de.moritzhuber.minecraftping;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class MinecraftPing extends JavaPlugin {

    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new Listeners(this), this);
        Objects.requireNonNull(this.getCommand("minecraftping")).setExecutor(new CommandMinecraftPing());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
