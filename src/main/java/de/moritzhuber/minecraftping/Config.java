package de.moritzhuber.minecraftping;

import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class Config {
    private static Config INSTANCE;
    private YamlConfiguration config;

    public Config() {
        reload();
    }

    public static Config getInstance() {
        if (INSTANCE == null) INSTANCE = new Config();
        return INSTANCE;
    }

    public void reload() {
        config = YamlConfiguration.loadConfiguration(new File("plugins/MinecraftPing/config.yml"));
    }

    public boolean getBoolean(String key) {
        return config.getBoolean(key);
    }

    public int getInt(String key) {
        return config.getInt(key);
    }

    public String getString(String key) {
        return config.getString(key);
    }
}
