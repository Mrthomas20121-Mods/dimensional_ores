package stardust_binding.dimensional_ores.config;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import stardust_binding.dimensional_ores.DimensionalOres;
import stardust_binding.dimensional_ores.api.registry.Registries;
import stardust_binding.dimensional_ores.api.type.Ore;
import stardust_binding.dimensional_ores.api.type.Stone;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.LinkedHashMap;
import java.util.Map;

public class OreConfig {

    private static Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
    private static Map<Stone, Map<Ore, OreData>> ores = new LinkedHashMap<>();

    public static OreData getOreData(Stone stone, Ore ore) {
        if(ores.containsKey(stone))
            return ores.get(stone).get(ore);
        return ore.getDefaultOreData();
    }

    public static void createConfig(FMLPreInitializationEvent event) {
        File modConfig = new File(event.getModConfigurationDirectory(), DimensionalOres.MODID);
        for(Stone stone: Registries.getStoneRegistry().getValuesCollection()) {
            File stoneFolder = new File(modConfig, stone.getBlockName());
            if(stoneFolder.exists()) stoneFolder.mkdir();
            for(Ore ore: Registries.getOreRegistry().getValuesCollection()) {
                File oreFile = new File(stoneFolder, ore.getName()+".json");
                if(oreFile.exists()) continue;
                OreData data = ore.getDefaultOreData();
                String json = gson.toJson(data);
                try {
                    oreFile.createNewFile();
                    FileWriter writer = new FileWriter(oreFile);
                    writer.write(json);
                    writer.close();
                }
                catch (IOException e) {
                    DimensionalOres.getLogger().info("Error Unable to create "+ ore.getName()+".json!");
                }

            }
        }
    }

    public static void init() {
        for(Stone stone: Registries.getStoneRegistry().getValuesCollection()) {
            Map<Ore, OreData> oreDataMap = new LinkedHashMap<>();
            for(Ore ore: Registries.getOreRegistry().getValuesCollection()) {
                File config = new File(DimensionalOres.config, "dimensional_ores/"+stone.getName()+"/"+ore.getName()+".json");
                try {
                    JsonReader reader = new JsonReader(new FileReader(config));
                    OreData oreData = gson.fromJson(reader, OreData.class);
                    if(!oreDataMap.containsKey(ore)) oreDataMap.put(ore, oreData);
                }
                catch (IOException e) {
                    DimensionalOres.getLogger().info("Error loading "+ ore.getName()+".json");
                }
            }
            ores.put(stone, oreDataMap);
        }
    }
}
