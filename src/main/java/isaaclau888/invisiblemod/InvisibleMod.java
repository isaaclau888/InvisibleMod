package isaaclau888.invisiblemod;

import isaaclau888.invisiblemod.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class InvisibleMod implements ModInitializer {
	public static final String MOD_ID = "invisblemod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
	}
}