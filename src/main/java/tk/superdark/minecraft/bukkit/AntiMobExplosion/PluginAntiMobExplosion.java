package tk.superdark.minecraft.bukkit.AntiMobExplosion;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import tk.superdark.minecraft.bukkit.AntiMobExplosion.Listeners.ListenerEntityExplosions;

import javax.swing.text.html.parser.Entity;

public class PluginAntiMobExplosion extends JavaPlugin
{

    private static PluginAntiMobExplosion instance_ = null;

    public static  PluginAntiMobExplosion getIntance()
    {
        return instance_;
    }


    @Override
    public void onDisable()
    {
        instance_ = null;
    }

    @Override
    public void onEnable()
    {
        instance_ = this;
        if (this.getConfig() == null) {
            defaultConfig();
        }

        getServer().getPluginManager().registerEvents(new ListenerEntityExplosions(), this);
    }

    /**
     * adds the specified types of explosive entities to the config file as a boolean. Sets defaults if they do not exist.
     */
    private void defaultConfig()
    {

        FileConfiguration config = this.getConfig();
        config.addDefault("Creeper", false);
        config.addDefault("Wither", false);
        config.addDefault("WitherSkull", false);
        config.addDefault("EnderCrystal", false);
        config.addDefault("TNTPrimed", false);
        config.addDefault("Bed", false);
        config.addDefault("Fireball", false);
        config.options().copyDefaults(true);
        saveConfig();

    }

    /**
     *
     * @param EntityName Entity name is the name of the entity that passed an explosion event.
     * @return Returns a boolean based on the config file of the plugin.
     */
    public boolean  shouldExplode(String EntityName)
    {

        return this.getConfig().getBoolean(EntityName);

    }




}
