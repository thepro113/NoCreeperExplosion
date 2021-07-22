package com.thepro113.creeper;

import org.bukkit.Bukkit;
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
}
	
	@Override
	public void onDisable() {
	System.out.println("Anti Creeper Explosion has been disabled!");
}
	
	@EventHandler
	public void onEntityExplode (final EntityExplodeEvent e) {
		if (e.getEntityType() == EntityType.CREEPER) {
			e.setCancelled(true);
		}
	}
	}
