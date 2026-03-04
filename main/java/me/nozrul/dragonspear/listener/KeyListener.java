package me.nozrul.dragonspear.listener;

import org.bukkit.event.*;
import org.bukkit.event.player.*;
import org.bukkit.entity.Player;
import me.nozrul.dragonspear.manager.PlayerDataManager;
import me.nozrul.dragonspear.util.SpearUtil;
import me.nozrul.dragonspear.gui.UpgradeGUI;

public class KeyListener implements Listener {

    @EventHandler
    public void onSwap(PlayerSwapHandItemsEvent e) {

        Player p = e.getPlayer();

        if (!SpearUtil.isSpear(
                p.getInventory().getItemInMainHand()))
            return;

        e.setCancelled(true);

        p.sendMessage("§6Level: §e" +
                PlayerDataManager.getLevel(p));
    }

    @EventHandler
    public void onDrop(PlayerDropItemEvent e) {

        Player p = e.getPlayer();

        if (!SpearUtil.isSpear(
                p.getInventory().getItemInMainHand()))
            return;

        e.setCancelled(true);
        UpgradeGUI.open(p);
    }
}
