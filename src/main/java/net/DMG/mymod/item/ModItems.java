package net.DMG.mymod.item;

import net.DMG.mymod.MyMod;
import net.DMG.mymod.item.custom.ChiselItem;
import net.DMG.mymod.item.custom.FuelItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MyMod.MOD_ID);

    public static final RegistryObject<Item> OPTIMONIUM = ITEMS.register("optimonium", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> UNREFINED_OPTIMONIUM = ITEMS.register("unrefined_optimonium", ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CHISEL = ITEMS.register("chisel", ()-> new ChiselItem(new Item.Properties().durability(128)));
    public static final RegistryObject<Item> FRIED_EGG = ITEMS.register("fried_egg", ()-> new Item(new Item.Properties().food(ModFoodProperties.FRIED_EGG)));
    public static final RegistryObject<Item> NEUTRON_STAR = ITEMS.register("neutron_star", () -> new FuelItem(new Item.Properties(), 32000));


    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
