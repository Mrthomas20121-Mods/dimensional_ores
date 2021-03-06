package stardust_binding.dimensional_ores.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import stardust_binding.dimensional_ores.DimensionalOres;
import stardust_binding.dimensional_ores.api.type.Ore;
import stardust_binding.dimensional_ores.api.type.Stone;
import stardust_binding.dimensional_ores.config.OreConfig;
import stardust_binding.dimensional_ores.config.OreData;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class OreBlock extends Block {

    private static HashMap<Ore, LinkedHashMap<Stone, OreBlock>> table = new HashMap<>();

    public static OreBlock get(Ore metal, Stone stone) {
        return table.get(metal).get(stone);
    }

    private final Ore ore;
    private final OreData properties;
    private final Stone stone;

    public OreBlock(Ore ore, Stone stone) {
        super(Material.ROCK);

        this.ore = ore;
        this.stone = stone;
        this.setRegistryName(DimensionalOres.MODID, stone.getName().toLowerCase()+"_"+ore.getName()+"_ore");
        this.setTranslationKey(DimensionalOres.MODID+"."+stone.getName().toLowerCase()+"_"+ore.getName()+"_ore");

        this.properties = OreConfig.getOreData(stone, ore);

        this.setHardness(properties.getHardness());
        this.setHarvestLevel("pickaxe", properties.getHarvestLevel());
        this.setLightLevel(properties.getLightLevel());

        if(!table.containsKey(ore)) {
            table.put(ore, new LinkedHashMap<>());
        }
        table.get(ore).put(stone, this);
    }

    public Ore getOre() {
        return ore;
    }

    public OreData getOreProperties() {
        return properties;
    }

    public Stone getStone() {
        return stone;
    }
}
