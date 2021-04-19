package stardust_binding.dimensional_ores.world;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;
import stardust_binding.dimensional_ores.ore.Stone;
import stardust_binding.dimensional_ores.block.OreBlock;
import stardust_binding.dimensional_ores.config.Json;
import stardust_binding.dimensional_ores.config.JsonMetal;

import java.util.Random;

public class WorldGenOre implements IWorldGenerator {

    @Override
    public void generate(Random rng, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
    {
        for(JsonMetal metal: Json.metals) {
            for(Stone stone: Stone.values()) {
                if(!metal.isEnabled()) continue;
                if(world.provider.getDimension() ==  stone.getDimensionID() && metal.containDimension(stone.getDimensionID())) {
                    final BlockPos chunkPos = new BlockPos(chunkX << 4, 0, chunkZ << 4);
                    Biome biome = world.provider.getBiomeProvider().getBiome(chunkPos);
                    WorldGenMinable minable = new WorldGenMinable(OreBlock.get(metal, stone).getDefaultState(), 12, stone.get());
                    if(metal.containBiome(biome.getRegistryName().toString())) {
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