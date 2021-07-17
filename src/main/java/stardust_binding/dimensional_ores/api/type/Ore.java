package stardust_binding.dimensional_ores.api.type;

import net.minecraft.util.IStringSerializable;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.IForgeRegistryEntry;
import org.apache.commons.lang3.StringUtils;
import stardust_binding.dimensional_ores.DimensionalOres;
import stardust_binding.dimensional_ores.config.OreData;

import javax.annotation.Nonnull;

public class Ore extends IForgeRegistryEntry.Impl<Ore> implements IStringSerializable {

    public Ore(String name) {
        this.setRegistryName(new ResourceLocation(DimensionalOres.MODID, name));
    }

    @Nonnull
    @Override
    public String getName() {
        return this.getRegistryName().getPath();
    }

    public String getTranslationKey() {
        return DimensionalOres.MODID+".ore."+this.getName();
    }

    public String getOreDict() {
        return "ore".concat(cap(this.getName(), "_"));
    }

    public String getIngotOredict() {
        return "ingot".concat(cap(this.getName(), "_"));
    }

    public String getGemOredict() {
        return "gem".concat(cap(this.getName(), "_"));
    }

    /**
     * Get the alternative oredict for the ore.
     * @return String
     */
    public String getAlternativeOredict() {
        if(this.getName().equals("aluminum")) {
            return "ore".concat("Aluminium");
        }
        return "";
    }

    /**
     * Default ore data that each ore get when the file get generated.
     * @return Default Ore Data
     */
    public OreData getDefaultOreData() {
        return new OreData(true, 1, 5, 5, 60, 4, 4);
    }

    /**
     * Capitalize a String based on the seperator, if none are found, capitalize the input string as if it was one string.
     * @param str String to capitalize
     * @param separator Separator
     * @return Capitalized String
     */
    private String cap(String str, String separator) {
        if(str.contains(separator)) {
            String[] split = str.split(separator);
            StringBuilder output = new StringBuilder();
            for(String s: split) {
                output.append(StringUtils.capitalize(s));
            }
            return output.toString();
        }
        return StringUtils.capitalize(str);
    }
}
