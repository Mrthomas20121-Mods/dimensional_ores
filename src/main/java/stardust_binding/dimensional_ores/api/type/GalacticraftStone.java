package stardust_binding.dimensional_ores.api.type;

import net.minecraft.block.state.IBlockState;
import stardust_binding.dimensional_ores.compat.GalacticraftCompat;

public class GalacticraftStone extends BasicStone {

    public GalacticraftStone(String stone_name, String modid, int dimension_id, String block_name) {
        super(stone_name, modid, dimension_id, block_name);
    }

    public GalacticraftStone(String stone_name, String modid, int dimension_id) {
        super(stone_name, modid, dimension_id);
    }

    @Override
    public IBlockState getBlockState() {
        return this.getStateWithProperties(super.getBlockState(), GalacticraftCompat.INSTANCE);
    }
}
