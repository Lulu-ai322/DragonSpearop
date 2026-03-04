package me.nozrul.dragonspear.manager;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class WeaknessManager {

    public static void apply(EntityDamageByEntityEvent e, Player attacker, Player victim, String spearType) {

        double dmg = e.getDamage();

        switch(spearType) {

            case "Fire Spear":
                if (victim.getWorld().hasStorm()) dmg *= 0.6;
                break;

            case "Ice Spear":
                if (victim.getWorld().getEnvironment() == World.Environment.NETHER) dmg *= 0.5;
                break;

            case "Shadow Spear":
                if (victim.getWorld().getTime() < 12300) dmg *= 0.6;
                break;

            case "Storm Spear":
                if (victim.getLocation().getBlockY() < 50) dmg *= 0.7;
                break;

            case "Water Spear":
                if (victim.getWorld().getBiome(victim.getLocation()).toString().contains("DESERT")) dmg *= 0.65;
                break;

            case "Death Spear":
                if (victim.getInventory().contains(Material.TOTEM_OF_UNDYING)) dmg = 1;
                break;

            // Add more weakness logic for other spears
        }

        e.setDamage(dmg);
    }
}
