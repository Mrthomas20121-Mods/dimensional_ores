package stardust_binding.dimensional_ores.compat;

import com.mjr.extraplanets.blocks.planetAndMoonBlocks.*;
import net.minecraft.block.state.*;

public enum ExtraPlanetCompat implements IModCompat {

    INSTANCE;

    @Override
    public IBlockState getStone(String stone, IBlockState state) {

        switch (stone) {
            case "io":
                state.withProperty(BlockBasicIo.BASIC_TYPE, BlockBasicIo.EnumBlockBasic.STONE);
            case "mercury":
                state.withProperty(BlockBasicMercury.BASIC_TYPE, BlockBasicMercury.EnumBlockBasic.STONE);
            case "ceres":
                state.withProperty(BlockBasicCeres.BASIC_TYPE, BlockBasicCeres.EnumBlockBasic.STONE);
            case "jupiter":
                state.withProperty(BlockBasicJupiter.BASIC_TYPE, BlockBasicJupiter.EnumBlockBasic.STONE);
            case "pluto":
                state.withProperty(BlockBasicPluto.BASIC_TYPE, BlockBasicPluto.EnumBlockBasic.STONE);
            case "eris":
                state.withProperty(BlockBasicEris.BASIC_TYPE, BlockBasicEris.EnumBlockBasic.STONE);
            case "kepler22b":
                state.withProperty(BlockBasicKepler22b.BASIC_TYPE, BlockBasicKepler22b.EnumBlockBasic.STONE);
            case "deimos":
                state.withProperty(BlockBasicDeimos.BASIC_TYPE, BlockBasicDeimos.EnumBlockBasic.STONE);
            case "ganymede":
                state.withProperty(BlockBasicGanymede.BASIC_TYPE, BlockBasicGanymede.EnumBlockBasic.STONE);
            case "titan":
                state.withProperty(BlockBasicTitan.BASIC_TYPE, BlockBasicTitan.EnumBlockBasic.STONE);
            case "titania":
                state.withProperty(BlockBasicTitania.BASIC_TYPE, BlockBasicTitania.EnumBlockBasic.STONE);
            case "saturn":
                state.withProperty(BlockBasicSaturn.BASIC_TYPE, BlockBasicSaturn.EnumBlockBasic.STONE);
            case "phobos":
                state.withProperty(BlockBasicPhobos.BASIC_TYPE, BlockBasicPhobos.EnumBlockBasic.STONE);
            case "triton":
                state.withProperty(BlockBasicTriton.BASIC_TYPE, BlockBasicTriton.EnumBlockBasic.STONE);
            case "rhea":
                state.withProperty(BlockBasicRhea.BASIC_TYPE, BlockBasicRhea.EnumBlockBasic.STONE);
            case "iapetus":
                state.withProperty(BlockBasicIapetus.BASIC_TYPE, BlockBasicIapetus.EnumBlockBasic.STONE);
            case "uranus":
                state.withProperty(BlockBasicUranus.BASIC_TYPE, BlockBasicUranus.EnumBlockBasic.STONE);
            case "neptune":
                state.withProperty(BlockBasicNeptune.BASIC_TYPE, BlockBasicNeptune.EnumBlockBasic.STONE);
            case "europa":
                state.withProperty(BlockBasicEuropa.BASIC_TYPE, BlockBasicEuropa.EnumBlockBasic.STONE);
            case "callisto":
                state.withProperty(BlockBasicCallisto.BASIC_TYPE, BlockBasicCallisto.EnumBlockBasic.STONE);
            case "oberon":
                state.withProperty(BlockBasicOberon.BASIC_TYPE, BlockBasicOberon.EnumBlockBasic.STONE);
            default:
                return state;
        }
    }
}
