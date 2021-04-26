package stardust_binding.dimensional_ores.config;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.apache.commons.io.FileUtils;
import stardust_binding.dimensional_ores.DimensionalOres;

import java.io.File;
import java.io.IOException;

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

        @Config.Comment("Default Dimension ID for Galacticraft Mars")
        public static int galacticraft_mars_id = -29;

        @Config.Comment("Default Dimension ID for Galacticraft Asteroids")
        public static int galacticraft_asteroids_id = -30;

        @Config.Comment("Default Dimension ID for Galacticraft Venus")
        public static int galacticraft_venus_id = -31;

        @Config.Comment("Default Dimension ID for Glacidus")
        public static int glacidus_id = 84;
    }

    public static void copyConfig(FMLPreInitializationEvent event) {
        File config_dir = event.getModConfigurationDirectory();
        //String[] ores = { "apatite", "ardite", "aluminum", "certus_quartz", "cobalt", "copper", "draconium", "lead", "nickel", "platinum", "silver", "tin", "osmium", "uranium" };
        String[] stones = {
                "holystone",
                "limestone",
                "foggy_stone",
                "umberstone",
                "trenchstone",
                "nightstone",
                "abyss_stone",
                "gaia_stone",
                "turquoise_stone",
                "lunar_stone",
                "moon_rock",
                "mars_stone",
                "venus_stone",
                "asteroids_rock",
                "mercury_stone",
                "triton_stone",
                "titania_stone",
                "jupiter_stone",
                "saturn_stone",
                "neptune_stone",
                "ceres_stone",
                "kepler22b_stone",
                "eris_stone",
                "uranus_stone",
                "europa_stone",
                "io_stone",
                "deimos_stone",
                "phobos_stone",
                "callisto_stone",
                "ganymede_stone",
                "titan_stone",
                "oberon_stone",
                "iapetus_stone",
                "rhea_stone",
                "diona_stone",
                "fronos_stone",
                "chalos_rock",
                "nibiru_rock",
                "altum",
                "atheon",
                "caligro",
                "betweenstone",
                "pitstone",
                "aurorianstone",
                "frozen_antinatic_stone"
        };

        for(String stone: stones) {
            File stone_file = new File(config_dir, DimensionalOres.MODID+"/stone/"+stone+".json");

            boolean result = new File(config_dir, DimensionalOres.MODID+"/stone").mkdir();
            String ore_file = "assets/dimensional_ores/config/"+stone+".json";
            if(!stone_file.exists())
            {
                try {
                    FileUtils.copyInputStreamToFile(Configuration.class.getClassLoader().getResourceAsStream(ore_file), stone_file);
                }
                catch (IOException e)
                {
                    throw new Error(String.format("Problem Moving %s.json", stone), e);
                }
            }
            else DimensionalOres.getLogger().info("File already exists, Skipping!");
        }
    }
}
