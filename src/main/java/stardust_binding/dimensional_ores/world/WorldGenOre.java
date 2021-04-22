package stardust_binding.dimensional_ores.world;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;
import stardust_binding.dimensional_ores.api.registry.Registries;
import stardust_binding.dimensional_ores.api.type.Ore;
import stardust_binding.dimensional_ores.api.type.Stone;
import stardust_binding.dimensional_ores.block.OreBlock;
import stardust_binding.dimensional_ores.config.Json;
import stardust_binding.dimensional_ores.config.OreProperties;

import java.util.Random;

public class WorldGenOre implements IWorldGenerator {

    @Override
    public void generate(Random rng, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
    {
        for(Ore ore: Registries.getOreRegistry().getValuesCollection()) {
            OreProperties properties = OreProperties.get(ore.getName());
            for(Stone stone: Registries.getStoneRegistry().getValuesCollection()) {
                if(!properties.isEnabled()) continue;
                if(world.provider.getDimension() ==  stone.getDimensionId() && properties.containDimension(stone.getDimensionId())) {
                    final BlockPos chunkPos = new BlockPos(chunkX << 4, 0, chunkZ << 4);
                    Biome biome = world.provider.getBiomeProvider().getBiome(chunkPos);
                    WorldGenMinable minable = new WorldGenMinable(OreBlock.get(ore, stone).getDefaultState(), 12, stone.getPredicate());
                    if(properties.containBiome(biome.getRegistryName().toString()) || properties.getBiomes().length == 0) {
                        this.spawn(world, rng, chunkPos, minable, 8);
                    }
                }
            }
        }

    }

    private void spawn(World world, Random rng, BlockPos chunkPos, WorldGenMinable gen, int ore_count)
    {
        for (int count = 0; count < ore_count; count++)
        {
            gen.generate(world, rng, chunkPos.add(rng.nextInt(16), rng.nextInt(128), rng.nextInt(16)));
        }
    }
}