package stardust_binding.dimensional_ores.compat;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import stardust_binding.dimensional_ores.api.type.Stone;

public interface IModCompat {

    IBlockState getStone(Stone stone, IBlockState state);
}
