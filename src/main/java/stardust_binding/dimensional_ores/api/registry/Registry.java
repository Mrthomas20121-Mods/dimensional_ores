package stardust_binding.dimensional_ores.api.registry;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;
import stardust_binding.dimensional_ores.DimensionalOres;
import stardust_binding.dimensional_ores.api.type.BasicStone;
import stardust_binding.dimensional_ores.api.type.Ore;
import stardust_binding.dimensional_ores.api.type.Stone;
import stardust_binding.dimensional_ores.config.Configuration;
import stardust_binding.dimensional_ores.config.OreProperties;

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
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void registerStoneLowest(Events.PreEvent<Stone> event) {
        OreProperties.init();
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
        r.register(new BasicStone("moon_rock", "galacticraftcore", Configuration.Conf.galacticraft_moon_id, "basic_block_moon"));
        r.register(new BasicStone("mars_stone", "galacticraftplanets", Configuration.Conf.galacticraft_mars_id, "mars"));
        r.register(new BasicStone("venus_stone", "galacticraftplanets", Configuration.Conf.galacticraft_venus_id, "venus"));
        r.register(new BasicStone("asteroids_rock", "galacticraftplanets", Configuration.Conf.galacticraft_asteroids_id, "asteroids_block"));

        // extra planets stones
        r.register(new BasicStone("mercury_stone", "extraplanets", -13));
        r.register(new BasicStone("triton_stone", "extraplanets", -1504));
        r.register(new BasicStone("titania_stone", "extraplanets", -1510));
        r.register(new BasicStone("jupiter_stone", "extraplanets", -15));
        r.register(new BasicStone("saturn_stone", "extraplanets", -16));
        r.register(new BasicStone("neptune_stone", "extraplanets", -18));
        r.register(new BasicStone("ceres_stone", "extraplanets", -20));
        r.register(new BasicStone("kepler22b_stone", "extraplanets", -21));
        r.register(new BasicStone("eris_stone", "extraplanets", -22));
        r.register(new BasicStone("uranus_stone", "extraplanets", -21));
        r.register(new BasicStone("europa_stone", "extraplanets", -1501));
        r.register(new BasicStone("io_stone", "extraplanets", -1500));
        r.register(new BasicStone("deimos_stone", "extraplanets", -1503));
        r.register(new BasicStone("phobos_stone", "extraplanets", -1502));
        r.register(new BasicStone("callisto_stone", "extraplanets", -1505));
        r.register(new BasicStone("ganymede_stone", "extraplanets", -1506));
        r.register(new BasicStone("titan_stone", "extraplanets", -1508));
        r.register(new BasicStone("oberon_stone", "extraplanets", -1509));
        r.register(new BasicStone("iapetus_stone", "extraplanets", -1511));
        r.register(new BasicStone("rhea_stone", "extraplanets", -1507));

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
