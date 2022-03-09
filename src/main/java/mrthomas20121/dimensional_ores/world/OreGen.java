package mrthomas20121.dimensional_ores.world;

import mrthomas20121.dimensional_ores.DimensionalOres;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = DimensionalOres.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class OreGen {

    @SubscribeEvent(priority = EventPriority.LOW)
    public static void generateOre(final BiomeLoadingEvent event) {
        for(ConfiguredFeature<?, ?> feature: DimensionalOres.oregen) {
            event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> feature);
        }
    }
}
