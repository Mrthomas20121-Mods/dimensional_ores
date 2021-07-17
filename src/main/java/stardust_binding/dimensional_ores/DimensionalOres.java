package stardust_binding.dimensional_ores;

import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
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
import stardust_binding.dimensional_ores.config.OreConfig;
import stardust_binding.dimensional_ores.world.OreGen;

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

    public static File config;

    public static Logger getLogger() {
        return logger;
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
        MinecraftForge.EVENT_BUS.register(this);
        config = event.getModConfigurationDirectory();

        MinecraftForge.EVENT_BUS.post(new Events.PreEvent<>(new ResourceLocation(DimensionalOres.MODID, "stone"), Registries.STONE_REGISTRY, event.getModConfigurationDirectory()));
        MinecraftForge.EVENT_BUS.post(new Events.PreEvent<>(new ResourceLocation(DimensionalOres.MODID, "ore"), Registries.ORE_REGISTRY, event.getModConfigurationDirectory()));
	}

    @Mod.EventHandler
    public void init(FMLInitializationEvent event){
        GameRegistry.registerWorldGenerator(new OreGen(), 500);

        for(Ore ore: Registries.getOreRegistry().getValuesCollection()) {
            for(Stone stone: Registries.getStoneRegistry().getValuesCollection()) {
                if(!stone.getBlacklist().contains(ore.getName()) && stone.isModLoaded()) {
                    if(OreConfig.getOreData(stone, ore).isEnabled()) {
                        OreBlock oreBlock = OreBlock.get(ore, stone);
                        OreDictionary.registerOre(ore.getOreDict(), oreBlock);
                        if(!ore.getAlternativeOredict().equals("")) OreDictionary.registerOre(ore.getAlternativeOredict(), oreBlock);
                        if(Configuration.Conf.generateFurnaceRecipes) {
                            String ingot = ore.getIngotOredict();
                            String gem = ore.getGemOredict();
                            NonNullList<ItemStack> ingotItems = OreDictionary.getOres(ingot);
                            NonNullList<ItemStack> gemItems = OreDictionary.getOres(gem);
                            ItemStack output = ItemStack.EMPTY;
                            if(!ingotItems.isEmpty()) {
                                output = ingotItems.get(0);
                                output.setCount(1);
                            }
                            else if(!gemItems.isEmpty()) {
                                output = gemItems.get(0);
                                output.setCount(1);
                            }
                            GameRegistry.addSmelting(new ItemStack(oreBlock, 1), output, 1);
                        }
                    }
                }
            }
        }
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event){}

}
