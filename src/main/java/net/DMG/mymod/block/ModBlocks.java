package net.DMG.mymod.block;

import net.DMG.mymod.MyMod;
import net.DMG.mymod.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
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
            .destroyTime(10f).strength(4f).requiresCorrectToolForDrops().explosionResistance(1200f)
            .sound(SoundType.ANCIENT_DEBRIS)));

  //  public static final RegistryObject<Block> UNREFINED_OPTIMONIUM_BLOCK = registerBlock("optimonium_block", () -> new Block(BlockBehaviour.Properties.of()
   //         .sound(SoundType.BONE_BLOCK)));

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
