package com.comze_instancelabs.glassparty;

import java.util.HashMap;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

	HashMap<Location, Byte> toremove = new HashMap<Location, Byte>();
	
	Random r = new Random();
	
	@Override
    public void onEnable(){
		getServer().getPluginManager().registerEvents(this, this);
		
		// reset timer
		Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable(){
			@Override
			public void run() {
				for(Location l : toremove.keySet()){
					l.getWorld().getBlockAt(l).setData(toremove.get(l));
				}
				toremove.clear();
			}
		}, 100, 100); // 5 seconds
	}

    @EventHandler
    public void onmove(PlayerMoveEvent event){ 
        int x = event.getFrom().getBlockX();
        int y = event.getFrom().getBlockY() - 1;
        int z = event.getFrom().getBlockZ();
        Location loc = new Location(event.getFrom().getWorld(), x, y, z);
        if (loc.getBlock().getType() == Material.STAINED_GLASS){
        	if(!toremove.containsKey(loc)){
        		toremove.put(loc, loc.getBlock().getData());
        	}
        	loc.getBlock().setData((byte)r.nextInt(15));
        }
    }
}
