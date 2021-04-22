package stardust_binding.dimensional_ores.config;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.commons.lang3.StringUtils;
import stardust_binding.dimensional_ores.DimensionalOres;
import stardust_binding.dimensional_ores.api.registry.Registries;
import stardust_binding.dimensional_ores.api.type.Ore;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class OreProperties {

    private static Gson gson = new Gson();
    private static Map<String, OreProperties> ores = new LinkedHashMap<>();

    public static void init() {
        for(Ore ore: Registries.ORE_REGISTRY.getValuesCollection()) {
            String name = ore.getRegistryName().getPath().toLowerCase();
            try {
                JsonReader reader = new JsonReader(Files.newBufferedReader(new File(DimensionalOres.config, "dimensional_ores/ores/"+name+".json").toPath()));
                ores.put(name, gson.fromJson(reader, OreProperties.class));
                reader.close();
            }
            catch (IOException e) {
                DimensionalOres.getLogger().info("Error Loading "+name+".json");
            }
        }
    }

    public static OreProperties get(String ore) {
        return ores.get(ore);
    }

    private final String name;
    private final int hardness;
    private final int mininglevel;
    private final int lightlevel;
    private final String[] biomes;
    private final int[] dimensions;
    private final boolean enabled;

    public OreProperties(String name, int hardness, int mininglevel, int lightlevel, String[] biomes, int[] dimensions, boolean enabled) {
        this.name = name;
        this.hardness = hardness;
        this.mininglevel = mininglevel;
        this.lightlevel = lightlevel;
        this.biomes = biomes;
        this.dimensions = dimensions;
        this.enabled = enabled;
    }

    public OreProperties(String name, int hardness, int mininglevel, int lightlevel, String biome, int dimension, boolean enabled) {
        this(name, hardness, mininglevel, lightlevel, new String[] { biome }, new int[] { dimension }, enabled);
    }

    public int getHardness() {
        return hardness;
    }

    public int getMininglevel() {
        return mininglevel;
    }

    public int getLightlevel() {
        return lightlevel;
    }

    public String[] getBiomes() {
        return biomes;
    }

    public String getName() {
        return name;
    }

    public int[] getDimensions() {
        return dimensions;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public String getOreDict() {
        return "ore".concat(StringUtils.capitalize(this.getName()));
    }

    public String getAlternativeOredict() {
        if(this.name.equals("aluminum")) {
            return "ore".concat("Aluminium");
        }
        return "";
    }

    public boolean containBiome(String biome_name) {
        if(biomes.length == 0) return true;
        for(String biome: biomes) {
            if(biome_name.equals(biome)) return true;
        }
        return false;
    }

    public boolean containDimension(int dimension) {
        if(dimensions.length == 0) return true;
        for(int dim: dimensions) {
            if(dimension == dim) return true;
        }
        return false;
    }
}
