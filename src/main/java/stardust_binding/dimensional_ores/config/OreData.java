package stardust_binding.dimensional_ores.config;

public class OreData {

    // if the ore is enabled
    private boolean enabled;

    // ore lightlevel
    private int lightLevel;

    // ore harvest level
    private int harvestLevel;

    // ore hardness
    private int hardness;

    // ore min y
    private int minY;

    // ore max y
    private int maxY;

    // ore size
    private int size;

    // how much should generate per chunk
    private int numberToGenerate;

    public OreData(boolean enabled, int lightLevel, int harvestLevel, int hardness, int minY, int maxY, int size, int numberToGenerate) {
        this.enabled = enabled;
        this.lightLevel = lightLevel;
        this.harvestLevel = harvestLevel;
        this.hardness = hardness;
        this.minY = minY;
        this.maxY = maxY;
        this.size = size;
        this.numberToGenerate = numberToGenerate;
    }

    public OreData(boolean enabled, int harvestLevel, int hardness, int minY, int maxY, int size, int numberToGenerate) {
        this(enabled, 0, harvestLevel, hardness, minY, maxY, size, numberToGenerate);
    }

    public boolean isEnabled() {
        return enabled;
    }

    public int getLightLevel() {
        return lightLevel;
    }

    public int getHarvestLevel() {
        return harvestLevel;
    }

    public int getHardness() {
        return hardness;
    }

    public int getMinY() {
        return minY;
    }

    public int getMaxY() {
        return maxY;
    }

    public int getSize() {
        return size;
    }

    public int getNumberToGenerate() {
        return numberToGenerate;
    }
}
