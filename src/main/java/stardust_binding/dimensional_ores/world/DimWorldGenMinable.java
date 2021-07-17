package stardust_binding.dimensional_ores.world;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import javax.annotation.Nonnull;
import java.util.Random;
import java.util.function.Predicate;

public class DimWorldGenMinable extends WorldGenerator {

    private final IBlockState oreBlock;
    private final Predicate<IBlockState> stone;
    private final int blockCount;

    public DimWorldGenMinable(IBlockState block, Predicate<IBlockState> stone, int blockCount) {
        this.oreBlock = block;
        this.stone = stone;
        this.blockCount = blockCount;

    }

    public boolean generate(@Nonnull World worldIn, @Nonnull Random rand, @Nonnull BlockPos position) {
        float f = rand.nextFloat() * (float) Math.PI;
        double d0 = ((float) (position.getX() + 8) + MathHelper.sin(f) * (float) this.blockCount / 8.0F);
        double d1 = ((float) (position.getX() + 8) - MathHelper.sin(f) * (float) this.blockCount / 8.0F);
        double d2 = ((float) (position.getZ() + 8) + MathHelper.cos(f) * (float) this.blockCount / 8.0F);
        double d3 = ((float) (position.getZ() + 8) - MathHelper.cos(f) * (float) this.blockCount / 8.0F);
        double d4 = (position.getY() + rand.nextInt(3) - 2);
        double d5 = (position.getY() + rand.nextInt(3) - 2);

        for (int i = 0; i < this.blockCount; ++i) {
            float f1 = (float) i / (float) this.blockCount;
            double d6 = d0 + (d1 - d0) * (double) f1;
            double d7 = d4 + (d5 - d4) * (double) f1;
            double d8 = d2 + (d3 - d2) * (double) f1;
            double d9 = rand.nextDouble() * (double) this.blockCount / 16.0D;
            double d10 = (double) (MathHelper.sin((float) Math.PI * f1) + 1.0F) * d9 + 1.0D;
            double d11 = (double) (MathHelper.sin((float) Math.PI * f1) + 1.0F) * d9 + 1.0D;
            int j = MathHelper.floor(d6 - d10 / 2.0D);
            int k = MathHelper.floor(d7 - d11 / 2.0D);
            int l = MathHelper.floor(d8 - d10 / 2.0D);
            int i1 = MathHelper.floor(d6 + d10 / 2.0D);
            int j1 = MathHelper.floor(d7 + d11 / 2.0D);
            int k1 = MathHelper.floor(d8 + d10 / 2.0D);

            for (int l1 = j; l1 <= i1; ++l1) {
                double d12 = ((double) l1 + 0.5D - d6) / (d10 / 2.0D);

                if (d12 * d12 < 1.0D) {
                    for (int i2 = k; i2 <= j1; ++i2) {
                        double d13 = ((double) i2 + 0.5D - d7) / (d11 / 2.0D);

                        if (d12 * d12 + d13 * d13 < 1.0D) {
                            for (int j2 = l; j2 <= k1; ++j2) {
                                double d14 = ((double) j2 + 0.5D - d8) / (d10 / 2.0D);

                                if (d12 * d12 + d13 * d13 + d14 * d14 < 1.0D) {
                                    BlockPos blockpos = new BlockPos(l1, i2, j2);

                                    IBlockState state = worldIn.getBlockState(blockpos);
                                    if (this.stone.test(state)) {
                                        worldIn.setBlockState(blockpos, this.oreBlock, 2);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
