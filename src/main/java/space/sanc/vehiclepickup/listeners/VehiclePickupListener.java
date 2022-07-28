package space.sanc.vehiclepickup.listeners;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import space.sanc.vehiclepickup.VehiclePickupPlugin;

public class VehiclePickupListener implements Listener {

	protected VehiclePickupPlugin pl;

	public VehiclePickupListener() {
		this.pl = VehiclePickupPlugin.getPl();
	}

}
