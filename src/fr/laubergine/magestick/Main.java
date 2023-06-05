package fr.laubergine.magestick;

import org.bukkit.plugin.java.JavaPlugin;

import fr.laubergine.magestick.commands.MageStickCommand;
import fr.laubergine.magestick.events.MageStickEvents;

public class Main extends JavaPlugin{

	private static Main main; 
	
	@Override
	public void onEnable() {
		main = this;
		getCommand("mstick").setExecutor(new MageStickCommand());
		getServer().getPluginManager().registerEvents(new MageStickEvents(this), this);
		
	}
	
	public static Main getInstance() {
		return main;
	}
	
	@Override
	public void onDisable() {
	}
}
