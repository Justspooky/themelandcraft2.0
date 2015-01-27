package nl.justspooky.tlc.rijken;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class Marrerijk implements Listener {

    private static String prefix = ChatColor.GRAY + "[" + ChatColor.GOLD + "ThemeLandCraft" + ChatColor.GRAY + "]" + ChatColor.BLACK + ": " + ChatColor.RESET;
    private static String tpmsg = prefix + ChatColor.AQUA + "Je bent geteleporteerd!";


    public static void open (CommandSender s){

        Player p = (Player) s;

        Inventory marr = Bukkit.createInventory(null, 9, ChatColor.YELLOW + "Marrerijk");

        ItemStack none = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 9);
        ItemMeta nonemeta = none.getItemMeta();
        nonemeta.setDisplayName(ChatColor.GREEN + "Nothing here :)");
        none.setItemMeta(nonemeta);

        ItemStack sb = new ItemStack(Material.STAINED_GLASS , 1, (short) 1);
        ItemMeta sbm = sb.getItemMeta();
        sbm.setDisplayName(ChatColor.AQUA + "Sprookjesbos");
        sbm.setLore(Arrays.asList(ChatColor.RED + "Teleport naar het:" , ChatColor.YELLOW + "Sprookjesbos"));
        sb.setItemMeta(sbm);

        ItemStack diorama = new ItemStack(Material.STAINED_GLASS, 1, (short) 2);
        ItemMeta dioramam = diorama.getItemMeta();
        dioramam.setDisplayName(ChatColor.GREEN + "Diorama");
        dioramam.setLore(Arrays.asList(ChatColor.RED + "Teleport naar:" , ChatColor.YELLOW + "Diorama"));
        diorama.setItemMeta(dioramam);

        ItemStack sc = new ItemStack(Material.STAINED_GLASS, 1, (short) 3);
        ItemMeta scm = sc.getItemMeta();
        scm.setDisplayName(ChatColor.GOLD + "Stoomcarrousel");
        scm.setLore(Arrays.asList(ChatColor.RED + "Teleport naar:" , ChatColor.YELLOW + "Stoomcarrousel"));
        sc.setItemMeta(scm);

        ItemStack sm = new ItemStack(Material.STAINED_GLASS, 1, (short) 4);
        ItemMeta smm = sm.getItemMeta();
        smm.setDisplayName(ChatColor.LIGHT_PURPLE + "StoomTrein");
        smm.setLore(Arrays.asList(ChatColor.RED + "Teleport naar:" , ChatColor.YELLOW + "StoomTrein"));
        sm.setItemMeta(smm);

        ItemStack dv = new ItemStack(Material.STAINED_GLASS,1 , (short) 5);
        ItemMeta dvm = dv.getItemMeta();
        dvm.setDisplayName(ChatColor.BLUE + "Droomvlucht");
        dvm.setLore(Arrays.asList(ChatColor.RED + "Teleport naar:" , ChatColor.YELLOW + "Droomvlucht"));
        dv.setItemMeta(dvm);

        ItemStack vv = new ItemStack(Material.STAINED_GLASS, 1, (short) 6);
        ItemMeta vvm = vv.getItemMeta();
        vvm.setDisplayName(ChatColor.DARK_GREEN + "Villa Volta");
        vvm.setLore(Arrays.asList(ChatColor.RED + "Teleport naar:" , ChatColor.YELLOW + "Villa Volta"));
        vv.setItemMeta(vvm);

        ItemStack vvl = new ItemStack(Material.STAINED_GLASS, 1, (short) 7);
        ItemMeta vvlm = vvl.getItemMeta();
        vvlm.setDisplayName(ChatColor.GOLD + "Volk Van Laaf");
        vvlm.setLore(Arrays.asList(ChatColor.RED + "Teleport naar:" , ChatColor.YELLOW + "Volk Van Laaf"));
        vvl.setItemMeta(vvlm);

        marr.setItem(0, none);
        marr.setItem(1, sb);
        marr.setItem(2, diorama);
        marr.setItem(3, sc);
        marr.setItem(4, sm);
        marr.setItem(5, dv);
        marr.setItem(6, vv);
        marr.setItem(7, vvl);
        marr.setItem(8,none);



    }

    @EventHandler
    public void onInventoryClick (InventoryClickEvent e) {
        ItemStack is = e.getCurrentItem();
        Player p = (Player) e.getWhoClicked();

        if (!ChatColor.stripColor(e.getInventory().getName()).equalsIgnoreCase("Marrerijk")) return;
        e.setCancelled(true);

        if (e.getCurrentItem() == null || e.getCurrentItem().getType() == Material.AIR || !e.getCurrentItem().hasItemMeta()) {
            p.closeInventory();
            return;
        }

        if (is == null || is.getType() == Material.AIR){
            return;
        }
        if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GREEN + "Nothing here :)")){
            p.closeInventory();
        }
        if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Sprookjesbos")){
            p.performCommand("warp sb");
            p.sendMessage(tpmsg);
            p.closeInventory();
        }
        if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "diorama")){
           p.performCommand("warp diorama");
            p.sendMessage(tpmsg);
            p.closeInventory();
        }
        if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Stoomcarrousel")){
            p.performCommand("warp sc");
            p.sendMessage(tpmsg);
            p.closeInventory();
        }
        if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Stoomtrein")){
            p.performCommand("warp sm");
            p.sendMessage(tpmsg);
            p.closeInventory();
        }
        if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Droomvlucht")){
            p.performCommand("warp dv");
            p.sendMessage(tpmsg);
            p.closeInventory();
        }
        if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Villa Volta")){
            p.performCommand("warp vv");
            p.sendMessage(tpmsg);
            p.closeInventory();
        }
        if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "volk van laaf")){
            p.performCommand("warp vvl");
            p.sendMessage(tpmsg);
            p.closeInventory();
        }

    }

}
