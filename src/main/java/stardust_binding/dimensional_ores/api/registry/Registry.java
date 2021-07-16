package stardust_binding.dimensional_ores.api.registry;

import net.minecraft.block.Block;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;
import stardust_binding.dimensional_ores.DimensionalOres;
import stardust_binding.dimensional_ores.api.type.*;
import stardust_binding.dimensional_ores.config.Configuration;
import stardust_binding.dimensional_ores.config.OreConfig;

@Mod.EventBusSubscriber(modid = DimensionalOres.MODID)
public class Registry {

    @SubscribeEvent
    public static void registerOres(Events.PreEvent<Ore> event) {
        IForgeRegistry<Ore> r = event.getRegistry();

        r.register(new Ore("aluminum"));
        r.register(new Ore("apatite"));
        r.register(new Ore("ardite"));
        r.register(new Ore("certus_quartz"));
        r.register(new Ore("cobalt"));
        r.register(new Ore("copper"));
        r.register(new Ore("draconium"));
        r.register(new Ore("lead"));
        r.register(new Ore("nickel"));
        r.register(new Ore("platinum"));
        r.register(new Ore("silver"));
        r.register(new Ore("tin"));
        r.register(new Ore("tungsten"));
        r.register(new Ore("osmium"));
        r.register(new Ore("uranium"));
        r.register(new Ore("pyrope"));
        r.register(new Ore("coral"));
        r.register(new Ore("sunstone"));
        r.register(new Ore("zircon"));
        r.register(new Ore("jade"));
        r.register(new Ore("chrysoprase"));
        r.register(new Ore("fluorite"));
        r.register(new Ore("kyanite"));
        r.register(new Ore("sodalite"));
        r.register(new Ore("ammolite"));
        r.register(new Ore("kunzite"));
        r.register(new Ore("rose_quartz"));
        r.register(new Ore("tektite"));
        r.register(new Ore("pearl"));
        r.register(new Ore("carnelian"));
        r.register(new Ore("spinel"));
        r.register(new Ore("citrine"));
        r.register(new Ore("jasper"));
        r.register(new Ore("golden_beryl"));
        r.register(new Ore("moldavite"));
        r.register(new Ore("malachite"));
        r.register(new Ore("turquoise"));
        r.register(new Ore("moonstone"));
        r.register(new Ore("blue_topaz"));
        r.register(new Ore("tanzanite"));
        r.register(new Ore("violet_sapphire"));
        r.register(new Ore("lepidolite"));
        r.register(new Ore("ametrine"));
        r.register(new Ore("black_diamond"));
        r.register(new Ore("alexandrite"));
        r.register(new Ore("ruby"));
        r.register(new Ore("garnet"));
        r.register(new Ore("topaz"));
        r.register(new Ore("amber"));
        r.register(new Ore("heliodor"));
        r.register(new Ore("peridot"));
        r.register(new Ore("green_sapphire"));
        r.register(new Ore("indicolite"));
        r.register(new Ore("aquamarine"));
        r.register(new Ore("sapphire"));
        r.register(new Ore("iolite"));
        r.register(new Ore("amethyst"));
        r.register(new Ore("agate"));
        r.register(new Ore("morganite"));
        r.register(new Ore("onyx"));
        r.register(new Ore("opal"));
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void registerBlock(RegistryEvent.Register<Block> event) {
        // create the config if it doesn't exists then load it
        OreConfig.createConfig();
        OreConfig.init(DimensionalOres.config);
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void registerStones(Events.PreEvent<Stone> event) {
        IForgeRegistry<Stone> r = event.getRegistry();

        // aether legacy stone
        r.register(new BasicStone("holystone", "aether_legacy", Configuration.Conf.aether_id));

        // atum stone
        r.register(new BasicStone("limestone", "atum", Configuration.Conf.atum_id));

        // misty world stone
        r.register(new BasicStone("foggy_stone", "mist", Configuration.Conf.mist_id, "stone"));

        // erebus stone
        r.register(new BasicStone("umberstone", "erebus", Configuration.Conf.erebus_id));

        // midnight stones
        r.register(new BasicStone("trenchstone", "midnight", Configuration.Conf.midnight_id));
        r.register(new BasicStone("nightstone", "midnight", Configuration.Conf.midnight_id));

        // the abyss stones
        r.register(new BasicStone("abyss_stone", "theabyss", 4));

        // gaia dimension stone
        r.register(new BasicStone("gaia_stone", "gaiadimension", Configuration.Conf.gaia_id));

        // blue skies stones
        r.register(new BasicStone("turquoise_stone", "blue_skies", Configuration.Conf.everbright_id));
        r.register(new BasicStone("lunar_stone", "blue_skies", Configuration.Conf.everdawn_id));

        // galacticraft stones
        r.register(new GalacticraftStone("moon_rock", "galacticraftcore", Configuration.Conf.galacticraft_moon_id, "basic_block_moon"));
        r.register(new GalacticraftStone("mars_stone", "galacticraftplanets", Configuration.Conf.galacticraft_mars_id, "mars"));
        r.register(new GalacticraftStone("venus_stone", "galacticraftplanets", Configuration.Conf.galacticraft_venus_id, "venus"));
        r.register(new GalacticraftStone("asteroids_rock", "galacticraftplanets", Configuration.Conf.galacticraft_asteroids_id, "asteroids_block"));

        // extra planets stones
        r.register(new ExtraPlanetStone("mercury_stone", "extraplanets", -13));
        r.register(new ExtraPlanetStone("triton_stone", "extraplanets", -1504));
        r.register(new ExtraPlanetStone("titania_stone", "extraplanets", -1510));
        r.register(new ExtraPlanetStone("jupiter_stone", "extraplanets", -15));
        r.register(new ExtraPlanetStone("saturn_stone", "extraplanets", -16));
        r.register(new ExtraPlanetStone("neptune_stone", "extraplanets", -18));
        r.register(new ExtraPlanetStone("ceres_stone", "extraplanets", -20));
        r.register(new ExtraPlanetStone("kepler22b_stone", "extraplanets", -21));
        r.register(new ExtraPlanetStone("eris_stone", "extraplanets", -22));
        r.register(new ExtraPlanetStone("uranus_stone", "extraplanets", -21));
        r.register(new ExtraPlanetStone("europa_stone", "extraplanets", -1501));
        r.register(new ExtraPlanetStone("io_stone", "extraplanets", -1500));
        r.register(new ExtraPlanetStone("deimos_stone", "extraplanets", -1503));
        r.register(new ExtraPlanetStone("phobos_stone", "extraplanets", -1502));
        r.register(new ExtraPlanetStone("callisto_stone", "extraplanets", -1505));
        r.register(new ExtraPlanetStone("ganymede_stone", "extraplanets", -1506));
        r.register(new ExtraPlanetStone("titan_stone", "extraplanets", -1508));
        r.register(new ExtraPlanetStone("oberon_stone", "extraplanets", -1509));
        r.register(new ExtraPlanetStone("iapetus_stone", "extraplanets", -1511));
        r.register(new ExtraPlanetStone("rhea_stone", "extraplanets", -1507));

        // more planets stones
        r.register(new BasicStone("diona_stone", "moreplanets", -2542));
        r.register(new BasicStone("fronos_stone", "moreplanets", -2545));
        r.register(new BasicStone("chalos_rock", "moreplanets", -2543));
        r.register(new BasicStone("nibiru_rock", "moreplanets", -2544));

        // zollern galaxy stones
        r.register(new BasicStone("altum", "zollerngalaxy", -7878, "altumstone"));
        r.register(new BasicStone("atheon", "zollerngalaxy", -7998, "atheonstone"));
        r.register(new BasicStone("caligro", "zollerngalaxy", -7877, "caligrostone"));

        // betweenlands stones
        r.register(new BasicStone("betweenstone", "thebetweenlands", Configuration.Conf.betweenland_id));
        r.register(new BasicStone("pitstone", "thebetweenlands", Configuration.Conf.betweenland_id));

        // auorian stone
        r.register(new BasicStone("aurorianstone", "theaurorian", Configuration.Conf.betweenland_id));

        // glacidus stone
        r.register(new BasicStone("frozen_antinatic_stone", "glacidus", Configuration.Conf.glacidus_id));
    }
}
