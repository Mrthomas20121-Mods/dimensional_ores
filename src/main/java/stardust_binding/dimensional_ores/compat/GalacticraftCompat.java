package stardust_binding.dimensional_ores.compat;

import micdoodle8.mods.galacticraft.core.blocks.BlockBasicMoon;
import micdoodle8.mods.galacticraft.planets.asteroids.blocks.BlockBasicAsteroids;
import micdoodle8.mods.galacticraft.planets.mars.blocks.BlockBasicMars;
import micdoodle8.mods.galacticraft.planets.venus.blocks.BlockBasicVenus;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import stardust_binding.dimensional_ores.api.type.Stone;

public enum GalacticraftCompat implements IModCompat {

    INSTANCE;

    @Override
    public IBlockState getStone(Stone stone, IBlockState state) {

        switch (stone.getName()) {
            case "moon_rock":
                return state.withProperty(BlockBasicMoon.BASIC_TYPE_MOON, BlockBasicMoon.EnumBlockBasicMoon.MOON_STONE);
            case "mars_stone":
                return state.withProperty(BlockBasicMars.BASIC_TYPE, BlockBasicMars.EnumBlockBasic.MARS_STONE);
            case "asteroids_rock":
                return state.withProperty(BlockBasicAsteroids.BASIC_TYPE, BlockBasicAsteroids.EnumBlockBasic.ASTEROID_0);
            case "venus_stone":
                return state.withProperty(BlockBasicVenus.BASIC_TYPE_VENUS, BlockBasicVenus.EnumBlockBasicVenus.ROCK_HARD);
            default:
                return state;
        }
    }
}
