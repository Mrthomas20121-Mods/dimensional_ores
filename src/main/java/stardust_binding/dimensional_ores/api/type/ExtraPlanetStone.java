package stardust_binding.dimensional_ores.api.type;

import net.minecraft.block.state.IBlockState;
import stardust_binding.dimensional_ores.compat.ExtraPlanetCompat;

/**
 * Support for Extra Planet Stones
 */
public class ExtraPlanetStone extends GalacticraftStone {

    public ExtraPlanetStone(String stone_name, String modid, int dimension_id, String block_name) {
        super(stone_name, modid, dimension_id, block_name);
    }

    public ExtraPlanetStone(String stone_name, String modid, int dimension_id) {
        super(stone_name, modid, dimension_id);
    }

    @Override
    public IBlockState getBlockState() {
        return this.getStateWithProperties(super.getBlockState(), ExtraPlanetCompat.INSTANCE);
    }
}
