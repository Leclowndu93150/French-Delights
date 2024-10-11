package com.leclowndu93150.frenchdelights.datagen;

import com.leclowndu93150.frenchdelights.FrenchDelightsMod;
import com.leclowndu93150.frenchdelights.registry.FDItems;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.SmeltingRecipe;
import net.neoforged.neoforge.common.Tags;
import org.jetbrains.annotations.NotNull;
import vectorwing.farmersdelight.FarmersDelight;
import vectorwing.farmersdelight.client.recipebook.CookingPotRecipeBookTab;
import vectorwing.farmersdelight.common.tag.CommonTags;
import vectorwing.farmersdelight.data.builder.CookingPotRecipeBuilder;
import vectorwing.farmersdelight.data.recipe.SmeltingRecipes;

import java.util.concurrent.CompletableFuture;
public class RecipesProvider extends RecipeProvider {
    public RecipesProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }
    @Override
    protected void buildRecipes(@NotNull RecipeOutput pRecipeOutput) {
        CookingPotRecipeBuilder.cookingPotRecipe(FDItems.SALT,4,400,1)
                .addIngredient(Tags.Items.BUCKETS_WATER)
                .unlockedBy("has_salt", has(Items.WATER_BUCKET))
                .setRecipeBookTab(CookingPotRecipeBookTab.MISC)
                .build(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, FDItems.SALTED_DOUGH, 1)
                .requires(FDItems.SALT)
                .requires(CommonTags.FOODS_DOUGH)
                .unlockedBy("has_salt", has(FDItems.SALT))
                .save(pRecipeOutput);

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(FDItems.SALTED_DOUGH.get()), RecipeCategory.FOOD,
                        FDItems.SALTED_DOUGH, 0.35F, 200)
                .unlockedBy("has_dough", InventoryChangeTrigger.TriggerInstance.hasItems(FDItems.SALTED_DOUGH.get()))
                .save(pRecipeOutput, ResourceLocation.fromNamespaceAndPath(FrenchDelightsMod.MODID, "smelting/"+"baguette"));
    }
}
