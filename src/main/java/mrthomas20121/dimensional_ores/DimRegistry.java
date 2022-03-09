package mrthomas20121.dimensional_ores;

import mrthomas20121.dimensional_ores.api.Stone;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;

@Mod.EventBusSubscriber(modid = DimensionalOres.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DimRegistry {

    public static DeferredRegister<Block> BLOCKS = DeferredRegister.create(Block.class, DimensionalOres.MOD_ID);
    public static DeferredRegister<Item> ITEMS = DeferredRegister.create(Item.class, DimensionalOres.MOD_ID);

    public static Stone lunar_stone = new Stone("lunar_stone", "blue_skies");
    public static Stone turquoise_stone = new Stone("turquoise_stone", "blue_skies");
    public static Stone limestone = new Stone("limestone", "atum");

    public static Item registerItem(Block block) {
        return new BlockItem(block, new Item.Properties().tab(ItemGroup.TAB_DECORATIONS));
    }

    public static Block registerBlock() {
        return new Block(AbstractBlock.Properties.copy(Blocks.IRON_ORE));
    }
}
