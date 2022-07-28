package space.sanc.vehiclepickup;

import org.bukkit.plugin.java.JavaPlugin;

public final class VehiclePickupPlugin extends JavaPlugin {

	private static VehiclePickupPlugin pl;
	@Override
	public void onEnable() {
		pl = this;
		this.saveDefaultConfig();
	}

	public static VehiclePickupPlugin getPl() {
		return pl;
	}

	// Config values
	public boolean ALLOW_MINECART_PICKUP = getConfig().getBoolean("vehicles.minecart.allow-pickup");
	public boolean ALLOW_BOAT_PICKUP = getConfig().getBoolean("vehicles.boat.allow-pickup");
}
