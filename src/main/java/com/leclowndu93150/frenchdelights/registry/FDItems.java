package com.leclowndu93150.frenchdelights.registry;

import com.leclowndu93150.frenchdelights.FrenchDelightsMod;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class FDItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(FrenchDelightsMod.MODID);
    public static final List<ItemLike> CREATIVE_TAB_ITEMS = new ArrayList<>();
    public static final List<Supplier<BlockItem>> BLOCK_ITEMS = new ArrayList<>();

    public static final DeferredItem<Item> BAGUETTE = registerItem("baguette",
            Item::new, new Item.Properties().food(FDFoods.BAGUETTE));
    public static final DeferredItem<Item> CROISSANT = registerItem("croissant",
            Item::new, new Item.Properties().food(FDFoods.CROISSANT));
    public static final DeferredItem<Item> PAIN_CHOCOLAT = registerItem("pain_chocolat",
            Item::new, new Item.Properties().food(FDFoods.PAIN_CHOCOLAT));
    public static final DeferredItem<Item> SALT = registerItem("salt",
            Item::new, new Item.Properties());
    public static final DeferredItem<Item> WINE_BOTTLE = registerItem("wine_bottle",
            Item::new, new Item.Properties());
    public static final DeferredItem<Item> WINE_GLASS = registerItem("wine_glass",
            Item::new, new Item.Properties());
    public static final DeferredItem<Item> SALTED_DOUGH = registerItem("salted_dough",
            Item::new, new Item.Properties());


    public static <T extends Item> DeferredItem<T> registerItem(String name, Function<Item.Properties, T> itemConstructor, Item.Properties properties) {
        return registerItem(name, itemConstructor, properties, true);
    }

    public static <T extends Item> DeferredItem<T> registerItem(String name, Supplier<T> item) {
        DeferredItem<T> toReturn = ITEMS.register(name, item);
        CREATIVE_TAB_ITEMS.add(toReturn);
        return toReturn;
    }

    public static <T extends Item> DeferredItem<T> registerItem(String name, Function<Item.Properties, T> itemConstructor, Item.Properties properties, boolean addToTab) {
        DeferredItem<T> toReturn = ITEMS.registerItem(name, itemConstructor, properties);
        if (addToTab) {
            CREATIVE_TAB_ITEMS.add(toReturn);
        }
        return toReturn;
    }
}
