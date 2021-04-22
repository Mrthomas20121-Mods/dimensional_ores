package stardust_binding.dimensional_ores.api.type;

import com.google.common.base.Predicate;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistryEntry;
import stardust_binding.dimensional_ores.DimensionalOres;
import stardust_binding.dimensional_ores.compat.GalacticraftCompat;

import javax.annotation.Nonnull;
import java.util.ArrayList;

public abstract class Stone extends IForgeRegistryEntry.Impl<Stone> implements IStringSerializable {

    private final int dimension_id;
    private final String modid;
    private final String block_name;
    protected ArrayList<String> ores = new ArrayList<>();

    public Stone(String stone_name, String modid, int dimension_id, String block_name) {
        this.setRegistryName(new ResourceLocation(DimensionalOres.MODID, stone_name));
        this.modid = modid;
        this.dimension_id = dimension_id;
        this.block_name = block_name;
    }

    public Stone(String stone_name, String modid, int dimension_id) {
        this(stone_name, modid, dimension_id, modid.equals("extraplanets") ? stone_name.split("_")[0]:stone_name );
    }

    public String getModId() {
        return this.modid;
    }

    public boolean isModLoaded() {
        return Loader.isModLoaded(this.modid);
    }

    public Predicate<IBlockState> getPredicate() {
        return state -> state.equals(this.getBlockState());
    }

    public int getDimensionId() {
        return dimension_id;
    }

    public String getBlockName() {
        return block_name;
    }

    protected IBlockState getBlockState() {
        Block block = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(this.getModId(), this.getBlockName()));
        if(getModId().toLowerCase().contains("galacticraft")) {
            return GalacticraftCompat.INSTANCE.getStone(null, block);
        }
        return block.getDefaultState();
    }

    @Nonnull
    @Override
    public String getName() {
        return this.getRegistryName().getPath();
    }

    public abstract ArrayList<String> getBlacklist();
}
