package stardust_binding.dimensional_ores.ore;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;

public interface IModCompat {

    IBlockState getStone(Stone stone, Block block);
}
