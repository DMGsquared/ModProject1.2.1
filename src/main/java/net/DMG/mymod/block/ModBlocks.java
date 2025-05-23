package net.DMG.mymod.block;

import net.DMG.mymod.MyMod;
import net.DMG.mymod.block.custom.MagicBlock;
import net.DMG.mymod.block.custom.OptimoniumLampBlock;
import net.DMG.mymod.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, MyMod.MOD_ID);


    public static final RegistryObject<Block> OPTIMONIUM_BLOCK = registerBlock("optimonium_block", () -> new Block(BlockBehaviour.Properties.of()
            .strength(4f,1200f).requiresCorrectToolForDrops()
            .sound(SoundType.DEEPSLATE)));

    public static final RegistryObject<Block> UNREFINED_OPTIMONIUM_BLOCK = registerBlock("unrefined_optimonium_block", () -> new Block(BlockBehaviour.Properties.of()
            .strength(3f).requiresCorrectToolForDrops().sound(SoundType.GRAVEL)));

    public static final RegistryObject<Block> OPTIMONIUM_ORE = registerBlock("optimonium_ore", ()-> new DropExperienceBlock(UniformInt.of(2,4),
            BlockBehaviour.Properties.of()
            .strength(1.5f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> DEEPSLATE_OPTIMONIUM_ORE = registerBlock("deepslate_optimonium_ore", ()-> new DropExperienceBlock(UniformInt.of(3,6),
            BlockBehaviour.Properties.of().strength(2.5f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));

    public static final RegistryObject<Block> COMPRESSED_OBSIDIAN = registerBlock("compressed_obsidian", () -> new Block(BlockBehaviour.Properties.of()
            .strength(12f,10000f)));

  //  public static final RegistryObject<Block> OPTIMONIUM_BRICK = registerBlock("optimonium_brick", ()-> new Block(BlockBehaviour.Properties.of().strength(2.3f, 4)));

    public static final RegistryObject<Block> MAGIC_BLOCK = registerBlock("magic_block", ()-> new MagicBlock(BlockBehaviour.Properties.of()
            .strength(2f,1000).requiresCorrectToolForDrops()));

    public static final RegistryObject<StairBlock> OPTIMONIUM_STAIRS = registerBlock("optimonium_stairs",
            ()-> new StairBlock(ModBlocks.OPTIMONIUM_BLOCK.get().defaultBlockState(), BlockBehaviour.Properties.of()
                    .strength(2.5f,1000f).requiresCorrectToolForDrops()));
    public static final RegistryObject<SlabBlock> OPTIMONIUM_SLAB = registerBlock("optimonium_slab",
            ()-> new SlabBlock( BlockBehaviour.Properties.of()
                    .strength(2.5f,1000f).requiresCorrectToolForDrops()));

    public static final RegistryObject<PressurePlateBlock> OPTIMONIUM_PRESSURE_PLATE = registerBlock("optimonium_pressure_plate",
            ()-> new PressurePlateBlock(BlockSetType.IRON, BlockBehaviour.Properties.of().strength(2.5f, 1000f)));
    public static final RegistryObject<ButtonBlock> OPTIMONIUM_BUTTON = registerBlock("optimonium_button",
            ()-> new ButtonBlock(BlockSetType.IRON, 10, BlockBehaviour.Properties.of()
                    .strength(2.5f,1000f).noCollission().requiresCorrectToolForDrops()));

    public static final RegistryObject<FenceBlock> OPTIMONIUM_FENCE = registerBlock("optimonium_fence",
            ()-> new FenceBlock(BlockBehaviour.Properties.of()
                    .strength(2.5f,1000f).requiresCorrectToolForDrops()));
    public static final RegistryObject<FenceGateBlock> OPTIMONIUM_FENCE_GATE = registerBlock("optimonium_fence_gate",
            ()-> new FenceGateBlock(WoodType.CHERRY, BlockBehaviour.Properties.of()
                    .strength(2.5f,1000f).requiresCorrectToolForDrops()));
    public static final RegistryObject<WallBlock> OPTIMONIUM_WALL = registerBlock("optimonium_wall",
            ()-> new WallBlock(BlockBehaviour.Properties.of()
                    .strength(2.5f,1000f).requiresCorrectToolForDrops()));

    public static final RegistryObject<DoorBlock> OPTIMONIUM_DOOR = registerBlock("optimonium_door",
            ()-> new DoorBlock(BlockSetType.CHERRY, BlockBehaviour.Properties.of()
                    .strength(2.5f,1000f).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<TrapDoorBlock> OPTIMONIUM_TRAPDOOR = registerBlock("optimonium_trapdoor",
            ()-> new TrapDoorBlock(BlockSetType.CHERRY, BlockBehaviour.Properties.of()
                    .strength(2.5f,1000f).requiresCorrectToolForDrops().noOcclusion()));

public static final RegistryObject<Block> OPTIMONIUM_LAMP = registerBlock("optimonium_lamp", ()-> new OptimoniumLampBlock((BlockBehaviour
        .Properties.of().strength(3f).lightLevel(state -> state.getValue(OptimoniumLampBlock.CLICKED) ? 15: 0))));



    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name,toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block){
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
   /* private static void registerNonblocks (Set<String> set, String item, float strength, float blastResistance){
        if (set.contains("stairs")){
            public static final RegistryObject<StairBlock> item.concat("_STAIRS" = registerBlock("optimonium_stairs",
                    ()-> new StairBlock(ModBlocks.OPTIMONIUM_BLOCK.get().defaultBlockState(), BlockBehaviour.Properties.of()
                            .strength(2.5f, 1000f).requiresCorrectToolForDrops()));
        }
    }*/

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
