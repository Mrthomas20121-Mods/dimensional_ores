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

    public static Map<Ore, OreConfig> table = new HashMap<>();

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

        if(table.isEmpty()) {
            for(Ore ore: Ore.values()) {
                table.put(ore, defaultValue);
            }
        }
        else {
            // put a default values to missing ores
            for(Ore ore: Ore.values()) {
                if(!table.containsKey(ore)) {
                    table.put(ore, defaultValue);
                }
            }
        }
    }

    public static final OreConfig defaultValue = new OreConfig(true, 4, 10, new String[] {}, new String[] {});
    public static final OreConfig empty = new OreConfig(false, 0, 0, new String[] {}, new String[] {});

    private static final class OreConfig {

        private final boolean enabled;
        private final int orePerChunk;
        private final int oreAmount;
        private final String[] whitelist;
        private final String[] blacklist;

        public OreConfig(boolean enabled, int orePerChunk, int oreAmount, String[] whitelist, String[] blacklist) {
            this.enabled = enabled;
            this.orePerChunk = orePerChunk;
            this.oreAmount = oreAmount;
            this.whitelist = whitelist;
            this.blacklist = blacklist;
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

        public String[] getWhitelist() {
            return whitelist;
        }

        public String[] getBlacklist() {
            return blacklist;
        }

        public boolean emptyWhitelist() {
            return whitelist.length == 0;
        }

        public boolean emptyBlacklist() {
            return blacklist.length == 0;
        }

        public static class Adapter implements JsonDeserializer<OreConfig> {

            public static Adapter INSTANCE = new Adapter();

            @Override
            public OreConfig deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                JsonObject object = json.getAsJsonObject();
                boolean e = object.get("enabled").getAsBoolean();
                int ore = object.get("orePerChunk").getAsInt();
                int oreA = object.get("oreAmount").getAsInt();
                String[] whitelist = context.deserialize(object.get("biomeWhitelist"), String[].class);
                String[] blacklist = context.deserialize(object.get("biomeBlacklist"), String[].class);
                return new OreConfig(e, ore, oreA, whitelist, blacklist);
            }
        }
    }
}
