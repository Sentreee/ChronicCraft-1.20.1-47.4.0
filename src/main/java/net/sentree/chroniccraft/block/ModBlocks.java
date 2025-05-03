package net.sentree.chroniccraft.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sentree.chroniccraft.ChronicCraft;
import net.sentree.chroniccraft.block.custom.ChilliPChronicCropBlock;
import net.sentree.chroniccraft.block.custom.OGChronicCropBlock;
import net.sentree.chroniccraft.block.custom.PackingStationBlock;
import net.sentree.chroniccraft.block.custom.PurpleChronicCropBlock;
import net.sentree.chroniccraft.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
   public static final DeferredRegister<Block> BLOCKS =
           DeferredRegister.create(ForgeRegistries.BLOCKS, ChronicCraft.MOD_ID);

    public static final RegistryObject<Block> OG_CHRONIC_CROP = BLOCKS.register("og_chronic_crop",
                    () -> new OGChronicCropBlock(BlockBehaviour.Properties.copy(Blocks.BEETROOTS).sound(SoundType.SWEET_BERRY_BUSH).noCollission().noOcclusion()));
    public static final RegistryObject<Block> PURPLE_CHRONIC_CROP = BLOCKS.register("purple_chronic_crop",
            () -> new PurpleChronicCropBlock(BlockBehaviour.Properties.copy(Blocks.BEETROOTS).sound(SoundType.SWEET_BERRY_BUSH).noCollission().noOcclusion()));
    public static final RegistryObject<Block> CHILLI_P_CHRONIC_CROP = BLOCKS.register("chilli_p_chronic_crop",
            () -> new ChilliPChronicCropBlock(BlockBehaviour.Properties.copy(Blocks.BEETROOTS).sound(SoundType.SWEET_BERRY_BUSH).noCollission().noOcclusion()));

    public static final RegistryObject<Block> PACKING_STATION = registerBlock("packing_station",
            () -> new PackingStationBlock(BlockBehaviour.Properties.copy(Blocks.STONE).noOcclusion()));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
