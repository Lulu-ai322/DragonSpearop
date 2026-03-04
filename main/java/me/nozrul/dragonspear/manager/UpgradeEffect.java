package me.nozrul.dragonspear.manager;

import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import me.nozrul.dragonspear.DragonSpear;

public class UpgradeEffect {

    public static void play(Player p) {

        p.getWorld().playSound(p.getLocation(), Sound.ENTITY_ENDER_DRAGON_GROWL, 1, 1);

        new BukkitRunnable() {

            double radius = 0;

            @Override
            public void run() {

                if (radius > 3) {
                    cancel();
                    return;
                }

                for (double t = 0; t < Math.PI*2; t += Math.PI/8) {
                    double x = radius * Math.cos(t);
                    double z = radius * Math.sin(t);

                    p.getWorld().spawnParticle(Particle.FLAME, p.getLocation().add(x,1,z), 2);
                }

                radius += 0.3;
            }

        }.runTaskTimer(DragonSpear.get(), 0L, 2L);
    }
}
