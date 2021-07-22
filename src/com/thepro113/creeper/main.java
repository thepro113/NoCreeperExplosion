package com.thepro113.creeper;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin implements Listener {
	
	
	@Override
	public void onEnable() {
		System.out.println("Anti Creeper Explosion has been enabled!");
		Bukkit.getPluginManager().registerEvents(this, this);
        int pluginId = 12156;
        Metrics metrics = new Metrics(this, pluginId);
		new UpdateChecker(this, 94547).getLatestVersion(version-> {
			if(this.getDescription().getVersion().equalsIgnoreCase(version)) {
			System.out.println("Anti Creeper Explosion is up to date!");
			} else {
			System.out.println("Anti Creeper Explosion has an update! Please update it.");
			}});
}
	@Override
	public void onDisable() {
	System.out.println("Anti Creeper Explosion has been disabled!");
}
	
	@EventHandler
	public void onEntityExplode (final EntityExplodeEvent e) {
		if (e.getEntityType() == EntityType.CREEPER) {
			e.setCancelled(true);
			Bukkit.getWorld("world").playSound(e.getEntity().getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 1.0F, 1.0F);
 		}
	}
}