package com.leclowndu93150.frenchdelights.datagen;

import com.leclowndu93150.frenchdelights.FrenchDelightsMod;
import com.leclowndu93150.frenchdelights.registry.FDItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.Objects;
import java.util.function.Supplier;

public class ItemModelProvider extends net.neoforged.neoforge.client.model.generators.ItemModelProvider {
    public ItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, FrenchDelightsMod.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(FDItems.BAGUETTE.get());
        basicItem(FDItems.CROISSANT.get());
        //basicItem(FDItems.PAIN_CHOCOLAT.get());
        basicItem(FDItems.SALT.get());
        basicItem(FDItems.WINE_BOTTLE.get());
        //basicItem(FDItems.WINE_GLASS.get());
        //basicItem(FDItems.SALTED_DOUGH.get());
        blockItems();
    }

    private void blockItems() {
        for (Supplier<BlockItem> blockItem : FDItems.BLOCK_ITEMS) {
            parentItemBlock(blockItem.get());
        }
    }

    public ItemModelBuilder parentItemBlock(Item item, ResourceLocation loc) {
        ResourceLocation name = Objects.requireNonNull(BuiltInRegistries.ITEM.getKey(item));
        return getBuilder(name.toString())
                .parent(new ModelFile.UncheckedModelFile(loc));
    }

    public ItemModelBuilder parentItemBlock(Item item) {
        return parentItemBlock(item, "");
    }

    public ItemModelBuilder parentItemBlock(Item item, String suffix) {
        ResourceLocation name = Objects.requireNonNull(BuiltInRegistries.ITEM.getKey(item));
        return getBuilder(name.toString())
                .parent(new ModelFile.UncheckedModelFile(ResourceLocation.fromNamespaceAndPath(name.getNamespace(), "block/" + name.getPath() + suffix)));
    }

    public ItemModelBuilder handHeldItem(Item item) {
        return handHeldItem(item, "");
    }

    public ItemModelBuilder handHeldItem(Item item, String suffix) {
        ResourceLocation location = BuiltInRegistries.ITEM.getKey(item);
        return getBuilder(location +suffix)
                .parent(new ModelFile.UncheckedModelFile("item/handheld"))
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(location.getNamespace(), "item/" + location.getPath()+suffix));
    }
}
