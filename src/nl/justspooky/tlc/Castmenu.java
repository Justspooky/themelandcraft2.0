package nl.justspooky.tlc;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class Castmenu implements Listener {


    public static void reclame (CommandSender s){
        s.sendMessage(ChatColor.GOLD + "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        s.sendMessage(ChatColor.AQUA + "Deze Plugin is gemaakt door: Kevin Wilmsen");
        s.sendMessage(ChatColor.AQUA + "Website: http://www.kevindevelopment.nl");
        s.sendMessage(ChatColor.AQUA + "Prive Website: http://www.kevinwilmsen.nl");
        s.sendMessage(ChatColor.AQUA + "Twitter: @Justgamers2");
        s.sendMessage(ChatColor.AQUA + "Skype: kevin.wilmsen4");
        s.sendMessage(ChatColor.AQUA + "E-mail: me@kevinwilmsen.nl");
        s.sendMessage(ChatColor.GOLD + "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
    }


    @EventHandler
    public void onplayerquit(PlayerQuitEvent e){
        Player p = e.getPlayer();
        p.getInventory().clear();
    }


    @EventHandler
    public void onplayerjoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();

        ItemStack chest = new ItemStack (Material.CHEST);
        ItemMeta chestmeta = chest.getItemMeta();
        chestmeta.setDisplayName(ChatColor.WHITE + "[" + ChatColor.BLUE + "KledingKast" + ChatColor.WHITE + "]");
        chestmeta.setLore(Arrays.asList(ChatColor.RED + "Open de kleding kast", ChatColor.YELLOW + "En kies een outfit"));
        chest.setItemMeta(chestmeta);

        ItemStack menu = new ItemStack (Material.NETHER_STAR);
        ItemMeta menumeta = menu.getItemMeta();
        menumeta.setDisplayName(ChatColor.WHITE + "[" + ChatColor.GOLD + "ThemeLandCraft Menu" + ChatColor.WHITE + "]");
        menumeta.setLore(Arrays.asList(ChatColor.RED + "Open het Menu", ChatColor.YELLOW + "Voor meer info"));
        menumeta.addEnchant(Enchantment.ARROW_INFINITE, 10, true);
        menu.setItemMeta(menumeta);

        ItemStack reclame = new ItemStack (Material.PAPER);
        ItemMeta recmeta = menu.getItemMeta();
        recmeta.setDisplayName(ChatColor.WHITE + "[" + ChatColor.RED + "Meer info" + ChatColor.WHITE + "]");
        reclame.setItemMeta(recmeta);

        p.getInventory().setItem(0, chest);
        p.getInventory().setItem(4, menu);
        p.getInventory().setItem(8, reclame);
        p.getInventory().setHeldItemSlot(4);

    }

    @EventHandler
    public void onplayerrespawn(PlayerRespawnEvent e) {
        Player p = e.getPlayer();

        ItemStack chest = new ItemStack (Material.CHEST);
        ItemMeta chestmeta = chest.getItemMeta();
        chestmeta.setDisplayName(ChatColor.WHITE + "[" + ChatColor.BLUE + "KledingKast" + ChatColor.WHITE + "]");
        chestmeta.setLore(Arrays.asList(ChatColor.RED + "Open de kleding kast", ChatColor.YELLOW + "En kies een outfit"));
        chest.setItemMeta(chestmeta);

        ItemStack menu = new ItemStack (Material.NETHER_STAR);
        ItemMeta menumeta = menu.getItemMeta();
        menumeta.setDisplayName(ChatColor.WHITE + "[" + ChatColor.GOLD + "ThemeLandCraft Menu" + ChatColor.WHITE + "]");
        menumeta.setLore(Arrays.asList(ChatColor.RED + "Open het Menu", ChatColor.YELLOW + "Voor meer info"));
        menumeta.addEnchant(Enchantment.ARROW_INFINITE, 10, true);
        menu.setItemMeta(menumeta);

        ItemStack reclame = new ItemStack (Material.PAPER);
        ItemMeta recmeta = menu.getItemMeta();
        recmeta.setDisplayName(ChatColor.WHITE + "[" + ChatColor.RED + "Meer info" + ChatColor.WHITE + "]");
        reclame.setItemMeta(recmeta);

        p.getInventory().setItem(0, chest);
        p.getInventory().setItem(4, menu);
        p.getInventory().setItem(8, reclame);
        p.getInventory().setHeldItemSlot(4);

    }

    @EventHandler
    public void onplayerinteract(PlayerInteractEvent e){
        ItemStack is = e.getItem();
        Action a = e.getAction();

        if (a == Action.PHYSICAL || is == null || is.getType() == Material.AIR){
            return;
        }
        if(is.getType() == Material.CHEST){
            e.getPlayer().sendMessage("Dit word de kledingkast");
        }
        if(is.getType() == Material.NETHER_STAR){
            Mainmenu.Main(e.getPlayer());
        }
        if(is.getType() == Material.PAPER){
           reclame(e.getPlayer());
        }
    }
}

