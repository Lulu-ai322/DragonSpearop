package me.nozrul.dragonspear.manager;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import me.nozrul.dragonspear.DragonSpear;

import java.io.File;
import java.io.IOException;

public class PlayerDataManager {

    private static File getFile(Player p) {
        File folder = new File(DragonSpear.get().getDataFolder(), "playerdata");
        if (!folder.exists()) folder.mkdirs();
        return new File(folder, p.getUniqueId() + ".yml");
    }

    public static FileConfiguration getData(Player p) {
        return YamlConfiguration.loadConfiguration(getFile(p));
    }

    public static int getLevel(Player p) {
        return getData(p).getInt("level", 1);
    }

    public static int getXP(Player p) {
        return getData(p).getInt("xp", 0);
    }

    public static void save(Player p, int level, int xp) {
        FileConfiguration data = getData(p);
        data.set("level", level);
        data.set("xp", xp);
        try { data.save(getFile(p)); }
        catch (IOException e) { e.printStackTrace(); }
    }
}
