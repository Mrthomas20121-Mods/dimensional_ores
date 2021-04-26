package stardust_binding.dimensional_ores.item;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextComponentTranslation;
import org.apache.commons.lang3.StringUtils;
import stardust_binding.dimensional_ores.api.type.Ore;
import stardust_binding.dimensional_ores.api.type.Stone;
import stardust_binding.dimensional_ores.block.OreBlock;
import stardust_binding.dimensional_ores.config.OreProperties;

import javax.annotation.Nonnull;

public class ItemBlockDim extends ItemBlock {

    private final Stone stone;
    private final Ore ore;
    private final OreProperties properties;

    public ItemBlockDim(OreBlock block) {
        super(block);

        this.stone = block.getStone();
        this.ore = block.getOre();
        this.properties = block.getOreProperties();

        this.setRegistryName(block.getRegistryName());
        this.setTranslationKey(block.getTranslationKey());
    }

    public Stone getStone() {
        return stone;
    }

    public Ore getOre() {
        return ore;
    }

    public OreProperties getOreProperties() {
        return properties;
    }

    @Nonnull
    public String getItemStackDisplayName(@Nonnull ItemStack stack)
    {
        return String.format("%s %s %s", new TextComponentTranslation(stone.getTranslationKey()).getFormattedText(), new TextComponentTranslation(ore.getTranslationKey()).getFormattedText(), "Ore");
    }

    /**
     * Capitalize String
     */
    private String cap(String str)
    {
        if(str.contains("_")) {
            String[] array = str.split("_");
            StringBuilder s = new StringBuilder();
            for(String string: array)
            {
                s.append(StringUtils.capitalize(string));
                s.append(" ");
            }
            return s.toString().substring(0, s.length()-1);
        }
        return StringUtils.capitalize(str);
    }
}
