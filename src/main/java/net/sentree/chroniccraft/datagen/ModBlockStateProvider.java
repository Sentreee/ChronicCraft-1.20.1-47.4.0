package net.sentree.chroniccraft.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.sentree.chroniccraft.ChronicCraft;
import net.sentree.chroniccraft.block.ModBlocks;
import net.sentree.chroniccraft.block.custom.ChilliPChronicCropBlock;
import net.sentree.chroniccraft.block.custom.OGChronicCropBlock;
import net.sentree.chroniccraft.block.custom.PurpleChronicCropBlock;

import java.util.function.Function;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, ChronicCraft.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        makeOGChronicCrop((CropBlock) ModBlocks.OG_CHRONIC_CROP.get(), "og_chronic_stage", "og_chronic_stage");
        makePurpleChronicCrop((CropBlock) ModBlocks.PURPLE_CHRONIC_CROP.get(), "purple_chronic_stage", "purple_chronic_stage");
        makeChilliPChronicCrop((CropBlock) ModBlocks.CHILLI_P_CHRONIC_CROP.get(), "chilli_p_chronic_stage", "chilli_p_chronic_stage");
    }

    public void makeOGChronicCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> og = state -> ogchronicStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(og);
    }

    public void makePurpleChronicCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> purple = state -> purplechronicStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(purple);
    }

    public void makeChilliPChronicCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> chillip = state -> chillipchronicStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(chillip);
    }
    private ConfiguredModel[] ogchronicStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((OGChronicCropBlock) block).getAgeProperty()),
                new ResourceLocation(ChronicCraft.MOD_ID, "block/" + textureName + state.getValue(((OGChronicCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }
    private ConfiguredModel[] purplechronicStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((PurpleChronicCropBlock) block).getAgeProperty()),
                new ResourceLocation(ChronicCraft.MOD_ID, "block/" + textureName + state.getValue(((PurpleChronicCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }
    private ConfiguredModel[] chillipchronicStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((ChilliPChronicCropBlock) block).getAgeProperty()),
                new ResourceLocation(ChronicCraft.MOD_ID, "block/" + textureName + state.getValue(((ChilliPChronicCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }



    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
