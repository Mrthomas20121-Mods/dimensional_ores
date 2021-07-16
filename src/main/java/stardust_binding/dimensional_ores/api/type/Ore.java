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
        return "ore".concat(StringUtils.capitalize(this.getName()));
    }

    public String getAlternativeOredict() {
        if(this.getName().equals("aluminum")) {
            return "ore".concat("Aluminium");
        }
        return "";
    }

    public OreData getDefaultOreData() {
        return new OreData(true, 1, 5, 5, 60, 4, 7);
    }
}
