package me.nozrul.dragonspear.manager;

import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import me.nozrul.dragonspear.DragonSpear;

import java.util.HashMap;

public class CooldownManager {

    private static final HashMap<Player, BossBar> bars = new HashMap<>();

    public static void start(Player p, int seconds, String ability) {

        if (bars.containsKey(p)) bars.get(p).removeAll();

        BossBar bar = Bukkit.createBossBar("§c" + ability + " Cooldown",
                BarColor.RED, BarStyle.SEGMENTED_10);
        bar.addPlayer(p);
        bar.setProgress(1.0);
        bars.put(p, bar);

        new BukkitRunnable() {
            double time = seconds * 20;
            double max = time;
            @Override
            public void run() {
                if (time <= 0) {
                    bar.removeAll();
                    bars.remove(p);
                    cancel();
                    return;
                }
                bar.setProgress(time / max);
                time--;
            }
        }.runTaskTimer(DragonSpear.get(), 0L, 1L);
    }
                             }
