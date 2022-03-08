package mrthomas20121.dimensional_ores.api;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import mrthomas20121.dimensional_ores.DimensionalOres;
import mrthomas20121.dimensional_ores.Registry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.IForgeRegistryEntry;

import java.util.*;

public class Stone {

    private static final List<Stone> list = new ArrayList<>();
    public static List<Stone> getAll() {
        return list;
    }

    private final String name;
    private final String mod_id;
    private final Ore[] ores;
    private final List<RegistryObject<Block>> blocks = new ArrayList<>();
    private final List<RegistryObject<Item>> items = new ArrayList<>();

    public Stone(String name, String mod_id, Ore ...ores) {
        this.name = name;
        this.mod_id = mod_id;
        this.ores = ores;
        this.registerOres();
        list.add(this);
    }

    public Stone(String name, String mod_id) {
        this.name = name;
        this.mod_id = mod_id;
        this.ores = Ore.values();
        this.registerOres();
        list.add(this);
    }

    private void registerOres() {
        if(!ModList.get().isLoaded(this.mod_id)) {
            DimensionalOres.LOGGER.info(String.format("Skipping %s because %s is not loaded", this.getName(), this.mod_id));
            return;
        }
        for(Ore ore: this.ores) {
            if(!ore.getModID().equals("minecraft")) {
                // skip the ore if the mod is not loaded
                if(!ModList.get().isLoaded(ore.getModID())) continue;
            }
            String name = String.format("%s_%s", this.getName(), ore.getName());
            RegistryObject<Block> block = Registry.BLOCKS.register(name, Registry::registerBlock);
            RegistryObject<Item> item = Registry.ITEMS.register(name, () -> Registry.registerItem(block.get()));
            this.blocks.add(block);
            this.items.add(item);
        }
    }

    public String getModID() {
        return mod_id;
    }

    public Ore[] getOres() {
        return ores;
    }

    public JsonObject toJson() {
        JsonObject object = new JsonObject();
        JsonArray oreArray = new JsonArray();

        for(Ore ore: this.ores) {
            oreArray.add(ore.getName());
        }
        object.add("ores", oreArray);

        return object;
    }

    public String getName() {
        return this.name.toLowerCase(Locale.ROOT);
    }
}
