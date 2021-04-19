package stardust_binding.dimensional_ores.config;

import org.apache.commons.lang3.StringUtils;

public class JsonMetal {

    private final String name;
    private final int hardness;
    private final int mininglevel;
    private final int lightlevel;
    private final String[] biomes;
    private final int[] dimensions;
    private final boolean enabled;

    public JsonMetal(String name, int hardness, int mininglevel, int lightlevel, String[] biomes, int[] dimensions, boolean enabled) {
        this.name = name;
        this.hardness = hardness;
        this.mininglevel = mininglevel;
        this.lightlevel = lightlevel;
        this.biomes = biomes;
        this.dimensions = dimensions;
        this.enabled = enabled;
    }

    public JsonMetal(String name, int hardness, int mininglevel, int lightlevel, String biome, int dimension, boolean enabled) {
        this(name, hardness, mininglevel, lightlevel, new String[] { biome }, new int[] { dimension }, enabled);
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

    public String[] getBiomes() {
        return biomes;
    }

    public String getName() {
        return name;
    }

    public int[] getDimensions() {
        return dimensions;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public String getOreDict() {
        return "ore".concat(StringUtils.capitalize(this.getName()));
    }

    public String getAlternativeOredict() {
        if(this.name.equals("aluminum")) {
            return "ore".concat("Aluminium");
        }
        return "";
    }

    public boolean containBiome(String biome_name) {
        if(biomes.length == 0) return true;
        for(String biome: biomes) {
            if(biome_name.equals(biome)) return true;
        }
        return false;
    }

    public boolean containDimension(int dimension) {
        if(dimensions.length == 0) return true;
        for(int dim: dimensions) {
            if(dimension == dim) return true;
        }
        return false;
    }
}
