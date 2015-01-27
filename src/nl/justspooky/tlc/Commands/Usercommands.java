package nl.justspooky.tlc.Commands;

import nl.justspooky.tlc.SettingsManager;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class Usercommands {

    private static String prefix = ChatColor.GRAY + "[" + ChatColor.RED + "ThemeLandCraft" + ChatColor.GRAY + "]" + ChatColor.BLACK + ": " + ChatColor.RESET;
    private static String green = ChatColor.GREEN + "";
    private static String purple = ChatColor.LIGHT_PURPLE + "";


        SettingsManager settings = SettingsManager.getInstance();


    public static void UserHelp (CommandSender s){
     s.sendMessage(ChatColor.RED + "-=-=-=-=-=-=-=-=- " + ChatColor.GOLD + "ThemeLandCraft" + ChatColor.RED + " -=-=-=-=-=-=-=-=-");
        s.sendMessage("");
        s.sendMessage(ChatColor.YELLOW + "Hier onderstaan alle commands die voor jou van belang zijn.");
        s.sendMessage("");
        s.sendMessage(green + "/website    " + purple + "    (Bekijk onze website)");
        s.sendMessage(green + "/resourcepack    " + purple + "    (Download ons resourcepack)");
        s.sendMessage(green + "/author   " + purple + "    (Bekijk wie de maker is van de plugins op deze server)");
        s.sendMessage(green + "/sollicitatie   " + purple + "   (Krijg informatie over de sollicitaties)");
        s.sendMessage(green + "/medewerker   " + purple + "    (Commands voor medewerkers)");
        s.sendMessage(green + "/login    " + purple + "     (Het inlog command voor de server)");
        s.sendMessage(green + "/register    " + purple + "    (Het registreer command van de server)");
    }

    public static void website (CommandSender s){
        SettingsManager settings = SettingsManager.getInstance();
        s.sendMessage(ChatColor.GOLD + "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        s.sendMessage(prefix + ChatColor.YELLOW + "Onze website is: " + ChatColor.GREEN + settings.getConfig().getString("Website"));
        s.sendMessage(ChatColor.GOLD + "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
    }
    public static void resourcepack (CommandSender s){
        SettingsManager settings = SettingsManager.getInstance();
        s.sendMessage(ChatColor.GOLD + "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        s.sendMessage(prefix + ChatColor.YELLOW + "Download het hier: " + ChatColor.GREEN + settings.getConfig().getString("ResourcePack"));
        s.sendMessage(ChatColor.GOLD + "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
    }

}

