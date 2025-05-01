package net.sentree.chroniccraft.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.sentree.chroniccraft.ChronicCraft;
import net.sentree.chroniccraft.item.ModItems;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ChronicCraft.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.OG_CHRONIC);
        simpleItem(ModItems.PURPLE_CHRONIC);
        simpleItem(ModItems.CHILLI_P_CHRONIC);

        simpleItem(ModItems.OG_CHRONIC_SEED);
        simpleItem(ModItems.PURPLE_CHRONIC_SEED);
        simpleItem(ModItems.CHILLI_P_CHRONIC_SEED);

        simpleItem(ModItems.BAGGED_OG_CHRONIC);
        simpleItem(ModItems.BAGGED_PURPLE_CHRONIC);
        simpleItem(ModItems.BAGGED_CHILLI_P_CHRONIC);

        simpleItem(ModItems.ROLLED_OG_CHRONIC);
        simpleItem(ModItems.ROLLED_PURPLE_CHRONIC);
        simpleItem(ModItems.ROLLED_CHILLI_P_CHRONIC);

        simpleItem(ModItems.BAGGIE);

    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(ChronicCraft.MOD_ID,"item/" + item.getId().getPath()));
    }
}
