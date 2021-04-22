package stardust_binding.dimensional_ores.api.type;

import com.google.common.base.Predicate;
import net.minecraft.block.state.IBlockState;
import stardust_binding.dimensional_ores.compat.ExtraPlanetCompat;
import stardust_binding.dimensional_ores.compat.GalacticraftCompat;

import java.util.ArrayList;

public class BasicStone extends Stone {

    public BasicStone(String stone_name, String modid, int dimension_id, String block_name) {
        super(stone_name, modid, dimension_id, block_name);
    }

    public BasicStone(String stone_name, String modid, int dimension_id) {
        super(stone_name, modid, dimension_id);
    }

    @Override
    public Predicate<IBlockState> getPredicate() {
        if(getModId().equals("extraplanets")) {
            return state -> state.equals(ExtraPlanetCompat.INSTANCE.getStone(this, this.getBlockState()));
        }
        else if(getModId().contains("galacticraft")) {
            return state -> state.equals(GalacticraftCompat.INSTANCE.getStone(this, this.getBlockState()));
        }
        return super.getPredicate();
    }

    @Override
    public ArrayList<String> getBlacklist() {
        if(this.getRegistryName().getPath().contains("asteroids") || getModId().equals("moreplanets")) {
            this.ores.add("aluminum");
        }
        else if(getModId().contains("extraplanets") || getModId().contains("galacticraft")) {
            if(this.getRegistryName().getPath().equals("venus_stone")) {
                this.ores.add("aluminum");
                this.ores.add("lead");
            }
            else {
                this.ores.add("copper");
                this.ores.add("tin");
            }
        }
        return this.ores;
    }
}
