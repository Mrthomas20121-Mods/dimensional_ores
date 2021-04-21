package stardust_binding.dimensional_ores;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import org.apache.logging.log4j.Logger;
import stardust_binding.dimensional_ores.block.OreBlock;
import stardust_binding.dimensional_ores.config.Json;
import stardust_binding.dimensional_ores.config.JsonMetal;
import stardust_binding.dimensional_ores.ore.Stone;
import stardust_binding.dimensional_ores.world.WorldGenOre;

@Mod(modid = DimensionalOres.MODID, name = DimensionalOres.NAME, version = DimensionalOres.VERSION,
        dependencies = "required-after:forge@[14.23.5.2847,);"
        + "after:aether_legacy;")
public class DimensionalOres
{
    @Mod.Instance
    public static DimensionalOres instance;
    public static final String MODID = "dimensional_ores";
    public static final String NAME = "Dimensional Ore";
    public static final String VERSION = "0.0.2";

    private static Logger logger;

    public static Logger getLogger() {
        return logger;
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        MinecraftForge.EVENT_BUS.register(this);
        logger = event.getModLog();

        Json.copyConfig(event);
        Json.init(event);
	}

    @Mod.EventHandler
    public void init(FMLInitializationEvent event){
        GameRegistry.registerWorldGenerator(new WorldGenOre(), 500);

        for(JsonMetal metal: Json.metals) {
            for(Stone stone: Stone.values()) {
                OreDictionary.registerOre(metal.getOreDict(), OreBlock.get(metal, stone));
                if(!metal.getAlternativeOredict().equals("")) OreDictionary.registerOre(metal.getAlternativeOredict(), OreBlock.get(metal, stone));
            }
        }
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event){}

}
