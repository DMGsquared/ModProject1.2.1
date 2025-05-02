package net.DMG.mymod.item;

import net.DMG.mymod.MyMod;
import net.DMG.mymod.block.ModBlocks;
import net.minecraft.client.tutorial.Tutorial;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MyMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> MY_MOD_TAB = CREATIVE_MODE_TABS.register("my_mod_tab", () -> CreativeModeTab.builder()
            .icon(()-> new ItemStack(ModItems.OPTIMONIUM.get()))
            .title(Component.translatable("creative.mymod.my_mod"))
            .displayItems((itemDisplayParameters, output)-> {
                output.accept(ModItems.UNREFINED_OPTIMONIUM.get());
                output.accept(ModItems.OPTIMONIUM.get());
                output.accept(ModBlocks.UNREFINED_OPTIMONIUM_BLOCK.get());
                output.accept(ModBlocks.OPTIMONIUM_BLOCK.get());
                output.accept(ModBlocks.OPTIMONIUM_ORE.get());
                output.accept(ModBlocks.DEEPSLATE_OPTIMONIUM_ORE.get());
    }) .build());


    public static void register (IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
