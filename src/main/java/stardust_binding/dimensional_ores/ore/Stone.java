package stardust_binding.dimensional_ores.ore;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import org.apache.commons.lang3.StringUtils;
import stardust_binding.dimensional_ores.compat.ExtraPlanetCompat;
import stardust_binding.dimensional_ores.compat.GalacticraftCompat;
import stardust_binding.dimensional_ores.config.Configuration;

import javax.annotation.Nonnull;
import com.google.common.base.Predicate;

import java.util.ArrayList;

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
    LUNAR_STONE("blue_skies"),
    MOON_ROCK("galacticraftplanets"),
    MARS_STONE("galacticraftplanets"),
    TRITON_STONE("extraplanets"),
    TITANIA_STONE("extraplanets"),
    JUPITER_STONE("extraplanets"),
    SATURN_STONE("extraplanets"),
    EUROPA_STONE("extraplanets"),
    IO_STONE("extraplanets"),
    DEIMOS_STONE("extraplanets"),
    PHOBOS_STONE("extraplanets"),
    CALLISTO_STONE("extraplanets"),
    GANYMEDE_STONE("extraplanets"),
    OBERON_STONE("extraplanets"),
    IAPETUS_STONE("extraplanets"),
    BETWEENSTONE("thebetweenlands"),
    PITSTONE("thebetweenlands"),
    AURORIANSTONE("theaurorian"),
    FROZEN_ANTINATRIC_STONE("glacidus");

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
            case MOON_ROCK:
                return "basic_block_moon";
            case TRITON_STONE:
            case TITANIA_STONE:
            case JUPITER_STONE:
            case SATURN_STONE:
            case EUROPA_STONE:
            case IO_STONE:
            case DEIMOS_STONE:
            case PHOBOS_STONE:
            case CALLISTO_STONE:
            case MARS_STONE:
            case GANYMEDE_STONE:
            case IAPETUS_STONE:
            case OBERON_STONE:
                return this.getName().split("_")[0];
            default:
                return this.name().toLowerCase();
        }
    }

    public String getModid() {
        return modid;
    }

    public Block getBlock(ResourceLocation location) {
        return ForgeRegistries.BLOCKS.getValue(location);
    }

    public Predicate<IBlockState> get() {
        if(this.equals(FOGGY_STONE)) {
            return blockState -> blockState.equals(getBlock(new ResourceLocation(this.modid, this.getBlockName())).getDefaultState()) || blockState.equals(getBlock(new ResourceLocation(this.modid, "stone_porous")).getDefaultState());
        }
        else if(modid.equals("extraplanets")) {
            return blockstate -> blockstate.equals(ExtraPlanetCompat.INSTANCE.getStone(this, getBlock(new ResourceLocation(this.modid, this.getBlockName()))));
        }
        else if(modid.equals("galacticraftplanets")) {
            return blockstate -> blockstate.equals(GalacticraftCompat.INSTANCE.getStone(this, getBlock(new ResourceLocation(this.modid, this.getBlockName()))));
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
                return Configuration.Conf.abyss_id;
            case LUNAR_STONE:
                return Configuration.Conf.everdawn_id;
            case TURQUOISE_STONE:
                return Configuration.Conf.everbright_id;
            case MOON_ROCK:
                return Configuration.Conf.galacticraft_moon_id;
            case DEIMOS_STONE:
                return -1503;
            case EUROPA_STONE:
                return -1501;
            case CALLISTO_STONE:
                return -1505;
            case TITANIA_STONE:
                return -1510;
            case TRITON_STONE:
                return -1504;
            case GANYMEDE_STONE:
                return -1506;
            case OBERON_STONE:
                return -1509;
            case IAPETUS_STONE:
                return -1511;
            case SATURN_STONE:
                return -16;
            case JUPITER_STONE:
                return -15;
            case BETWEENSTONE:
            case PITSTONE:
                return Configuration.Conf.betweenland_id;
            case FROZEN_ANTINATRIC_STONE:
                return Configuration.Conf.glacidus_id;
            default:
                return 0;
        }
    }

    @Nonnull
    @Override
    public String getName() {
        return cap(this.name().toLowerCase());
    }

    public ArrayList<String> getBlacklist() {
        ArrayList<String> list = new ArrayList<>();
        if(modid.equals("galacticraftcore") || modid.equals("extraplanets")) {
            list.add("copper");
            list.add("tin");
        }

        return list;
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
