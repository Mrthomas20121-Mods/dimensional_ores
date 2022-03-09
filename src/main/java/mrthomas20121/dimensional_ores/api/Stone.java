package mrthomas20121.dimensional_ores.api;

import mrthomas20121.dimensional_ores.DimensionalOres;
import mrthomas20121.dimensional_ores.DimRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.*;
import java.util.stream.Collectors;

public class Stone {

    private static final List<Stone> list = new ArrayList<>();
    public static List<Stone> getAll() {
        return list;
    }

    private final String name;
    private final String modID;
    private final List<Ore> ores;
    private final Map<Ore,RegistryObject<Block>> blockMap = new HashMap<>();
    private final List<RegistryObject<Item>> items = new ArrayList<>();

    public Stone(String name, String modID, Ore ...ores) {
        this.name = name;
        this.modID = modID;
        this.ores = ListUtil.newArrayList(ores);
        this.registerOres();
        list.add(this);
    }

    public Stone(String name, String modID) {
        this.name = name;
        this.modID = modID;
        this.ores = Ore.getActiveValues();
        this.registerOres();
        list.add(this);
    }

    private void registerOres() {
        if(!ModList.get().isLoaded(this.modID)) {
            DimensionalOres.LOGGER.info(String.format("Skipping %s because %s is not loaded", this.getName(), this.modID));
            return;
        }
        for(Ore ore: this.ores) {
            String name = String.format("%s_%s", this.getName(), ore.getName());
            RegistryObject<Block> block = DimRegistry.BLOCKS.register(name, DimRegistry::registerBlock);
            RegistryObject<Item> item = DimRegistry.ITEMS.register(name, () -> DimRegistry.registerItem(block.get()));
            this.blockMap.put(ore, block);
            this.items.add(item);
        }
    }

    public Block getStone() {
        return ForgeRegistries.BLOCKS.getValue(new ResourceLocation(this.modID, this.name));
    }

    public RegistryObject<Block> getBlock(Ore ore) {
        return this.blockMap.get(ore);
    }

    public String getName() {
        return this.name.toLowerCase();
    }

    public String getModID() {
        return this.modID;
    }

    public List<Ore> getOres() {
        return this.ores;
    }
}
