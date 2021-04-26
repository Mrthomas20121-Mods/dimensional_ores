package stardust_binding.dimensional_ores.api.type;

import net.minecraft.util.IStringSerializable;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.IForgeRegistryEntry;
import stardust_binding.dimensional_ores.DimensionalOres;

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
}
