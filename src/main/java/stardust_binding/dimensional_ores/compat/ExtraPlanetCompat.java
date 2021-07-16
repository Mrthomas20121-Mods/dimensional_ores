package stardust_binding.dimensional_ores.compat;

import com.mjr.extraplanets.blocks.planetAndMoonBlocks.*;
import net.minecraft.block.state.*;

public enum ExtraPlanetCompat implements IModCompat {

    INSTANCE;

    @Override
    public IBlockState getStone(String stone, IBlockState state) {

        switch (stone) {
            case "io_stone":
                return state.withProperty(BlockBasicIo.BASIC_TYPE, BlockBasicIo.EnumBlockBasic.STONE);
            case "deimos_stone":
                return state.withProperty(BlockBasicDeimos.BASIC_TYPE, BlockBasicDeimos.EnumBlockBasic.STONE);
            case "europa_stone":
                return state.withProperty(BlockBasicEuropa.BASIC_TYPE, BlockBasicEuropa.EnumBlockBasic.STONE);
            case "oberon_stone":
                return state.withProperty(BlockBasicOberon.BASIC_TYPE, BlockBasicOberon.EnumBlockBasic.STONE);
            case "phobos_stone":
                return state.withProperty(BlockBasicPhobos.BASIC_TYPE, BlockBasicPhobos.EnumBlockBasic.STONE);
            case "saturn_stone":
                return state.withProperty(BlockBasicSaturn.BASIC_TYPE, BlockBasicSaturn.EnumBlockBasic.STONE);
            case "triton_stone":
                return state.withProperty(BlockBasicTriton.BASIC_TYPE, BlockBasicTriton.EnumBlockBasic.STONE);
            case "iapetus_stone":
                return state.withProperty(BlockBasicIapetus.BASIC_TYPE, BlockBasicIapetus.EnumBlockBasic.STONE);
            case "jupiter_stone":
                return state.withProperty(BlockBasicJupiter.BASIC_TYPE, BlockBasicJupiter.EnumBlockBasic.STONE);
            case "titania_stone":
                return state.withProperty(BlockBasicTitania.BASIC_TYPE, BlockBasicTitania.EnumBlockBasic.STONE);
            case "callisto_stone":
                return state.withProperty(BlockBasicCallisto.BASIC_TYPE, BlockBasicCallisto.EnumBlockBasic.STONE);
            case "ganymede_stone":
                return state.withProperty(BlockBasicGanymede.BASIC_TYPE, BlockBasicGanymede.EnumBlockBasic.STONE);
            case "mercury_stone":
                return state.withProperty(BlockBasicMercury.BASIC_TYPE, BlockBasicMercury.EnumBlockBasic.STONE);
            case "neptune_stone":
                return state.withProperty(BlockBasicNeptune.BASIC_TYPE, BlockBasicNeptune.EnumBlockBasic.STONE);
            case "kepler22b_stone":
                return state.withProperty(BlockBasicKepler22b.BASIC_TYPE, BlockBasicKepler22b.EnumBlockBasic.STONE);
            case "ceres_stone":
                return state.withProperty(BlockBasicCeres.BASIC_TYPE, BlockBasicCeres.EnumBlockBasic.STONE);
            case "eris_stone":
                return state.withProperty(BlockBasicEris.BASIC_TYPE, BlockBasicEris.EnumBlockBasic.STONE);
            case "uranus":
                return state.withProperty(BlockBasicUranus.BASIC_TYPE, BlockBasicUranus.EnumBlockBasic.STONE);
            case "titan":
                return state.withProperty(BlockBasicTitan.BASIC_TYPE, BlockBasicTitan.EnumBlockBasic.STONE);
            default:
                return state;
        }
    }
}
