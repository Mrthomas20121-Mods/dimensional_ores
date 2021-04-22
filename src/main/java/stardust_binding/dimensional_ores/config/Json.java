package stardust_binding.dimensional_ores.config;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.commons.io.FileUtils;
import stardust_binding.dimensional_ores.DimensionalOres;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class Json {

    private static Gson gson = new Gson();
    public static List<OreProperties> metals = new ArrayList<>();

    private static final String metal_file = "assets/dimensional_ores/config/metals.json";

    public static void init(FMLPreInitializationEvent event) {

        try {
            JsonReader ores = new JsonReader(Files.newBufferedReader(new File(event.getModConfigurationDirectory(), "dimensional_ores/metals.json").toPath()));
            metals = gson.fromJson(ores, new TypeToken<List<OreProperties>>() {}.getType());
            ores.close();
        }
        catch (IOException e) {
            DimensionalOres.getLogger().info("Error Loading ores.json");
        }
    }

    public static void copyConfig(FMLPreInitializationEvent event) {
        File config_dir = event.getModConfigurationDirectory();
        File metals_file = new File(config_dir, DimensionalOres.MODID+"/metals.json");
        if(!metals_file.exists())
        {
            try {
                FileUtils.copyInputStreamToFile(Json.class.getClassLoader().getResourceAsStream(metal_file), metals_file);
            }
            catch (IOException e)
            {
                throw new Error("Problem Creating File in Config/dimensional_ores", e);
            }
        }
        else DimensionalOres.getLogger().info("Json - metals.json already exists, Skipping!");
    }
}
