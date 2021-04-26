package stardust_binding.dimensional_ores.config;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import org.apache.commons.lang3.StringUtils;
import stardust_binding.dimensional_ores.DimensionalOres;
import stardust_binding.dimensional_ores.api.registry.Registries;
import stardust_binding.dimensional_ores.api.type.Ore;
import stardust_binding.dimensional_ores.api.type.Stone;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class OreProperties {

    private static Gson gson = new GsonBuilder().serializeNulls().create();
    private static Map<Stone, Map<Ore, OreProperties>> ores = new LinkedHashMap<>();

    public static OreProperties getOreData(Stone stone, Ore ore) {
        if(ores.containsKey(stone))
            return ores.get(stone).get(ore);
        return new OreProperties(5, 1, 0, false, 12, 8);
    }

    public static void init() {
        for(Stone stone: Registries.getStoneRegistry().getValuesCollection()) {
            String name = stone.getName();
            DimensionalOres.getLogger().info(DimensionalOres.config);
            try {
                DimensionalOres.getLogger().info(stone.getName());
                File ore_config = new File(DimensionalOres.config, "dimensional_ores/stone/"+name+".json");
                JsonReader reader = new JsonReader(Files.newBufferedReader(ore_config.toPath()));
                Map<String, OreProperties> properties = gson.fromJson(reader, new TypeToken<Map<String, OreProperties>>(){}.getType());
                Map<Ore, OreProperties> ore_map = new LinkedHashMap<>();
                for(Ore ore: Registries.getOreRegistry().getValuesCollection()) {
                    ore_map.put(ore, properties.get(ore.getName()));
                }
                ores.put(stone, ore_map);
                reader.close();
            }
            catch (IOException e) {
                DimensionalOres.getLogger().info("Error Loading "+name+".json");
            }
        }
    }
    private final int hardness;
    private final int mininglevel;
    private final int lightlevel;
    private final boolean enabled;
    private final int veinPerChunk;
    private final int oreCout;

    public OreProperties(int hardness, int mininglevel, int lightlevel, boolean enabled, int veinPerChunk, int oreCount) {
        this.hardness = hardness;
        this.mininglevel = mininglevel;
        this.lightlevel = lightlevel;
        this.enabled = enabled;
        this.veinPerChunk = veinPerChunk;
        this.oreCout = oreCount;
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

    public boolean isEnabled() {
        return enabled;
    }

    public int getVeinPerChunk() {
        return veinPerChunk;
    }

    public int getOreCout() {
        return oreCout;
    }
}
