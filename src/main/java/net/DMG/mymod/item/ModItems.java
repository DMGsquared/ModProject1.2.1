package net.DMG.mymod.item;

import net.DMG.mymod.MyMod;
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

    //public static final RegistryObject<Item> BIGOHDIH = ITEMS.register("bigohdih", () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
