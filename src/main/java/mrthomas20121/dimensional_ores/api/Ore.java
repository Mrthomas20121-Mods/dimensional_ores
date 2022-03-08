package mrthomas20121.dimensional_ores.api;

import java.util.Locale;

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
}
