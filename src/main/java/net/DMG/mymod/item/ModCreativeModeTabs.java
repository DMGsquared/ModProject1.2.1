package net.DMG.mymod.item;

import net.DMG.mymod.MyMod;
import net.DMG.mymod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MyMod.MOD_ID);


    public static final RegistryObject<CreativeModeTab> MOD_ITEMS = CREATIVE_MODE_TABS.register("item_tab",
            ()-> CreativeModeTab.builder().icon(()-> new ItemStack(ModItems.CHISEL.get()))
                    .title(Component.translatable("creative.mymod.item_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.FRIED_EGG.get());
                        output.accept(ModItems.UNREFINED_OPTIMONIUM.get());
                        output.accept(ModItems.OPTIMONIUM.get());
                        output.accept(ModItems.NEUTRON_STAR.get());
                        output.accept(ModItems.CHISEL.get());
                    }).build());

    public static final RegistryObject<CreativeModeTab> MOD_BLOCKS = CREATIVE_MODE_TABS.register("block_tab",
            ()-> CreativeModeTab.builder().icon(()-> new ItemStack(ModBlocks.OPTIMONIUM_BLOCK.get()))
                    .withTabsBefore(MOD_ITEMS.getId())
                    .title(Component.translatable("creative.mymod.block_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.UNREFINED_OPTIMONIUM_BLOCK.get());
                        output.accept(ModBlocks.OPTIMONIUM_BLOCK.get());
                        output.accept(ModBlocks.OPTIMONIUM_ORE.get());
                        output.accept(ModBlocks.DEEPSLATE_OPTIMONIUM_ORE.get());

                        output.accept(ModBlocks.OPTIMONIUM_STAIRS.get());
                        output.accept(ModBlocks.OPTIMONIUM_SLAB.get());

                        output.accept(ModBlocks.OPTIMONIUM_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.OPTIMONIUM_BUTTON.get());

                        output.accept(ModBlocks.OPTIMONIUM_FENCE.get());
                        output.accept(ModBlocks.OPTIMONIUM_FENCE_GATE.get());
                        output.accept(ModBlocks.OPTIMONIUM_WALL.get());

                        output.accept(ModBlocks.OPTIMONIUM_DOOR.get());
                        output.accept(ModBlocks.OPTIMONIUM_TRAPDOOR.get());
                    }).build());

    public static final RegistryObject<CreativeModeTab> FOOD_TAB = CREATIVE_MODE_TABS.register("food_tab",
            ()-> CreativeModeTab.builder().icon(()-> new ItemStack(ModItems.FRIED_EGG.get()))
                    .withTabsBefore(MOD_BLOCKS.getId())
                    .title(Component.translatable("creative.mymod.food_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.FRIED_EGG.get());
                    }).build());

    public static final RegistryObject<CreativeModeTab> MOD_TAB = CREATIVE_MODE_TABS.register("mod_tab", () -> CreativeModeTab.builder()
            .icon(()-> new ItemStack(ModItems.OPTIMONIUM.get()))
            .withTabsBefore(FOOD_TAB.getId())
            .title(Component.translatable("creative.mymod.mod_tab"))
            .displayItems((itemDisplayParameters, output)-> {
                output.accept(ModItems.UNREFINED_OPTIMONIUM.get());
                output.accept(ModItems.OPTIMONIUM.get());
                output.accept(ModItems.NEUTRON_STAR.get());
                output.accept(ModItems.CHISEL.get());

                output.accept(ModBlocks.UNREFINED_OPTIMONIUM_BLOCK.get());
                output.accept(ModBlocks.OPTIMONIUM_BLOCK.get());
                output.accept(ModBlocks.OPTIMONIUM_ORE.get());
                output.accept(ModBlocks.DEEPSLATE_OPTIMONIUM_ORE.get());
                output.accept(ModBlocks.MAGIC_BLOCK.get());

                output.accept(ModBlocks.OPTIMONIUM_STAIRS.get());
                output.accept(ModBlocks.OPTIMONIUM_SLAB.get());
                output.accept(ModBlocks.OPTIMONIUM_PRESSURE_PLATE.get());
                output.accept(ModBlocks.OPTIMONIUM_BUTTON.get());
                output.accept(ModBlocks.OPTIMONIUM_FENCE.get());
                output.accept(ModBlocks.OPTIMONIUM_FENCE_GATE.get());
                output.accept(ModBlocks.OPTIMONIUM_WALL.get());
                output.accept(ModBlocks.OPTIMONIUM_DOOR.get());
                output.accept(ModBlocks.OPTIMONIUM_TRAPDOOR.get());

            }) .build());


    public static void register (IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
