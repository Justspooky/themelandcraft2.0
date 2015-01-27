package nl.justspooky.tlc;

import java.util.logging.Logger;

import nl.justspooky.tlc.Commands.Usercommands;
import nl.justspooky.tlc.rijken.Marrerijk;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.PluginManager;

public class Startup extends JavaPlugin {
    public final Logger l = Logger.getLogger("Minecraft");

    SettingsManager settings = SettingsManager.getInstance();

    @Override
    public void onEnable(){
        PluginManager manager = this.getServer().getPluginManager();
        l.info("-----------------------------------------------------");
        l.info("Themelandcraft Is Enabled !");
        l.info("Deze Plugin is gemaakt onder de GNU V3 Licence");
        l.info("Copyright © 2015  Kevin Wilmsen");
        l.info("Website: " + getDescription().getWebsite());
        l.info("Version: " + getDescription().getVersion());
        l.info("Author: " + getDescription().getAuthors());
        l.info("-----------------------------------------------------");

        settings.setup(this);
        settings.saveConfig();
        settings.saveLicense();

        manager.registerEvents(new Castmenu(), this);
        manager.registerEvents(new Mainmenu(), this);
        manager.registerEvents(new Rijkenmenu(), this);
        manager.registerEvents(new Marrerijk(), this);
    }
    @Override
    public void onDisable(){
        l.info("-----------------------------------------------------");
        l.info("Themelandcraft Is Disabled !");
        l.info("Deze Plugin is gemaakt onder de GNU V3 Licence");
        l.info("Copyright © 2015  Kevin Wilmsen");
        l.info("Website: " + getDescription().getWebsite());
        l.info("Version: " + getDescription().getVersion());
        l.info("Author: " + getDescription().getAuthors());
        l.info("-----------------------------------------------------");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

    if (cmd.getName().equalsIgnoreCase("themelandcraft")){
        Usercommands.UserHelp(sender);
        return true;
    }

        if (cmd.getName().equalsIgnoreCase("website")){
            Usercommands.website(sender);
            return true;
        }

        if (cmd.getName().equalsIgnoreCase("resourcepack")){
            Usercommands.resourcepack(sender);
            return true;
        }


    return true;
}

}
