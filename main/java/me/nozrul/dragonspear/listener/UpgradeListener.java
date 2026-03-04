package me.nozrul.dragonspear.listener;

import org.bukkit.event.*;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import me.nozrul.dragonspear.gui.UpgradeGUI;
import me.nozrul.dragonspear.manager.PlayerDataManager;
import me.nozrul.dragonspear.manager.TaskManager;
import me.nozrul.dragonspear.manager.UpgradeEffect;
import me.nozrul.dragonspear.util.SpearUtil;

public class UpgradeListener implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e) {

        if (!(e.getWhoClicked() instanceof Player)) return;
        Player p = (Player) e.getWhoClicked();

        if (!e.getView().getTitle().equals("§cDragon Spear Menu")) return;

        e.setCancelled(true);

        if (e.getCurrentItem() == null || e.getCurrentItem().getType().isAir()) return;

        ItemStack clicked = e.getCurrentItem();
        ItemMeta meta = clicked.getItemMeta();
        if (meta == null) return;

        String spearType = SpearUtil.getType(clicked);

        int level = PlayerDataManager.getLevel(p);

        // Task Check
        if (!TaskManager.isTaskComplete(p, spearType, level)) {
            p.sendMessage("§cTask not complete! Current Task: §f" +
                    TaskManager.getTaskText(spearType, level));
            return;
        }

        // Upgrade Player Spear
        level++;
        PlayerDataManager.save(p, level, 0);

        // Play Upgrade Effect
        UpgradeEffect.play(p);

        // Update GUI
        UpgradeGUI.open(p);

        p.sendMessage("§aYour " + spearType + " upgraded to Level " + level + "!");
    }
            }
