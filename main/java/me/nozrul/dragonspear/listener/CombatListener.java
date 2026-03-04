package me.nozrul.dragonspear.listener;

import org.bukkit.event.*;
import org.bukkit.event.entity.*;
import org.bukkit.entity.Player;
import me.nozrul.dragonspear.util.SpearUtil;
import me.nozrul.dragonspear.manager.WeaknessManager;

public class CombatListener implements Listener {

    @EventHandler
    public void onHit(EntityDamageByEntityEvent e) {

        if (!(e.getDamager() instanceof Player)) return;
        if (!(e.getEntity() instanceof Player)) return;

        Player attacker = (Player) e.getDamager();
        Player victim = (Player) e.getEntity();

        if (!SpearUtil.isSpear(
                attacker.getInventory().getItemInMainHand()))
            return;

        String type = SpearUtil.getType(
                attacker.getInventory().getItemInMainHand());

        WeaknessManager.apply(e, attacker, victim, type);
    }
}
