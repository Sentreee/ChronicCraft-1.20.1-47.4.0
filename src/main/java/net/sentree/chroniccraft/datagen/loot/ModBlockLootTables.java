package net.sentree.chroniccraft.datagen.loot;

import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraftforge.registries.RegistryObject;
import net.sentree.chroniccraft.block.ModBlocks;
import net.sentree.chroniccraft.block.custom.ChilliPChronicCropBlock;
import net.sentree.chroniccraft.block.custom.OGChronicCropBlock;
import net.sentree.chroniccraft.block.custom.PurpleChronicCropBlock;
import net.sentree.chroniccraft.item.ModItems;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {

        this.dropSelf(ModBlocks.PACKING_STATION.get());

        LootItemCondition.Builder ogchronic$builder = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.OG_CHRONIC_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(OGChronicCropBlock.AGE, 7));

        this.add(ModBlocks.OG_CHRONIC_CROP.get(), createConditionalDropWithRareSeeds(
                ModItems.OG_CHRONIC.get(), ModItems.OG_CHRONIC_SEED.get(), ogchronic$builder));

        LootItemCondition.Builder purplechronic$builder = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.PURPLE_CHRONIC_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(PurpleChronicCropBlock.AGE, 7));

        this.add(ModBlocks.PURPLE_CHRONIC_CROP.get(), createConditionalDropWithRareSeeds(
                ModItems.PURPLE_CHRONIC.get(), ModItems.PURPLE_CHRONIC_SEED.get(), purplechronic$builder));

        LootItemCondition.Builder chillipchronic$builder = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.CHILLI_P_CHRONIC_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(ChilliPChronicCropBlock.AGE, 7));

        this.add(ModBlocks.CHILLI_P_CHRONIC_CROP.get(), createConditionalDropWithRareSeeds(
                ModItems.CHILLI_P_CHRONIC.get(), ModItems.CHILLI_P_CHRONIC_SEED.get(), chillipchronic$builder));

    }

    private LootTable.Builder createConditionalDrop(ItemLike drop, LootItemCondition.Builder condition) {
        return LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .add(LootItem.lootTableItem(drop)
                                .when(condition))
                        .setRolls(ConstantValue.exactly(1)));
    }

    private LootTable.Builder createConditionalDropWithRareSeeds(ItemLike cropItem, ItemLike seedItem, LootItemCondition.Builder matureCondition) {
        return LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .add(LootItem.lootTableItem(cropItem)
                                .when(matureCondition))
                        .setRolls(ConstantValue.exactly(3)))
                .withPool(LootPool.lootPool()
                        .add(LootItem.lootTableItem(seedItem)
                                .when(matureCondition)
                                .when(LootItemRandomChanceCondition.randomChance(1f))) // 10% chance
                        .setRolls(ConstantValue.exactly(1)));
    }



    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
