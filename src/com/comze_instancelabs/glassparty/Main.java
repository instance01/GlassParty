package com.comze_instancelabs.glassparty;

import java.util.Random;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

	Random r = new Random();
	
	@Override
    public void onEnable(){
		getServer().getPluginManager().registerEvents(this, this);
		
	}
	//player makes a golden path
    @EventHandler
    public void onmove(PlayerMoveEvent event){ 
    	//get the block the player has moved from x, y and z
        int x = event.getFrom().getBlockX();
        int fromy = event.getFrom().getBlockY();
        // lowers y to the block the player is standing on
        int y = fromy - 1;
        int z = event.getFrom().getBlockZ();
        //set the location of the block to "loc"
        Location loc = new Location(event.getFrom().getWorld(), x, y, z);
        //if the player isn't in the air ( is empty) and isn't a liquid (is liquid) the block below the player        //is changed to  a gold block
        if (!loc.getBlock().isEmpty() && !loc.getBlock().isLiquid() && loc.getBlock().getType() == Material.STAINED_GLASS){
        	Location loc_ = new Location(event.getFrom().getWorld(), x + 1, y, z);
        	Location loc_1 = new Location(event.getFrom().getWorld(), x + 1, y, z + 1);
        	Location loc_2 = new Location(event.getFrom().getWorld(), x + 1, y, z - 1);
        	Location loc_3 = new Location(event.getFrom().getWorld(), x - 1, y, z);
        	Location loc_4 = new Location(event.getFrom().getWorld(), x - 1, y, z + 1);
        	Location loc_5 = new Location(event.getFrom().getWorld(), x - 1, y, z - 1);
        	Location loc_6 = new Location(event.getFrom().getWorld(), x, y, z - 1);
        	Location loc_7 = new Location(event.getFrom().getWorld(), x, y, z + 1);
        	
        	loc_.getBlock().setData((byte)0);
        	loc_1.getBlock().setData((byte)0);
        	loc_2.getBlock().setData((byte)0);
        	loc_3.getBlock().setData((byte)0);
        	loc_4.getBlock().setData((byte)0);
        	loc_5.getBlock().setData((byte)0);
        	loc_6.getBlock().setData((byte)0);
        	loc_7.getBlock().setData((byte)0);
        	
        	loc.getBlock().setData((byte)r.nextInt(15));
        	//loc.getBlock().setTypeId(41);
        }
    }
	
}
