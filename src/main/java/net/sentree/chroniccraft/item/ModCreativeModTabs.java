package net.sentree.chroniccraft.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.sentree.chroniccraft.ChronicCraft;
import net.sentree.chroniccraft.block.ModBlocks;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ChronicCraft.MOD_ID);

    public static final RegistryObject<CreativeModeTab> CHRONIC_TAB = CREATIVE_MODE_TABS.register("chronic_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.OG_CHRONIC.get()))
                    .title(Component.translatable("creativetab.chronic_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.OG_CHRONIC.get());
                        pOutput.accept(ModItems.PURPLE_CHRONIC.get());
                        pOutput.accept(ModItems.CHILLI_P_CHRONIC.get());

                        pOutput.accept(ModItems.OG_CHRONIC_SEED.get());
                        pOutput.accept(ModItems.PURPLE_CHRONIC_SEED.get());
                        pOutput.accept(ModItems.CHILLI_P_CHRONIC_SEED.get());

                        pOutput.accept(ModItems.BAGGED_OG_CHRONIC.get());
                        pOutput.accept(ModItems.BAGGED_PURPLE_CHRONIC.get());
                        pOutput.accept(ModItems.BAGGED_CHILLI_P_CHRONIC.get());

                        pOutput.accept(ModItems.ROLLED_OG_CHRONIC.get());
                        pOutput.accept(ModItems.ROLLED_PURPLE_CHRONIC.get());
                        pOutput.accept(ModItems.ROLLED_CHILLI_P_CHRONIC.get());

                        pOutput.accept(ModBlocks.PACKING_STATION.get());

                        pOutput.accept(ModItems.BAGGIE.get());
                        pOutput.accept(ModItems.ROLLING_PAPER.get());

                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
