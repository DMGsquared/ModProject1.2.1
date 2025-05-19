package net.DMG.mymod.block;

import net.DMG.mymod.MyMod;
import net.DMG.mymod.block.custom.MagicBlock;
import net.DMG.mymod.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, MyMod.MOD_ID);


    public static final RegistryObject<Block> OPTIMONIUM_BLOCK = registerBlock("optimonium_block", () -> new Block(BlockBehaviour.Properties.of()
            .strength(4f,1200f).requiresCorrectToolForDrops()
            .sound(SoundType.ANCIENT_DEBRIS)));

    public static final RegistryObject<Block> UNREFINED_OPTIMONIUM_BLOCK = registerBlock("unrefined_optimonium_block", () -> new Block(BlockBehaviour.Properties.of()
            .strength(3f).requiresCorrectToolForDrops().sound(SoundType.BONE_BLOCK)));

    public static final RegistryObject<Block> OPTIMONIUM_ORE = registerBlock("optimonium_ore", ()-> new DropExperienceBlock(UniformInt.of(2,4),
            BlockBehaviour.Properties.of()
            .strength(1.5f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> DEEPSLATE_OPTIMONIUM_ORE = registerBlock("deepslate_optimonium_ore", ()-> new DropExperienceBlock(UniformInt.of(3,6),
            BlockBehaviour.Properties.of()
            .strength(2.5f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));
    public static final RegistryObject<Block> OPTIMONIUM_BRICK = registerBlock("optimonium_brick", ()-> new Block(BlockBehaviour.Properties.of().strength(2.3f, 4)));

    public static final RegistryObject<Block> MAGIC_BLOCK = registerBlock("magic_block", ()-> new MagicBlock(BlockBehaviour.Properties.of().strength(2f,1000).requiresCorrectToolForDrops()));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name,toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block){
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
