package me.nozrul.dragonspear.util;

import org.bukkit.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;
import java.util.*;

public class SpearUtil {

    private static final List<String> SPEARS = Arrays.asList(
            "Fire Spear","Ice Spear","Shadow Spear",
            "Storm Spear","Water Spear","Earth Spear",
            "Light Spear","Poison Spear","Blood Spear",
            "Wind Spear","Lava Spear","Frost Spear",
            "Death Spear"
    );

    public static boolean isSpear(ItemStack item) {
        if (item == null || !item.hasItemMeta()) return false;
        if (!item.getItemMeta().hasDisplayName()) return false;
        return SPEARS.contains(
                ChatColor.stripColor(
                        item.getItemMeta().getDisplayName()));
    }

    public static String getType(ItemStack item) {
        return ChatColor.stripColor(
                item.getItemMeta().getDisplayName());
    }

    public static ItemStack create(String type) {

        ItemStack spear = new ItemStack(Material.TRIDENT);
        ItemMeta meta = spear.getItemMeta();

        meta.setDisplayName("§c" + type);
        meta.setLore(Arrays.asList(
                "§7Level: 1",
                "§7XP: 0"
        ));

        spear.setItemMeta(meta);
        return spear;
    }
}
