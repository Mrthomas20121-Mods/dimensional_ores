package stardust_binding.dimensional_ores;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import org.apache.commons.lang3.StringUtils;
import stardust_binding.dimensional_ores.config.Configuration;

import javax.annotation.Nonnull;
import com.google.common.base.Predicate;

public enum Stone implements IStringSerializable {
    HOLYSTONE("aether_legacy"),
    LIMESTONE("atum"),
    FOGGY_STONE("mist"),
    UMBERSTONE("erebus"),
    TRENCHSTONE("midnight"),
    NIGHTSTONE("midnight"),
    ABYSS_STONE("theabyss"),
    GAIA_STONE("gaiadimension"),
    TURQUOISE_STONE("blue_skies"),
    LUNAR_STONE("blue_skies");

    private final String modid;

    Stone(String modid) {
        this.modid = modid;
    }

    public boolean canLoad() {
        return Loader.isModLoaded(this.modid);
    }

    public String getBlockName() {
        switch (this) {
            case FOGGY_STONE:
                return "stone";
            case ABYSS_STONE:
                return "stoneabyssblock";
            default:
                return this.name().toLowerCase();
        }
    }

    public Block getBlock(ResourceLocation location) {
        return ForgeRegistries.BLOCKS.getValue(location);
    }

    public Predicate<IBlockState> get() {
        if(this.equals(FOGGY_STONE)) {
            return blockState -> blockState.equals(getBlock(new ResourceLocation(this.modid, this.getBlockName())).getDefaultState()) || blockState.equals(getBlock(new ResourceLocation(this.modid, "stone_porous")).getDefaultState());
        }
        return blockState -> blockState.equals(getBlock(new ResourceLocation(this.modid, this.getBlockName())).getDefaultState());
    }

    public int getDimensionID() {
        switch (this) {
            case HOLYSTONE:
                return Configuration.Conf.aether_id;
            case LIMESTONE:
                return Configuration.Conf.atum_id;
            case TRENCHSTONE:
            case NIGHTSTONE:
                return Configuration.Conf.midnight_id;
            case UMBERSTONE:
                return Configuration.Conf.erebus_id;
            case GAIA_STONE:
                return Configuration.Conf.gaia_id;
            case FOGGY_STONE:
                return Configuration.Conf.mist_id;
            case ABYSS_STONE:
                return 0;
            case LUNAR_STONE:
                return Configuration.Conf.everdawn_id;
            case TURQUOISE_STONE:
                return Configuration.Conf.everbright_id;
            default:
                return 0;
        }
    }

    @Nonnull
    @Override
    public String getName() {
        return cap(this.name().toLowerCase());
    }

    /**
     * Capitalize String
     */
    private String cap(String str)
    {
        if(str.contains("_")) {
            String[] array = str.split("_");
            StringBuilder s = new StringBuilder();
            for(String string: array)
            {
                s.append(StringUtils.capitalize(string));
                s.append(" ");
            }
            return s.toString().substring(0, s.length()-1);
        }
        return StringUtils.capitalize(str);
    }
}
