package com.leclowndu93150.frenchdelights;

import com.leclowndu93150.frenchdelights.registry.FDBlocks;
import com.leclowndu93150.frenchdelights.registry.FDCreativeTabs;
import com.leclowndu93150.frenchdelights.registry.FDItems;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;

@Mod(FrenchDelightsMod.MODID)
public class FrenchDelightsMod
{
    public static final String MODID = "frenchdelights";
    private static final Logger LOGGER = LogUtils.getLogger();

    public FrenchDelightsMod(IEventBus modEventBus, ModContainer modContainer) {
        FDCreativeTabs.CREATIVE_MODE_TABS.register(modEventBus);
        FDItems.ITEMS.register(modEventBus);
        FDBlocks.BLOCKS.register(modEventBus);
    }

}
