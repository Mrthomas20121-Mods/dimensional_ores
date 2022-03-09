package mrthomas20121.dimensional_ores;

import mrthomas20121.dimensional_ores.api.OreData;
import net.minecraftforge.event.AddReloadListenerEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = DimensionalOres.MOD_ID)
public class CommonEvents {

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void reloads(AddReloadListenerEvent e) {
        e.addListener(OreData.INSTANCE);
    }
}
