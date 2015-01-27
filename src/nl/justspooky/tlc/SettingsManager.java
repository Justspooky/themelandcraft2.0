package nl.justspooky.tlc;

import java.io.File;
import java.io.IOException;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;

public class SettingsManager {

    private SettingsManager() { }
    static SettingsManager instance = new SettingsManager();
    public static SettingsManager getInstance() {
        return instance;
    }
    Plugin p;
    FileConfiguration config;
    File cfile;
    FileConfiguration license;
    File lfile;

    public void setup(Plugin p) {
        cfile = new File(p.getDataFolder(), "config.yml");
        config = p.getConfig();
        config.options().copyDefaults(true);
        saveConfig();
        if (!p.getDataFolder().exists()) {
            p.getDataFolder().mkdir();
        }
// license file
        lfile = new File(p.getDataFolder(), "license.yml");
        if (!lfile.exists()) {
            try {
                lfile.createNewFile();
            }
            catch (IOException e) {
                Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not create license.yml !");
            }
        }
        license = YamlConfiguration.loadConfiguration(lfile);
    }
    // Main Config
    public FileConfiguration getConfig() {
        return config;
    }
    public void saveConfig() {
        try {
            config.save(cfile);
        }
        catch (IOException e) {
            Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not save config.yml!");
        }
    }
    public void reloadConfig() {
        config = YamlConfiguration.loadConfiguration(cfile);
    }
    public PluginDescriptionFile getDesc() {
        return p.getDescription();
    }

    // License file

    public FileConfiguration getLicense() {
        return license;
    }
    public void saveLicense() {
        try {
            license.save(lfile);
        }
        catch (IOException e) {
            Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not save license.yml!");
        }
    }
    public void reloadLicense() {
        license = YamlConfiguration.loadConfiguration(lfile);
    }
}
