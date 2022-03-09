package mrthomas20121.dimensional_ores.api;

import net.minecraftforge.fml.ModList;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public enum Ore {
    COAL,
    IRON,
    GOLD,
    DIAMOND,
    COPPER,
    SILVER,
    LEAD,
    CERTUS_QUARTZ("appliedenergistic2");

    private final String modID;

    Ore(String modID) {
        this.modID = modID;
    }

    Ore() {
        // default to minecraft so it always load
        this.modID = "minecraft";
    }

    public String getName() {
        return this.name().toLowerCase(Locale.ROOT);
    }

    public String getModID() {
        return modID;
    }

    public boolean isLoaded() {
        if(modID.equals("minecraft")) {
            return true;
        }
        return ModList.get().isLoaded(this.modID);
    }

    public static List<Ore> getActiveValues() {
        return Arrays.stream(Ore.values()).filter(Ore::isLoaded).collect(Collectors.toList());
    }
}
