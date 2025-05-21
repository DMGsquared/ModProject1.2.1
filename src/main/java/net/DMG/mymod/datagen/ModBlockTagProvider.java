package net.DMG.mymod.datagen;

import net.DMG.mymod.MyMod;
import net.DMG.mymod.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, MyMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.UNREFINED_OPTIMONIUM_BLOCK.get())
                .add(ModBlocks.OPTIMONIUM_BLOCK.get())
                .add(ModBlocks.OPTIMONIUM_ORE.get())
                .add(ModBlocks.DEEPSLATE_OPTIMONIUM_ORE.get())
                .add(ModBlocks.MAGIC_BLOCK.get())

                .add(ModBlocks.OPTIMONIUM_STAIRS.get())
                .add(ModBlocks.OPTIMONIUM_SLAB.get())

                .add(ModBlocks.OPTIMONIUM_BUTTON.get())
                .add(ModBlocks.OPTIMONIUM_PRESSURE_PLATE.get())

                .add(ModBlocks.OPTIMONIUM_FENCE.get())
                .add(ModBlocks.OPTIMONIUM_FENCE_GATE.get())
                .add(ModBlocks.OPTIMONIUM_WALL.get())

                .add(ModBlocks.OPTIMONIUM_DOOR.get())
                .add(ModBlocks.OPTIMONIUM_TRAPDOOR.get());
        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.DEEPSLATE_OPTIMONIUM_ORE.get())
                .add(ModBlocks.OPTIMONIUM_ORE.get());

        tag(BlockTags.FENCES).add(ModBlocks.OPTIMONIUM_FENCE.get());
        tag(BlockTags.FENCE_GATES).add(ModBlocks.OPTIMONIUM_FENCE_GATE.get());
        tag(BlockTags.WALLS).add(ModBlocks.OPTIMONIUM_WALL.get());


    }
}
