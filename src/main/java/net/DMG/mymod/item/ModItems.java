package net.DMG.mymod.item;

import net.DMG.mymod.MyMod;
import net.DMG.mymod.item.custom.ChiselItem;
import net.DMG.mymod.item.custom.FuelItem;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MyMod.MOD_ID);

    public static final RegistryObject<Item> OPTIMONIUM = ITEMS.register("optimonium", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> UNREFINED_OPTIMONIUM = ITEMS.register("unrefined_optimonium", ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CHISEL = ITEMS.register("chisel", ()-> new ChiselItem(new Item.Properties().durability(128)));
    public static final RegistryObject<Item> FRIED_EGG = ITEMS.register("fried_egg", ()-> new Item(new Item.Properties().food(ModFoodProperties.FRIED_EGG)){
        @Override
        public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
            pTooltipComponents.add(Component.translatable("tooltip.mymod.fried_egg"));
            super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
        }
    });
    public static final RegistryObject<Item> NEUTRON_STAR = ITEMS.register("neutron_star", () -> new FuelItem(new Item.Properties(), 32000){
        @Override
        public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
            pTooltipComponents.add(Component.translatable("tooltip.mymod.neutron_star"));
            super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
        }
    });


    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
