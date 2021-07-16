package stardust_binding.dimensional_ores.config;

import com.google.gson.*;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import stardust_binding.dimensional_ores.DimensionalOres;
import stardust_binding.dimensional_ores.api.registry.Registries;
import stardust_binding.dimensional_ores.api.type.Ore;
import stardust_binding.dimensional_ores.api.type.Stone;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class OreConfig {

    private static Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
    private static Map<Stone, Map<Ore, OreData>> ores = new LinkedHashMap<>();

    public static Map<Stone, Map<Ore, OreData>> getOres() {
        return ores;
    }

    public static OreData getOreData(Stone stone, Ore ore) {
        if(ores.containsKey(stone))
            return ores.get(stone).get(ore);
        return ore.getDefaultOreData();
    }

    public static void createConfig() {
        File modConfig = new File(DimensionalOres.config, DimensionalOres.MODID);
        for(Stone stone: Registries.getStoneRegistry().getValuesCollection()) {
            File stoneFolder = new File(modConfig, stone.getName());
            if(!stoneFolder.exists()) {
                stoneFolder.mkdir();
            }
            for(Ore ore: Registries.getOreRegistry().getValuesCollection()) {
                File oreFile = new File(stoneFolder, ore.getName()+".json");
                if(oreFile.exists()) continue;
                if(!stone.getBlacklist().contains(ore.getName())) {
                    OreData data = ore.getDefaultOreData();
                    String json = gson.toJson(data);
                    try {
                        oreFile.createNewFile();
                        FileWriter writer = new FileWriter(oreFile);
                        writer.write(json);
                        writer.close();
                    }
                    catch (IOException e) {
                        DimensionalOres.getLogger().info("[Dimensional Ores] Unable to create "+ ore.getName()+".json!");
                    }
                }
            }
        }
    }

    public static void init(File modConfig) {
        for(Stone stone: Registries.getStoneRegistry().getValuesCollection()) {
            Map<Ore, OreData> oreDataMap = new LinkedHashMap<>();
            for(Ore ore: Registries.getOreRegistry().getValuesCollection()) {
                if(stone.getBlacklist().contains(ore.getName())) continue;

                try {
                    File config = new File(modConfig, DimensionalOres.MODID+"/"+stone.getName()+"/"+ore.getName()+".json");
                    FileReader reader = new FileReader(config);
                    OreData oreData = gson.fromJson(reader, OreData.class);
                    reader.close();
                    oreDataMap.put(ore, oreData);
                }
                catch (IOException e) {
                    DimensionalOres.getLogger().info("[Dimensional Ores] Error loading "+ ore.getName()+".json", e);
                }
            }
            if(!oreDataMap.isEmpty()) ores.put(stone, oreDataMap);
        }
    }
}
