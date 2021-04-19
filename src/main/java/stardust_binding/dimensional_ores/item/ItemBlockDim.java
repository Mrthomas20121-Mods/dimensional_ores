package stardust_binding.dimensional_ores.item;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import org.apache.commons.lang3.StringUtils;
import stardust_binding.dimensional_ores.ore.Stone;
import stardust_binding.dimensional_ores.block.OreBlock;
import stardust_binding.dimensional_ores.config.JsonMetal;

import javax.annotation.Nonnull;

public class ItemBlockDim extends ItemBlock {

    private final Stone stone;
    private final JsonMetal metal;

    public ItemBlockDim(OreBlock block) {
        super(block);

        this.stone = block.getStone();
        this.metal = block.getMetal();

        this.setRegistryName(block.getRegistryName());
        this.setTranslationKey(block.getTranslationKey());
    }

    public Stone getStone() {
        return stone;
    }

    public JsonMetal getMetal() {
        return metal;
    }

    @Nonnull
    public String getItemStackDisplayName(@Nonnull ItemStack stack)
    {
        return String.format("%s %s %s", StringUtils.capitalize(stone.getName()), StringUtils.capitalize(metal.getName()), "Ore");
    }
}
