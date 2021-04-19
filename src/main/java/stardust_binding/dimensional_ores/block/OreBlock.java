package stardust_binding.dimensional_ores.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import org.apache.commons.lang3.StringUtils;
import stardust_binding.dimensional_ores.DimensionalOres;
import stardust_binding.dimensional_ores.ore.Stone;
import stardust_binding.dimensional_ores.config.JsonMetal;

import javax.annotation.Nonnull;
import java.util.EnumMap;
import java.util.HashMap;

public class OreBlock extends Block {

    private static HashMap<JsonMetal, EnumMap<Stone, OreBlock>> table = new HashMap<>();

    public static OreBlock get(JsonMetal metal, Stone stone) {
        return table.get(metal).get(stone);
    }

    private final JsonMetal metal;
    private final Stone stone;

    public OreBlock(JsonMetal metal, Stone stone) {
        super(Material.ROCK);

        this.metal = metal;
        this.stone = stone;
        this.setRegistryName(DimensionalOres.MODID, stone.name().toLowerCase()+"_"+metal.getName()+"_ore");
        this.setTranslationKey(DimensionalOres.MODID+"."+stone.name().toLowerCase()+"_"+metal.getName()+"_ore");

        this.setHardness(metal.getHardness());
        this.setHarvestLevel("pickaxe", metal.getMininglevel());
        this.setLightLevel(metal.getLightlevel());

        if(!table.containsKey(metal)) {
            table.put(metal, new EnumMap<>(Stone.class));
        }
        table.get(metal).put(stone, this);
    }

    @Nonnull
    @Override
    public String getLocalizedName() {
        return String.format("%s %s %s", StringUtils.capitalize(stone.getName()), StringUtils.capitalize(metal.getName()), "Ore");
    }

    public JsonMetal getMetal() {
        return metal;
    }

    public Stone getStone() {
        return stone;
    }
}
