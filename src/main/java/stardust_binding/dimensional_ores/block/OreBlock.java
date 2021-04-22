package stardust_binding.dimensional_ores.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import org.apache.commons.lang3.StringUtils;
import stardust_binding.dimensional_ores.DimensionalOres;
import stardust_binding.dimensional_ores.api.type.Ore;
import stardust_binding.dimensional_ores.api.type.Stone;
import stardust_binding.dimensional_ores.config.OreProperties;

import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class OreBlock extends Block {

    private static HashMap<Ore, LinkedHashMap<Stone, OreBlock>> table = new HashMap<>();

    public static OreBlock get(Ore metal, Stone stone) {
        return table.get(metal).get(stone);
    }

    private final Ore ore;
    private final OreProperties properties;
    private final Stone stone;

    public OreBlock(Ore ore, Stone stone) {
        super(Material.ROCK);

        this.ore = ore;
        this.stone = stone;
        this.setRegistryName(DimensionalOres.MODID, stone.getName().toLowerCase()+"_"+ore.getName()+"_ore");
        this.setTranslationKey(DimensionalOres.MODID+"."+stone.getName().toLowerCase()+"_"+ore.getName()+"_ore");

        this.properties = OreProperties.get(ore.getName());

        this.setHardness(properties.getHardness());
        this.setHarvestLevel("pickaxe", properties.getMininglevel());
        this.setLightLevel(properties.getLightlevel());

        if(!table.containsKey(ore)) {
            table.put(ore, new LinkedHashMap<>());
        }
        table.get(ore).put(stone, this);
    }

    @Nonnull
    @Override
    public String getLocalizedName() {
        return String.format("%s %s %s", StringUtils.capitalize(stone.getName()), StringUtils.capitalize(ore.getName()), "Ore");
    }

    public Ore getOre() {
        return ore;
    }

    public OreProperties getOreProperties() {
        return properties;
    }

    public Stone getStone() {
        return stone;
    }
}
