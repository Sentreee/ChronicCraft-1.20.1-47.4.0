package net.sentree.chroniccraft.block.entity;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sentree.chroniccraft.ChronicCraft;
import net.sentree.chroniccraft.block.ModBlocks;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, ChronicCraft.MOD_ID);

    public static final RegistryObject<BlockEntityType<PackingStationBlockEntity>> PACKING_BE =
            BLOCK_ENTITIES.register("packing_be", () ->
                    BlockEntityType.Builder.of(PackingStationBlockEntity::new,
                            ModBlocks.PACKING_STATION.get()).build(null));

    public static final RegistryObject<BlockEntityType<PackingStationBlockEntity>> ROLLING_BE =
            BLOCK_ENTITIES.register("rolling_be", () ->
                    BlockEntityType.Builder.of(PackingStationBlockEntity::new,
                            ModBlocks.ROLLING_STATION.get()).build(null));


    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
