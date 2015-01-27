package nl.justspooky.tlc;

import nl.justspooky.tlc.rijken.Marrerijk;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class Rijkenmenu implements Listener {

    public static void rijken (CommandSender sender){

        Player p = (Player) sender;

        Inventory rijk = Bukkit.createInventory(null, 9, ChatColor.BLUE + "Selecteer een rijk");

        ItemStack mar = new ItemStack(Material.NAME_TAG);
        ItemMeta marmeta = mar.getItemMeta();
        marmeta.setDisplayName(ChatColor.GREEN + "Marrerijk");
        marmeta.setLore(Arrays.asList(ChatColor.RED + "Kies deze optie voor alle atracties in het:", ChatColor.YELLOW + "Marrerijk", ChatColor.BLUE + "Klik on me!"));
        mar.setItemMeta(marmeta);

        ItemStack ruig = new ItemStack(Material.NAME_TAG);
        ItemMeta ruigmeta = ruig.getItemMeta();
        ruigmeta.setDisplayName(ChatColor.RED + "Ruigrijk");
        ruigmeta.setLore(Arrays.asList(ChatColor.RED + "Kies deze optie voor alle atracties in het:", ChatColor.YELLOW + "Ruigrijk", ChatColor.BLUE + "Klik on me!"));
        ruig.setItemMeta(ruigmeta);

        ItemStack reis = new ItemStack(Material.NAME_TAG);
        ItemMeta reismeta = reis.getItemMeta();
        reismeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Reizenrijk");
        reismeta.setLore(Arrays.asList(ChatColor.RED + "Kies deze optie voor alle atracties in het:", ChatColor.YELLOW + "Reizenrijk", ChatColor.BLUE + "Klik on me!"));
        reis.setItemMeta(reismeta);

        ItemStack ander = new ItemStack(Material.NAME_TAG);
        ItemMeta andermeta = ander.getItemMeta();
        andermeta.setDisplayName(ChatColor.GOLD + "Anderrijk");
        andermeta.setLore(Arrays.asList(ChatColor.RED + "Kies deze optie voor alle atracties in het:", ChatColor.YELLOW + "Anderrijk", ChatColor.BLUE + "Klik on me!"));
        ander.setItemMeta(andermeta);

        rijk.setItem(1, mar);
        rijk.setItem(3, ruig);
        rijk.setItem(5, reis);
        rijk.setItem(7, ander);


        p.openInventory(rijk);

    }


    @EventHandler
    public void onInventoryClick (InventoryClickEvent e) {
        ItemStack is = e.getCurrentItem();
        ItemMeta im = e.getCurrentItem().getItemMeta();
       Player p = (Player) e.getWhoClicked();

        if (!ChatColor.stripColor(e.getInventory().getName()).equalsIgnoreCase("Selecteer een rijk")) return;
        e.setCancelled(true);

        if (e.getCurrentItem() == null || e.getCurrentItem().getType() == Material.AIR || !e.getCurrentItem().hasItemMeta()) {
            p.closeInventory();
            return;
        }

        if (is == null || is.getType() == Material.AIR){
            return;
        }
        if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GREEN + "Marrerijk")){
            Marrerijk.open(p);
        }
        if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "Ruigrijk")){
            p.sendMessage("Dit gaat naar het Ruigrijk");
        }
        if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.LIGHT_PURPLE + "Reizenrijk")){
            p.sendMessage("Dit gaat naar het Reizenrijk");
        }
        if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD + "Anderrijk")){
            p.sendMessage("Dit gaat naar het Anderrijk");
        }

    }

}
