package nl.justspooky.tlc;

import java.util.logging.Logger;
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
        l.info("Deze Plugin is gemaakt met de GNU V2 Licence");
        l.info("Website: " + getDescription().getWebsite());
        l.info("Version: " + getDescription().getVersion());
        l.info("Author: " + getDescription().getAuthors());
        l.info("-----------------------------------------------------");

        settings.setup(this);
        settings.saveConfig();
}
    @Override
    public void onDisable(){
        l.info("-----------------------------------------------------");
        l.info("Themelandcraft Is Disabled !");
        l.info("Deze Plugin is gemaakt met de GNU V2 Licence");
        l.info("Website: " + getDescription().getWebsite());
        l.info("Version: " + getDescription().getVersion());
        l.info("Author: " + getDescription().getAuthors());
        l.info("-----------------------------------------------------");
    }
}
