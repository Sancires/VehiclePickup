package space.sanc.vehiclepickup.listeners;

import net.md_5.bungee.api.ChatMessageType;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Boat;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Vehicle;
import org.bukkit.event.EventHandler;
import org.bukkit.event.vehicle.VehicleExitEvent;
import org.bukkit.inventory.ItemStack;

public class ExitListener extends VehiclePickupListener {

	@EventHandler
	public void onVehicleExit(VehicleExitEvent e) {
		Player p = (Player) e.getExited();
		Vehicle v = e.getVehicle();
		// Boats
		if (
				pl.ALLOW_BOAT_PICKUP &&
						(!p.hasPermission("vehiclepickup.boatbypass")) &&
						(p.hasPermission("vehiclepickup.boatpickup")) &&
						(e.getExited() instanceof Player) &&
						(!v.isDead() && (v.getPassengers().size() == 1)) &&
						((Player) e.getExited()).getInventory().firstEmpty() != 1 &&
						((Player) e.getExited()).getGameMode() != GameMode.CREATIVE &&
						(v.getType() == EntityType.BOAT)) {
			v.remove();
			v.remove();

			// Place correct boat in inventory
			Material mat;
			switch (((Boat)v).getBoatType()) {
				case BIRCH:
					mat = Material.BIRCH_BOAT;
					break;
				case JUNGLE:
					mat = Material.JUNGLE_BOAT;
					break;
				case ACACIA:
					mat = Material.ACACIA_BOAT;
					break;
				case SPRUCE:
					mat = Material.SPRUCE_BOAT;
					break;
				case DARK_OAK:
					mat = Material.DARK_OAK_BOAT;
					break;
				case MANGROVE:
					mat = Material.MANGROVE_BOAT;
					break;
				default:
					mat = Material.OAK_BOAT;
					break;
			}
			((Player) e.getExited()).getInventory().addItem(new ItemStack(mat));

		}
		if (
				pl.ALLOW_MINECART_PICKUP &&
						(!p.hasPermission("vehiclepickup.minecartbypass")) &&
						(p.hasPermission("vehiclepickup.minecartpickup")) &&
						(e.getExited() instanceof Player) &&
						(!v.isDead() && (v.getPassengers().size() == 1)) &&
						((Player) e.getExited()).getInventory().firstEmpty() != 1 &&
						((Player) e.getExited()).getGameMode() != GameMode.CREATIVE &&
						(v.getType() == EntityType.MINECART)) {
			v.remove();
			((Player) e.getExited()).getInventory().addItem(new ItemStack(Material.MINECART, 1));
		}

	}

}
