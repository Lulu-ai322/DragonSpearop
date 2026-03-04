package me.nozrul.dragonspear.manager;

import org.bukkit.entity.Player;
import org.bukkit.Statistic;
import org.bukkit.Material;

public class TaskManager {

    public static boolean isTaskComplete(Player p, String spearType, int level) {

        switch(spearType) {

            case "Fire Spear":
                if (level == 1) return p.getStatistic(Statistic.MOB_KILLS) >= 15;
                if (level == 2) return p.getStatistic(Statistic.USE_ITEM, Material.FLINT_AND_STEEL) >= 20;
                break;

            case "Ice Spear":
                if (level == 1) return p.getStatistic(Statistic.MINE_BLOCK, Material.ICE) >= 30;
                if (level == 2) return p.getStatistic(Statistic.PLAYER_KILLS) >= 5;
                break;

            case "Shadow Spear":
                if (level == 1) return p.getStatistic(Statistic.WALK_ONE_CM) >= 5000;
                if (level == 2) return p.getStatistic(Statistic.MOB_KILLS) >= 25;
                break;

            // Add more spears here if needed
        }

        return false;
    }

    public static String getTaskText(String spearType, int level) {

        switch(spearType) {

            case "Fire Spear":
                if (level == 1) return "Kill 15 mobs";
                if (level == 2) return "Use Flint & Steel 20 times";

            case "Ice Spear":
                if (level == 1) return "Mine 30 Ice blocks";
                if (level == 2) return "Kill 5 players";

            case "Shadow Spear":
                if (level == 1) return "Walk 5000 blocks";
                if (level == 2) return "Kill 25 mobs";
        }

        return "Max Level";
    }
        }
