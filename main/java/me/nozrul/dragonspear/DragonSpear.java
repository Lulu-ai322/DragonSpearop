package me.nozrul.dragonspear;

import org.bukkit.plugin.java.JavaPlugin;

public class DragonSpear extends JavaPlugin {

    private static DragonSpear instance;

    public void onEnable() {

        instance = this;
        saveDefaultConfig();

        getCommand("ds").setExecutor(new commands.DSCommand());

        getServer().getPluginManager().registerEvents(
                new listener.CombatListener(), this);

        getServer().getPluginManager().registerEvents(
                new listener.KeyListener(), this);

        getServer().getPluginManager().registerEvents(
                new listener.UpgradeListener(), this);
    }

    public static DragonSpear get() {
        return instance;
    }
}
