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

        @Config.Comment("Should the mod add Furnace Recipes for the ores?")
        public static boolean generateFurnaceRecipes = true;

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

        @Config.Comment("Default Dimension ID for The Abyss")
        public static int aurorian_id = 424;

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
		
		@Config.Comment("Default Dimension ID for Moreplanets Chalos")
		public static int chalos_id=-2543

		@Config.Comment("Default Dimension ID for Moreplanets Diona")
		public static int diona_id=-2542

		@Config.Comment("Default Dimension ID for Moreplanets Fronos")
		public static int fronos_id=-2545

		@Config.Comment("Default Dimension ID for Moreplanets Koentus")
		public static int koentus_id=-2642

		@Config.Comment("Default Dimension ID for Moreplanets Nibiru")
		public static int nibiru_id=-2544
		
		@Config.Comment("Default Dimension ID for Extraplanets Callisto")
		public static int callisto_id=-1505

		@Config.Comment("Default Dimension ID for Extraplanets Ceres")
		public static int ceres_id=-20

		@Config.Comment("Default Dimension ID for Extraplanets Deimos")
		public static int deimos_id=-1503

		@Config.Comment("Default Dimension ID for Extraplanets Eris")
		public static int eris_id=-21

		@Config.Comment("Default Dimension ID for Extraplanets Europa")
		public static int europa_id=-1501

		@Config.Comment("Default Dimension ID for Extraplanets Ganymede")
		public static int ganymede_id=-1506

		@Config.Comment("Default Dimension ID for Extraplanets Iapetus")
		public static int iapetus_id=-1511

		@Config.Comment("Default Dimension ID for Extraplanets Io")
		public static int io_id=-1500

		@Config.Comment("Default Dimension ID for Extraplanets Jupiter")
		public static int jupiter_id=-15

		@Config.Comment("Default Dimension ID for Extraplanets Kepler")
		public static int kepler_id=-22

		@Config.Comment("Default Dimension ID for Extraplanets Mercury")
		public static int mercury_id=-13

		@Config.Comment("Default Dimension ID for Extraplanets Neptune")
		public static int neptune_id=-18

		@Config.Comment("Default Dimension ID for Extraplanets Oberon")
		public static int oberon_id=-1509

		@Config.Comment("Default Dimension ID for Extraplanets Phobos")
		public static int phobos_id=-1502

		@Config.Comment("Default Dimension ID for Extraplanets Pluto")
		public static int pluto_id=-19

		@Config.Comment("Default Dimension ID for Extraplanets Rhea")
		public static int rhea_id=-1507

		@Config.Comment("Default Dimension ID for Extraplanets Saturn")
		public static int saturn_id=-16

		@Config.Comment("Default Dimension ID for Extraplanets Titan")
		public static int titan_id=-1508

		@Config.Comment("Default Dimension ID for Extraplanets Titania")
		public static int titania_id=-1510

		@Config.Comment("Default Dimension ID for Extraplanets Triton")
		public static int triton_id=-1504

		@Config.Comment("Default Dimension ID for Extraplanets Uranus")
		public static int uranus_id=-17


        @Config.Comment("Default Dimension ID for Glacidus")
        public static int glacidus_id = 84;
    }
}
