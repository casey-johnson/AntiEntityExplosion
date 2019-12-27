package tk.superdark.minecraft.bukkit.AntiMobExplosion.Listeners;

import org.bukkit.block.data.type.Bed;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
import tk.superdark.minecraft.bukkit.AntiMobExplosion.PluginAntiMobExplosion;

public class ListenerEntityExplosions implements Listener
{
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onEntityExplosion(EntityExplodeEvent event)
    {
        Entity e = event.getEntity();
        PluginAntiMobExplosion plugin = PluginAntiMobExplosion.getIntance();

        if (plugin.shouldExplode("Creeper") && e instanceof Creeper)
        {
                event.setCancelled(true);
                return;
        }

        if (plugin.shouldExplode("Wither") && e instanceof Wither)
        {
                event.setCancelled(true);
                return;
        }

        if (plugin.shouldExplode("WitherSkull") && e instanceof WitherSkull)
        {
                event.setCancelled(true);
                return;
        }

        if (plugin.shouldExplode("EnderCrystal") && e instanceof EnderCrystal)
        {
                event.setCancelled(true);
                return;
        }

        if (plugin.shouldExplode("TNTPrimed") && e instanceof TNTPrimed)
        {
                event.setCancelled(true);
                return;
        }

        if (plugin.shouldExplode("Bed") && e instanceof Bed)
        {
                event.setCancelled(true);
                return;
        }

        if (plugin.shouldExplode("Fireball") && e instanceof Fireball)
        {
                event.setCancelled(true);
                return;
        }
    }
}
