package fr.laubergine.magestick.events;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import fr.laubergine.magestick.Main;

public class MageStickEvents implements Listener{
	
private Main main;
	
	public MageStickEvents(Main main) {
		this.main = main;
	}
	
	@EventHandler
	public void onInteract(PlayerInteractEntityEvent e) {
	    Player player = e.getPlayer();
	    if(!(e.getRightClicked() instanceof Player)) return;
	    if (player.getInventory().getItemInHand().getType() == Material.STICK &&
	            player.getInventory().getItemInHand().getItemMeta().hasDisplayName() &&
	            player.getInventory().getItemInHand().getItemMeta().getDisplayName().equals("§5Mage Stick")){
	        if (e.getRightClicked() != null) { 
	        	
            	new BukkitRunnable() {
                    @Override
                    public void run() {
	        	
                    	Location loc = e.getRightClicked().getLocation();
                    	Player target = (Player) e.getRightClicked();
                    	target.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 1, 0, true, false));
                    	for (int i = 0; i < 20; i++) {
                    		loc.getWorld().playEffect(loc, Effect.HAPPY_VILLAGER, 2);
                    	 }
                    	}
	            	}.runTaskLater(main, 60L);
	        }
	    }
	}
	@EventHandler
	public void onEntityDamageByEntity(EntityDamageByEntityEvent e) {
	    if (e.getDamager() instanceof Player) {
	        Player player = (Player) e.getDamager();
	        ItemStack item = player.getItemInHand();
	        if (item != null && item.getType() == Material.STICK && item.getItemMeta().getDisplayName().equals("§5Mage Stick")) {
	            if (e.getEntity() instanceof LivingEntity) {
	                
	            	new BukkitRunnable() {
	                    @Override
	                    public void run() {
	                      Location location = e.getEntity().getLocation();
	                      location.getWorld().playEffect(location, Effect.FLAME, 2);
	                      
	                      for (int i = 0; i < 40; i++) {
	                        Location strikeLocation = location.clone();
	                        location.getWorld().strikeLightning(strikeLocation);
	                      }
	                    }
	                  }.runTaskLater(main, 20L);
	            }
	        }
	    }
	}

}
