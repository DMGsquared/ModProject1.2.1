package net.DMG.mymod.datagen;

import net.DMG.mymod.MyMod;
import net.DMG.mymod.block.ModBlocks;
import net.DMG.mymod.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {
        List<ItemLike> OPTIMONIUM_SMELTABLES = List.of(
                ModItems.UNREFINED_OPTIMONIUM.get(),
                ModBlocks.OPTIMONIUM_ORE.get()
        );

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.OPTIMONIUM_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.OPTIMONIUM.get())
                .unlockedBy(getHasName(ModItems.OPTIMONIUM.get()), has(ModItems.OPTIMONIUM.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.MAGIC_BLOCK.get())
                .pattern("BBB")
                .pattern("BAB")
                .pattern("BBB")
                .define('A', ModBlocks.OPTIMONIUM_BLOCK.get())
                .define('B', ModBlocks.COMPRESSED_OBSIDIAN.get())
                .unlockedBy(getHasName(ModItems.OPTIMONIUM.get()), has(ModItems.OPTIMONIUM.get())).save(pRecipeOutput);

        nineBlockStorageRecipes(pRecipeOutput, RecipeCategory.MISC, Blocks.OBSIDIAN, RecipeCategory.MISC, ModBlocks.COMPRESSED_OBSIDIAN.get());

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.OPTIMONIUM.get(), 9)
                .requires(ModBlocks.OPTIMONIUM_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.OPTIMONIUM_BLOCK.get()),has(ModBlocks.OPTIMONIUM_BLOCK.get())).save(pRecipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.UNREFINED_OPTIMONIUM.get(), 4)
                .requires(ModBlocks.MAGIC_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.MAGIC_BLOCK.get()),has(ModBlocks.MAGIC_BLOCK.get())).save(pRecipeOutput);


        oreSmelting(pRecipeOutput, OPTIMONIUM_SMELTABLES, RecipeCategory.MISC, ModItems.OPTIMONIUM.get(), 0.5f, 400, "optimonium");
        oreBlasting(pRecipeOutput, OPTIMONIUM_SMELTABLES, RecipeCategory.MISC, ModItems.OPTIMONIUM.get(), 0.5f, 200, "optimonium");

        stairBuilder(ModBlocks.OPTIMONIUM_STAIRS.get(),Ingredient.of(ModItems.OPTIMONIUM.get())).group("optimonium")
                .unlockedBy(getHasName(ModItems.OPTIMONIUM.get()), has(ModItems.OPTIMONIUM.get())).save(pRecipeOutput);
        slab(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.OPTIMONIUM_SLAB.get(), ModItems.OPTIMONIUM.get());
    }
    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for (ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, MyMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
