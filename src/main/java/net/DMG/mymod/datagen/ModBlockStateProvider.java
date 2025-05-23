package net.DMG.mymod.datagen;

import net.DMG.mymod.MyMod;
import net.DMG.mymod.block.ModBlocks;
import net.DMG.mymod.block.custom.OptimoniumLampBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, MyMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.OPTIMONIUM_BLOCK);
        blockWithItem(ModBlocks.UNREFINED_OPTIMONIUM_BLOCK);
        blockWithItem(ModBlocks.COMPRESSED_OBSIDIAN);

        blockWithItem(ModBlocks.OPTIMONIUM_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_OPTIMONIUM_ORE);

        blockWithItem(ModBlocks.MAGIC_BLOCK);

        stairsBlock(ModBlocks.OPTIMONIUM_STAIRS.get(), blockTexture(ModBlocks.OPTIMONIUM_BLOCK.get()));
        slabBlock(ModBlocks.OPTIMONIUM_SLAB.get(), blockTexture(ModBlocks.OPTIMONIUM_BLOCK.get()), blockTexture(ModBlocks.OPTIMONIUM_BLOCK.get()));

        buttonBlock(ModBlocks.OPTIMONIUM_BUTTON.get(), blockTexture(ModBlocks.OPTIMONIUM_BLOCK.get()));
        pressurePlateBlock(ModBlocks.OPTIMONIUM_PRESSURE_PLATE.get(), blockTexture(ModBlocks.OPTIMONIUM_BLOCK.get()));

        fenceBlock(ModBlocks.OPTIMONIUM_FENCE.get(), blockTexture(ModBlocks.OPTIMONIUM_BLOCK.get()));
        fenceGateBlock(ModBlocks.OPTIMONIUM_FENCE_GATE.get(), blockTexture(ModBlocks.OPTIMONIUM_BLOCK.get()));
        wallBlock(ModBlocks.OPTIMONIUM_WALL.get(), blockTexture(ModBlocks.OPTIMONIUM_BLOCK.get()));

        doorBlockWithRenderType(ModBlocks.OPTIMONIUM_DOOR.get(), modLoc("block/optimonium_door_bottom"), modLoc("block/optimonium_door_top"), "cutout");
        trapdoorBlockWithRenderType(ModBlocks.OPTIMONIUM_TRAPDOOR.get(), modLoc("block/optimonium_trapdoor"), true, "cutout");

        blockItem(ModBlocks.OPTIMONIUM_STAIRS);
        blockItem(ModBlocks.OPTIMONIUM_SLAB);
        blockItem(ModBlocks.OPTIMONIUM_PRESSURE_PLATE);
        blockItem(ModBlocks.OPTIMONIUM_FENCE_GATE);
        blockItem(ModBlocks.OPTIMONIUM_TRAPDOOR, "_bottom");
        customLamp();
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void blockItem(RegistryObject<? extends Block> blockRegistryObject){
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("mymod:block/"+
                ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }
    private void blockItem(RegistryObject<? extends Block> blockRegistryObject, String appendix){
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("mymod:block/"+
                ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()+appendix));
    }
    private void customLamp() {
        getVariantBuilder(ModBlocks.OPTIMONIUM_LAMP.get()).forAllStates(state -> {
            if(state.getValue(OptimoniumLampBlock.CLICKED)) {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("optimonium_lamp_on",
                        ResourceLocation.fromNamespaceAndPath(MyMod.MOD_ID, "block/" + "optimonium_lamp_on")))};
            } else {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("optimonium_lamp_off",
                        ResourceLocation.fromNamespaceAndPath(MyMod.MOD_ID, "block/" + "optimonium_lamp_off")))};
            }
        });
        simpleBlockItem(ModBlocks.OPTIMONIUM_LAMP.get(), models().cubeAll("optimonium_lamp_on",
                ResourceLocation.fromNamespaceAndPath(MyMod.MOD_ID, "block/" + "optimonium_lamp_on")));
    }

}
