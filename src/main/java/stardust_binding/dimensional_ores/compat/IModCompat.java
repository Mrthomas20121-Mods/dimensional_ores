package stardust_binding.dimensional_ores.compat;

import net.minecraft.block.state.IBlockState;

public interface IModCompat {

    IBlockState getStone(String stone, IBlockState state);
}
