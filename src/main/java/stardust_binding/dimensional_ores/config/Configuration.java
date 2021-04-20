package stardust_binding.dimensional_ores.config;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import stardust_binding.dimensional_ores.DimensionalOres;

@Mod.EventBusSubscriber(modid = DimensionalOres.MODID)
public class Configuration {
    @SubscribeEvent
    public static void onConfigChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event)
    {
        if (event.getModID().equals(DimensionalOres.MODID))
        {
            ConfigManager.sync(DimensionalOres.MODID, Config.Type.INSTANCE);
        }
    }

    @Config(modid = DimensionalOres.MODID, name = DimensionalOres.MODID+"/"+DimensionalOres.MODID)
    public static class Conf {

        @Config.Comment("Default Dimension ID for Aether")
        public static int aether_id = 4;

        @Config.Comment("Default Dimension ID for Atum")
        public static int atum_id = 17;

        @Config.Comment("Default Dimension ID for Misty World")
        public static int mist_id = 69;

        @Config.Comment("Default Dimension ID for The Midnight")
        public static int midnight_id = 33;

        @Config.Comment("Default Dimension ID for Gaia Dimension")
        public static int gaia_id = -30;

        @Config.Comment("Default Dimension ID for Blue Skies Everdawn")
        public static int everdawn_id = 76;

        @Config.Comment("Default Dimension ID for Blue Skies Everbright")
        public static int everbright_id = 77;

        @Config.Comment("Default Dimension ID for The Abyss")
        public static int abyss_id = 76;

        @Config.Comment("Default Dimension ID for The Erebus")
        public static int erebus_id = 66;

        @Config.Comment("Default Dimension ID for The Betweenlands")
        public static int betweenland_id = 20;

        @Config.Comment("Default Dimension ID for Galacticraft Moon")
        public static int galacticraft_moon_id = -28;

        @Config.Comment("Default Dimension ID for Glacidus")
        public static int glacidus_id = 84;
    }
}
