package com.leclowndu93150.frenchdelights.datagen;

import com.leclowndu93150.frenchdelights.registry.FDItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.NotNull;
import vectorwing.farmersdelight.client.recipebook.CookingPotRecipeBookTab;
import vectorwing.farmersdelight.data.builder.CookingPotRecipeBuilder;

import java.util.concurrent.CompletableFuture;
public class RecipesProvider extends RecipeProvider {
    public RecipesProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }
    @Override
    protected void buildRecipes(@NotNull RecipeOutput pRecipeOutput) {
        CookingPotRecipeBuilder.cookingPotRecipe(FDItems.SALT,4,400,1)
                .addIngredient(Items.WATER_BUCKET)
                .unlockedBy("has_salt", has(Items.WATER_BUCKET))
                .setRecipeBookTab(CookingPotRecipeBookTab.MISC)
                .build(pRecipeOutput);
    }
}
