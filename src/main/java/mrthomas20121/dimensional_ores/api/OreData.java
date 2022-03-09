package mrthomas20121.dimensional_ores.api;

import com.google.gson.*;
import net.minecraft.client.resources.JsonReloadListener;
import net.minecraft.profiler.IProfiler;
import net.minecraft.resources.IResourceManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.ModList;

import javax.annotation.Nonnull;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class OreData extends JsonReloadListener {

    private static final Gson gson = new GsonBuilder().setPrettyPrinting().registerTypeAdapter(OreConfig.class, OreConfig.Adapter.INSTANCE).create();

    public static final OreData INSTANCE = new OreData();

    public static Map<Ore, OreConfig> table = new HashMap<>();

    static {
        for(Ore ore: Ore.getActiveValues()) {
            table.put(ore, new OreConfig(true, 4, 10, 30, 60));
        }
    }

    public OreData() {
        super(gson, "dim_ore_data");
    }

    @Override
    protected void apply(@Nonnull Map<ResourceLocation, JsonElement> pObject, @Nonnull IResourceManager manager, @Nonnull IProfiler profiler) {
        for(JsonElement ele: pObject.values()) {
            String oreName = ele.getAsJsonObject().get("oreName").getAsString();
            Ore ore = Ore.valueOf(oreName);
            OreConfig oreConfig = gson.fromJson(ele, OreConfig.class);
            table.put(ore, oreConfig);
        }
    }

    public static final OreConfig defaultValue = new OreConfig(true, 4, 10, 30, 60);
    public static final OreConfig empty = new OreConfig(false, 0, 0, 0, 60);

    public static final class OreConfig {

        private final boolean enabled;
        private final int orePerChunk;
        private final int oreAmount;
        private final int minY;
        private final int maxY;

        public OreConfig(boolean enabled, int orePerChunk, int oreAmount, int minY, int maxY) {
            this.enabled = enabled;
            this.orePerChunk = orePerChunk;
            this.oreAmount = oreAmount;
            this.minY = minY;
            this.maxY = maxY;
        }

        public boolean isEnabled() {
            return enabled;
        }

        public int getOrePerChunk() {
            return orePerChunk;
        }

        public int getOreAmount() {
            return oreAmount;
        }

        public int getMinY() {
            return minY;
        }

        public int getMaxY() {
            return maxY;
        }

        public static class Adapter implements JsonDeserializer<OreConfig> {

            public static Adapter INSTANCE = new Adapter();

            @Override
            public OreConfig deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                JsonObject object = json.getAsJsonObject();
                boolean e = object.get("enabled").getAsBoolean();
                int ore = object.get("orePerChunk").getAsInt();
                int oreA = object.get("oreAmount").getAsInt();
                int minY = object.get("minY").getAsInt();
                int maxY = object.get("maxY").getAsInt();
                return new OreConfig(e, ore, oreA, minY, maxY);
            }
        }
    }
}
