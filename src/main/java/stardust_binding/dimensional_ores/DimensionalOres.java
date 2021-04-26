package stardust_binding.dimensional_ores;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import org.apache.logging.log4j.Logger;
import stardust_binding.dimensional_ores.api.registry.Events;
import stardust_binding.dimensional_ores.api.registry.Registries;
import stardust_binding.dimensional_ores.api.type.Ore;
import stardust_binding.dimensional_ores.api.type.Stone;
import stardust_binding.dimensional_ores.block.OreBlock;
import stardust_binding.dimensional_ores.config.Configuration;
import stardust_binding.dimensional_ores.config.OreProperties;
import stardust_binding.dimensional_ores.world.WorldGenOre;

import java.io.File;

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

    public static File config;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
        config = event.getModConfigurationDirectory();
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.post(new Events.PreEvent<>(new ResourceLocation(DimensionalOres.MODID, "stone"), Registries.STONE_REGISTRY));
        MinecraftForge.EVENT_BUS.post(new Events.PreEvent<>(new ResourceLocation(DimensionalOres.MODID, "ore"), Registries.ORE_REGISTRY));

        Configuration.copyConfig(event);
	}

    @Mod.EventHandler
    public void init(FMLInitializationEvent event){
        GameRegistry.registerWorldGenerator(new WorldGenOre(), 500);

        for(Ore ore: Registries.getOreRegistry().getValuesCollection()) {
            for(Stone stone: Registries.getStoneRegistry().getValuesCollection()) {
                OreProperties properties = OreProperties.getOreData(stone, ore);
                if(properties != null) {
                    OreDictionary.registerOre(properties.getOreDict(), OreBlock.get(ore, stone));
                    if(!properties.getAlternativeOredict().equals("")) OreDictionary.registerOre(properties.getAlternativeOredict(), OreBlock.get(ore, stone));
                }
            }
        }
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event){}

}
