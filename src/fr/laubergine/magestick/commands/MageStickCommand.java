package fr.laubergine.magestick.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;

import fr.laubergine.magestick.tools.ItemBuilder;


public class MageStickCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		Player player = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("mstick")) {
			if (player.hasPermission("magestick.give")) {
				ItemBuilder MageStick = new ItemBuilder(Material.STICK).setName("§5Mage Stick").setLore("Right Click to §aHeal §5all 3s", "Left Click to §fLightning Bolt").addEnchant(Enchantment.KNOCKBACK, 5);
				player.getInventory().addItem(MageStick.toItemStack());
			}
			else {
				player.sendMessage("§cYou don't have a permission ! Please contact moderator(s) or administrateur(s) ...");
			}
		}
		return false;
	}

}
