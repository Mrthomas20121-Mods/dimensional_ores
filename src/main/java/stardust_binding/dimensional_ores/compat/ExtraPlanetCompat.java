package stardust_binding.dimensional_ores.compat;

import com.mjr.extraplanets.blocks.planetAndMoonBlocks.*;
import net.minecraft.block.Block;
import net.minecraft.block.state.*;
import stardust_binding.dimensional_ores.ore.IModCompat;
import stardust_binding.dimensional_ores.ore.Stone;

public enum ExtraPlanetCompat implements IModCompat {

    INSTANCE;

    @Override
    public IBlockState getStone(Stone stone, Block block) {
        IBlockState state = block.getDefaultState();

        switch (stone) {
            case IO_STONE:
                return state.withProperty(BlockBasicIo.BASIC_TYPE, BlockBasicIo.EnumBlockBasic.STONE);
            case DEIMOS_STONE:
                return state.withProperty(BlockBasicDeimos.BASIC_TYPE, BlockBasicDeimos.EnumBlockBasic.STONE);
            case EUROPA_STONE:
                return state.withProperty(BlockBasicEuropa.BASIC_TYPE, BlockBasicEuropa.EnumBlockBasic.STONE);
            case OBERON_STONE:
                return state.withProperty(BlockBasicOberon.BASIC_TYPE, BlockBasicOberon.EnumBlockBasic.STONE);
            case PHOBOS_STONE:
                return state.withProperty(BlockBasicPhobos.BASIC_TYPE, BlockBasicPhobos.EnumBlockBasic.STONE);
            case SATURN_STONE:
                return state.withProperty(BlockBasicSaturn.BASIC_TYPE, BlockBasicSaturn.EnumBlockBasic.STONE);
            case TRITON_STONE:
                return state.withProperty(BlockBasicTriton.BASIC_TYPE, BlockBasicTriton.EnumBlockBasic.STONE);
            case IAPETUS_STONE:
                return state.withProperty(BlockBasicIapetus.BASIC_TYPE, BlockBasicIapetus.EnumBlockBasic.STONE);
            case JUPITER_STONE:
                return state.withProperty(BlockBasicJupiter.BASIC_TYPE, BlockBasicJupiter.EnumBlockBasic.STONE);
            case TITANIA_STONE:
                return state.withProperty(BlockBasicTitania.BASIC_TYPE, BlockBasicTitania.EnumBlockBasic.STONE);
            case CALLISTO_STONE:
                return state.withProperty(BlockBasicCallisto.BASIC_TYPE, BlockBasicCallisto.EnumBlockBasic.STONE);
            case GANYMEDE_STONE:
                return state.withProperty(BlockBasicGanymede.BASIC_TYPE, BlockBasicGanymede.EnumBlockBasic.STONE);
            default:
                return state;
        }
    }
}
