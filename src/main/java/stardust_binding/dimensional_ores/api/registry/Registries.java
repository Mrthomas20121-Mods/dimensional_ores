package stardust_binding.dimensional_ores.api.registry;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryBuilder;
import stardust_binding.dimensional_ores.DimensionalOres;
import stardust_binding.dimensional_ores.api.type.Ore;
import stardust_binding.dimensional_ores.api.type.Stone;

@Mod.EventBusSubscriber(modid = DimensionalOres.MODID)
public class Registries {

    public static IForgeRegistry<Stone> STONE_REGISTRY;

    public static IForgeRegistry<Ore> ORE_REGISTRY;

    public static IForgeRegistry<Stone> getStoneRegistry() {
        return GameRegistry.findRegistry(Stone.class);
    }

    public static IForgeRegistry<Ore> getOreRegistry() {
        return GameRegistry.findRegistry(Ore.class);
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void registerRegistries(RegistryEvent.NewRegistry event) {
        STONE_REGISTRY = new RegistryBuilder<Stone>()
                .setType(Stone.class)
                .setName(new ResourceLocation(DimensionalOres.MODID, "stone"))
                .setIDRange(0, 400)
                .allowModification()
                .create();
        ORE_REGISTRY = new RegistryBuilder<Ore>()
                .setType(Ore.class)
                .setName(new ResourceLocation(DimensionalOres.MODID, "ore"))
                .setIDRange(0, 400)
                .allowModification()
                .create();
    }
}
