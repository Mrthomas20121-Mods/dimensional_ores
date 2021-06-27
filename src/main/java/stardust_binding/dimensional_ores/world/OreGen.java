package stardust_binding.dimensional_ores.world;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;
import stardust_binding.dimensional_ores.api.registry.Registries;
import stardust_binding.dimensional_ores.api.type.Ore;
import stardust_binding.dimensional_ores.api.type.Stone;
import stardust_binding.dimensional_ores.config.OreConfig;

import javax.annotation.Nonnull;
import java.util.Random;

public class OreGen implements IWorldGenerator {

    private void generateOre(IBlockState ore, com.google.common.base.Predicate<IBlockState> stone, World world, @Nonnull Random random, int x, int z, int minY, int maxY, int size, int numberToGenerate) {
        for (int i = 0; i < numberToGenerate; i++) {
            BlockPos pos = new BlockPos(x * 16 + random.nextInt(16), random.nextInt(maxY - minY) + minY, z * 16 + random.nextInt(16));
            DimWorldGenMinable generator = new DimWorldGenMinable(ore, stone, size);
            generator.generate(world, random, pos);
        }
    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        for(Stone stone: Registries.getStoneRegistry().getValuesCollection()) {
            for(Ore ore: Registries.getOreRegistry().getValuesCollection()) {
                OreConfig properties = OreConfig.getOreData(stone, ore);
                if(!properties.isEnabled()) continue;
                if(world.provider.getDimension() ==  stone.getDimensionId()) {
                    //this.generateOre(OreBlock.get(ore, stone).getDefaultState(), stone.getPredicate(), world, random, chunkX, chunkZ, );
                }
            }
        }
    }
}
