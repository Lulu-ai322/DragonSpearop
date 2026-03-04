package me.nozrul.dragonspear.commands;

import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import me.nozrul.dragonspear.util.SpearUtil;
import me.nozrul.dragonspear.manager.PlayerDataManager;

import java.util.Arrays;

public class DSCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender,
                             Command command,
                             String label,
                             String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can use this command!");
            return true;
        }

        Player p = (Player) sender;

        // Open Spear GUI
        Inventory gui = Bukkit.createInventory(null, 27, "§cDragon Spear Menu");

        // Add all 13 spears
        for (String type : Arrays.asList(
                "Fire Spear","Ice Spear","Shadow Spear","Storm Spear",
                "Water Spear","Earth Spear","Light Spear","Poison Spear",
                "Blood Spear","Wind Spear","Lava Spear","Frost Spear",
                "Death Spear")) {

            ItemStack spear = SpearUtil.create(type);

            // Add Player Level in Lore
            int level = PlayerDataManager.getLevel(p);
            ItemMeta meta = spear.getItemMeta();
            meta.setLore(Arrays.asList(
                    "§7Level: §a" + level,
                    "§7Click to Upgrade / Task"
            ));
            spear.setItemMeta(meta);

            gui.addItem(spear);
        }

        p.openInventory(gui);

        return true;
    }
          }
