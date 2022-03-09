package mrthomas20121.dimensional_ores;

import mrthomas20121.dimensional_ores.api.Ore;
import mrthomas20121.dimensional_ores.api.OreData;
import mrthomas20121.dimensional_ores.api.Stone;
import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.template.BlockMatchRuleTest;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import net.minecraft.util.registry.Registry;

import java.util.ArrayList;
import java.util.List;

@Mod(DimensionalOres.MOD_ID)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class DimensionalOres {

	public static final String MOD_ID = "dimensional_ores";
	public static final Logger LOGGER = LogManager.getLogger();

	public static List<ConfiguredFeature<?,?>> oregen = new ArrayList<>();

	public DimensionalOres() {
		DimRegistry.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
		DimRegistry.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
	}

	@SubscribeEvent
	public static void setup(FMLCommonSetupEvent event) {
		for(Stone stone: Stone.getAll()) {
			for(Ore ore: stone.getOres()) {
				RegistryObject<Block> oreBlock = stone.getBlock(ore);
				OreData.OreConfig oreConfig = OreData.defaultValue;
				String name = String.format("%s_%s", stone.getName(), ore.getName());
				if(oreConfig.isEnabled()) {
					event.enqueueWork(() -> {
						oregen.add(newConfiguredFeature(name, Feature.ORE.configured(
								new OreFeatureConfig(new BlockMatchRuleTest(oreBlock.get()), stone.getStone().defaultBlockState(), oreConfig.getOrePerChunk())).decorated(Placement.RANGE.configured(new TopSolidRangeConfig(oreConfig.getMinY(), 0, oreConfig.getMaxY()))))
								.squared().count(oreConfig.getOreAmount()));
					});
				}
			}
		}
	}

	public static ConfiguredFeature<?, ?> newConfiguredFeature(String registryName, ConfiguredFeature<?, ?> configuredFeature) {
		Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation(DimensionalOres.MOD_ID, registryName), configuredFeature);
		return configuredFeature;
	}
}
