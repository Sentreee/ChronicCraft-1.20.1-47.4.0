package net.sentree.chroniccraft.compat;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import net.minecraft.resources.ResourceLocation;
import net.sentree.chroniccraft.ChronicCraft;

@JeiPlugin
public class JEIChronicCraftPlugin implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(ChronicCraft.MOD_ID, "jei_plugin");
    }
}
