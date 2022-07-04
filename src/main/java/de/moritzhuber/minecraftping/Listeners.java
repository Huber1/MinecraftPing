package de.moritzhuber.minecraftping;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Listeners implements Listener {
    private final Map<UUID, Long> lastTimeSneaked = new HashMap<>();
    private final JavaPlugin plugin;
    private final Config config;

    public Listeners(JavaPlugin plugin) {
        this.plugin = plugin;
        this.config = Config.getInstance();
    }

    @EventHandler
    public void onSneak(PlayerToggleSneakEvent event) {
        ping(event);
    }

    private void ping(PlayerToggleSneakEvent event) {
        Player player = event.getPlayer();
        // prevents from counting double (counts only sneakDown)
        if (player.isSneaking()) return;
        final long time = new Date().getTime();
        final long delta = time - lastTimeSneaked.getOrDefault(player.getUniqueId(), 0L);
        lastTimeSneaked.put(player.getUniqueId(), time);
        if (delta < config.getInt("time-to-trigger")) {
            lastTimeSneaked.remove(player.getUniqueId());

            final Location block = player.getTargetBlock(null, 300).getLocation();
            final Location centered = new Location(block.getWorld(), block.getX() + 0.5, block.getY(), block.getZ() + 0.5);

            int runTime = config.getInt("time-show-beam");
            final int numberOfParticles = config.getInt("number-of-particles");

            new BukkitRunnable() {
                private int runs = 0;

                @Override
                public void run() {
                    player.getWorld().spawnParticle(Particle.GLOW_SQUID_INK, centered, numberOfParticles, 0.1, 100, 0.1, 0d, null, true);

                    runs++;
                    if (runs >= runTime * 20) cancel();
                }
            }.runTaskTimer(this.plugin, 0L, 1L);
        }
    }
}
