package mrthomas20121.dimensional_ores;

import net.minecraftforge.event.AddReloadListenerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(DimensionalOres.MOD_ID)
public class DimensionalOres {

	public static final String MOD_ID = "dimensional_ores";
	public static final Logger LOGGER = LogManager.getLogger();

	public DimensionalOres() {
		ItemRegistry.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
	}
}
