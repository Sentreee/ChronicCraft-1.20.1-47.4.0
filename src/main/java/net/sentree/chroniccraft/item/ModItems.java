package net.sentree.chroniccraft.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sentree.chroniccraft.ChronicCraft;
import net.sentree.chroniccraft.block.ModBlocks;
import net.sentree.chroniccraft.item.custom.ChilliPChronicRollItem;
import net.sentree.chroniccraft.item.custom.OGChronicRollItem;
import net.sentree.chroniccraft.item.custom.PurpleChronicRollItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ChronicCraft.MOD_ID);

    public static final RegistryObject<Item> OG_CHRONIC = ITEMS.register("og_chronic",
            () -> new Item(new Item.Properties().stacksTo(20)));
    public static final RegistryObject<Item> PURPLE_CHRONIC = ITEMS.register("purple_chronic",
            () -> new Item(new Item.Properties().stacksTo(20)));
    public static final RegistryObject<Item> CHILLI_P_CHRONIC = ITEMS.register("chilli_p_chronic",
            () -> new Item(new Item.Properties().stacksTo(20)));

    public static final RegistryObject<Item> BAGGIE = ITEMS.register("baggie",
            () -> new Item(new Item.Properties().stacksTo(20)));

    public static final RegistryObject<Item> ROLLING_PAPER = ITEMS.register("rolling_paper",
            () -> new Item(new Item.Properties().stacksTo(20)));

    public static final RegistryObject<Item> BAGGED_OG_CHRONIC = ITEMS.register("bagged_og_chronic",
            () -> new Item(new Item.Properties().stacksTo(20)));
    public static final RegistryObject<Item> BAGGED_PURPLE_CHRONIC = ITEMS.register("bagged_purple_chronic",
            () -> new Item(new Item.Properties().stacksTo(20)));
    public static final RegistryObject<Item> BAGGED_CHILLI_P_CHRONIC = ITEMS.register("bagged_chilli_p_chronic",
            () -> new Item(new Item.Properties().stacksTo(20)));

    public static final RegistryObject<Item> ROLLED_OG_CHRONIC = ITEMS.register("rolled_og_chronic",
            () -> new OGChronicRollItem(new Item.Properties().stacksTo(20)));
    public static final RegistryObject<Item> ROLLED_PURPLE_CHRONIC = ITEMS.register("rolled_purple_chronic",
            () -> new PurpleChronicRollItem(new Item.Properties().stacksTo(20)));
    public static final RegistryObject<Item> ROLLED_CHILLI_P_CHRONIC = ITEMS.register("rolled_chilli_p_chronic",
            () -> new ChilliPChronicRollItem(new Item.Properties().stacksTo(20)));

    public static final RegistryObject<Item> OG_CHRONIC_SEED = ITEMS.register("og_chronic_seed",
            () -> new ItemNameBlockItem(ModBlocks.OG_CHRONIC_CROP.get(), new Item.Properties().stacksTo(20)));
    public static final RegistryObject<Item> PURPLE_CHRONIC_SEED = ITEMS.register("purple_chronic_seed",
            () -> new ItemNameBlockItem(ModBlocks.PURPLE_CHRONIC_CROP.get(), new Item.Properties().stacksTo(20)));
    public static final RegistryObject<Item> CHILLI_P_CHRONIC_SEED = ITEMS.register("chilli_p_chronic_seed",
            () -> new ItemNameBlockItem(ModBlocks.CHILLI_P_CHRONIC_CROP.get(), new Item.Properties().stacksTo(20)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
