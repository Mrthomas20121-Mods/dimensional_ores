package stardust_binding.dimensional_ores;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;
import stardust_binding.dimensional_ores.block.OreBlock;
import stardust_binding.dimensional_ores.config.Json;
import stardust_binding.dimensional_ores.config.OreProperties;
import stardust_binding.dimensional_ores.item.ItemBlockDim;
import stardust_binding.dimensional_ores.ore.Stone;

import javax.annotation.Nonnull;
import java.util.ArrayList;

@Mod.EventBusSubscriber(modid = DimensionalOres.MODID)
public class RegistryHandler {


    private static CreativeTabs tab = new CreativeTabs("dim_ores") {

        @Nonnull
        @Override
        public ItemStack createIcon() {
            return new ItemStack(Blocks.STONE);
        }
    };

    private static ArrayList<OreBlock> ores = new ArrayList<>();

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        for(OreBlock oreBlock: ores) {
            event.getRegistry().register(new ItemBlockDim(oreBlock));
        }
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        for(OreProperties metal: Json.metals) {
            for(Stone stone: Stone.values()) {
                if(stone.getBlacklist().contains(metal.getName())) continue;
                if(stone.canLoad()) {
                    register(new OreBlock(metal, stone), event.getRegistry());
                }
            }
        }
    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        for(OreBlock oreBlock: ores) {
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(oreBlock), 0, new ModelResourceLocation(oreBlock.getRegistryName(), "normal"));
        }
    }

    private static void register(OreBlock block, IForgeRegistry<Block> r) {
        block.setCreativeTab(tab);
        r.register(block);
        ores.add(block);
    }
}
