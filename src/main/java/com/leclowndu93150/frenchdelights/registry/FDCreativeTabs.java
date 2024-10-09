package com.leclowndu93150.frenchdelights.registry;

import com.leclowndu93150.frenchdelights.FrenchDelightsMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class FDCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, FrenchDelightsMod.MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> FD_TAB = CREATIVE_MODE_TABS.register("frenchdelights_tab", () -> CreativeModeTab.builder()
            .title(Component.literal("French Delights"))
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(Items.BREAD::getDefaultInstance)
            .displayItems((parameters, output) -> {
                for (DeferredHolder<Item, ? extends Item> item : FDItems.ITEMS.getEntries()) {
                    output.accept(item.get());
                }
                for (DeferredHolder<Block, ? extends Block> item : FDBlocks.BLOCKS.getEntries()) {
                        output.accept(item.get());
                }
            }).build());


}
