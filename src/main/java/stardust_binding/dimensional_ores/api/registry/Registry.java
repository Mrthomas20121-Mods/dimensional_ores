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
        r.register(new Ore("iridium"));
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

        r.register(new BasicStone("holystone", "aether_legacy", Configuration.Conf.aether_id));
        r.register(new BasicStone("limestone", "atum", Configuration.Conf.atum_id));
        r.register(new BasicStone("turquoise_stone", "blue_skies", Configuration.Conf.everbright_id));
        r.register(new BasicStone("lunar_stone", "blue_skies", Configuration.Conf.everdawn_id));
        r.register(new BasicStone("umberstone", "erebus", Configuration.Conf.erebus_id));
        r.register(new ExtraPlanetStone("io", "extraplanets", Configuration.Conf.io_id));
        r.register(new ExtraPlanetStone("mercury", "extraplanets", Configuration.Conf.mercury_id));
        r.register(new ExtraPlanetStone("ceres", "extraplanets", Configuration.Conf.ceres_id));
        r.register(new ExtraPlanetStone("jupiter", "extraplanets", Configuration.Conf.jupiter_id));
        r.register(new ExtraPlanetStone("pluto", "extraplanets", Configuration.Conf.pluto_id));
        r.register(new ExtraPlanetStone("eris", "extraplanets", Configuration.Conf.eris_id));
        r.register(new ExtraPlanetStone("kepler22b", "extraplanets", Configuration.Conf.kepler_id));
        r.register(new ExtraPlanetStone("deimos", "extraplanets", Configuration.Conf.deimos_id));
        r.register(new ExtraPlanetStone("ganymede", "extraplanets", Configuration.Conf.ganymede_id));
        r.register(new ExtraPlanetStone("titan", "extraplanets", Configuration.Conf.titan_id));
        r.register(new ExtraPlanetStone("titania", "extraplanets", Configuration.Conf.titania_id));
        r.register(new ExtraPlanetStone("saturn", "extraplanets", Configuration.Conf.saturn_id));
        r.register(new ExtraPlanetStone("phobos", "extraplanets", Configuration.Conf.phobos_id));
        r.register(new ExtraPlanetStone("triton", "extraplanets", Configuration.Conf.triton_id));
        r.register(new ExtraPlanetStone("rhea", "extraplanets", Configuration.Conf.rhea_id));
        r.register(new ExtraPlanetStone("iapetus", "extraplanets", Configuration.Conf.iapetus_id));
        r.register(new ExtraPlanetStone("uranus", "extraplanets", Configuration.Conf.uranus_id));
        r.register(new ExtraPlanetStone("neptune", "extraplanets", Configuration.Conf.neptune_id));
        r.register(new ExtraPlanetStone("europa", "extraplanets", Configuration.Conf.europa_id));
        r.register(new ExtraPlanetStone("callisto", "extraplanets", Configuration.Conf.callisto_id));
        r.register(new ExtraPlanetStone("oberon", "extraplanets", Configuration.Conf.oberon_id));
        r.register(new BasicStone("gaia_stone", "gaia_dimension", Configuration.Conf.gaia_id));
        r.register(new GalacticraftStone("asteroids_block", "galacticraft_core", Configuration.Conf.galacticraft_asteroids_id));
        r.register(new GalacticraftStone("basic_block_moon", "galacticraft_core", Configuration.Conf.galacticraft_moon_id));
        r.register(new GalacticraftStone("mars", "galacticraft_core", Configuration.Conf.galacticraft_mars_id));
        r.register(new GalacticraftStone("venus", "galacticraft_core", Configuration.Conf.galacticraft_venus_id));
        r.register(new BasicStone("frozen_antinatric_stone", "glacidus", Configuration.Conf.glacidus_id));
        r.register(new BasicStone("nightstone", "midnight", Configuration.Conf.midnight_id));
        r.register(new BasicStone("trenchstone", "midnight", Configuration.Conf.midnight_id));
        r.register(new BasicStone("stone", "mist", Configuration.Conf.mist_id));
        r.register(new BasicStone("stone_porous", "mist", Configuration.Conf.mist_id));
        r.register(new BasicStone("fronos_stone", "moreplanets", Configuration.Conf.fronos_id));
        r.register(new BasicStone("diona_rock", "moreplanets", Configuration.Conf.diona_id));
        r.register(new BasicStone("chalos_rock", "moreplanets", Configuration.Conf.chalos_id));
        r.register(new BasicStone("koentus_rock", "moreplanets", Configuration.Conf.koentus_id));
        r.register(new BasicStone("nibiru_rock", "moreplanets", Configuration.Conf.nibiru_id));
        r.register(new BasicStone("aurorianstone", "theaurorian", Configuration.Conf.aurorian_id));
        r.register(new BasicStone("betweenstone", "thebetweenlands", Configuration.Conf.betweenland_id));
        r.register(new BasicStone("pitstone", "thebetweenlands", Configuration.Conf.betweenland_id));
        r.register(new BasicStone("edenrock", "zollerngalaxy", 0));
        r.register(new BasicStone("kriffstone", "zollerngalaxy", 0));
        r.register(new BasicStone("oasisstone", "zollerngalaxy", 0));
        r.register(new BasicStone("atheonstone", "zollerngalaxy", -7998));
        r.register(new BasicStone("perdstone", "zollerngalaxy", 0));
        r.register(new BasicStone("altumstone", "zollerngalaxy", -7878));
        r.register(new BasicStone("caligrostone", "zollerngalaxy", -7877));
        r.register(new BasicStone("corruptstone", "zollerngalaxy", 0));
        r.register(new BasicStone("exodusstone", "zollerngalaxy", 0));
        r.register(new BasicStone("purgstone", "zollerngalaxy", 0));
        r.register(new BasicStone("zolstone", "zollerngalaxy", 0));
        r.register(new BasicStone("xathstone", "zollerngalaxy", 0));
        r.register(new BasicStone("xantheonstone", "zollerngalaxy", 0));
        r.register(new BasicStone("vortexstone", "zollerngalaxy", 0));
    }
}
