package nl.justspooky.tlc;

        import nl.justspooky.tlc.Commands.Usercommands;
        import org.bukkit.Bukkit;
        import org.bukkit.ChatColor;
        import org.bukkit.Material;
        import org.bukkit.command.CommandSender;
        import org.bukkit.entity.Player;
        import org.bukkit.event.Listener;
        import org.bukkit.event.EventHandler;
        import org.bukkit.event.inventory.InventoryClickEvent;
        import org.bukkit.inventory.Inventory;
        import org.bukkit.inventory.ItemStack;
        import org.bukkit.inventory.meta.ItemMeta;

public class Mainmenu implements Listener {

    public static void Main(CommandSender sender) {

        Inventory main = Bukkit.createInventory(null, 9, ChatColor.DARK_RED + "ThemeLandCraft Menu");

        ItemStack none = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 9);
        ItemMeta nonemeta = none.getItemMeta();
        nonemeta.setDisplayName(ChatColor.GREEN + "Nothing here :)");
        none.setItemMeta(nonemeta);

        ItemStack web = new ItemStack(Material.PAPER);
        ItemMeta webmeta = web.getItemMeta();
        webmeta.setDisplayName(ChatColor.RED + "Bekijk onze Website");
        web.setItemMeta(webmeta);

        ItemStack warp = new ItemStack(Material.COMPASS);
        ItemMeta warpmeta = warp.getItemMeta();
        warpmeta.setDisplayName(ChatColor.YELLOW + "Open het Warp menu");
        warp.setItemMeta(warpmeta);

        ItemStack close = new ItemStack(Material.IRON_DOOR);
        ItemMeta closemeta = close.getItemMeta();
        closemeta.setDisplayName(ChatColor.AQUA + "Sluit dit menu");
        close.setItemMeta(closemeta);

        main.setItem(0, web);
        main.setItem(1, none);
        main.setItem(2, none);
        main.setItem(3, none);
        main.setItem(4, warp);
        main.setItem(5, none);
        main.setItem(6, none);
        main.setItem(7, none);
        main.setItem(8, close);

        Player p = (Player) sender;

        p.openInventory(main);
    }

    @EventHandler
    public void onInventoryClick (InventoryClickEvent e) {

        if (!ChatColor.stripColor(e.getInventory().getName()).equalsIgnoreCase("ThemeLandCraft Menu")) return;
        Player player = (Player) e.getWhoClicked();
        e.setCancelled(true);

        if (e.getCurrentItem() == null || e.getCurrentItem().getType() == Material.AIR || !e.getCurrentItem().hasItemMeta()) {
            player.closeInventory();
            return;
        }

        switch (e.getCurrentItem().getType()) {
            case STAINED_GLASS_PANE:
                player.closeInventory();
                break;

            case PAPER:
                Usercommands.website(player);
                player.closeInventory();
                break;

            case COMPASS:
                Rijkenmenu.rijken(player);
                break;

            case IRON_DOOR:
                player.closeInventory();
                break;
            default:
                break;
        }

    }
}
