package com.leclowndu93150.frenchdelights.datagen;

import com.leclowndu93150.frenchdelights.FrenchDelightsMod;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
@EventBusSubscriber(modid = FrenchDelightsMod.MODID, bus = EventBusSubscriber.Bus.MOD)
public class DataGatherer {
    @SubscribeEvent
    public static void onGatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        generator.addProvider(event.includeServer(), new RecipesProvider(output, lookupProvider));
        BlockTagProvider blockTagProvider = new BlockTagProvider(output, lookupProvider, existingFileHelper);
        generator.addProvider(event.includeClient(), blockTagProvider);
        generator.addProvider(event.includeClient(), new ItemTagProvider(output, lookupProvider, blockTagProvider.contentsGetter()));
        generator.addProvider(event.includeClient(), new ItemModelProvider(output, existingFileHelper));
        generator.addProvider(event.includeClient(), new BlockModelProvider(output, existingFileHelper));
        generator.addProvider(event.includeServer(), new LootTableProvider(output, Collections.emptySet(), List.of(
                new LootTableProvider.SubProviderEntry(BlockLootTableProvider::new, LootContextParamSets.BLOCK)
        ), lookupProvider));
        generator.addProvider(event.includeClient(), new EnUsProvider(output));
    }
}