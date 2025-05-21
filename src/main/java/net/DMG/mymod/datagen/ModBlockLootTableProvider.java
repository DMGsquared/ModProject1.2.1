package net.DMG.mymod.datagen;

import net.DMG.mymod.block.ModBlocks;
import net.DMG.mymod.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

import java.util.Map;
import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {

    protected ModBlockLootTableProvider(HolderLookup.Provider pRegistries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), pRegistries);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.MAGIC_BLOCK.get());
        dropSelf(ModBlocks.OPTIMONIUM_BLOCK.get());
        dropSelf(ModBlocks.UNREFINED_OPTIMONIUM_BLOCK.get());
        dropSelf(ModBlocks.COMPRESSED_OBSIDIAN.get());

        this.add(ModBlocks.OPTIMONIUM_ORE.get(),
                block -> createOreDrop(ModBlocks.OPTIMONIUM_ORE.get(), ModItems.UNREFINED_OPTIMONIUM.get()));
        this.add(ModBlocks.DEEPSLATE_OPTIMONIUM_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.DEEPSLATE_OPTIMONIUM_ORE.get(), ModItems.UNREFINED_OPTIMONIUM.get(), 2, 4));

        dropSelf(ModBlocks.OPTIMONIUM_STAIRS.get());
        //Slab gotta do weird thing for some reason
        this.add(ModBlocks.OPTIMONIUM_SLAB.get(), block -> createSlabItemTable(ModBlocks.OPTIMONIUM_SLAB.get()));

        dropSelf(ModBlocks.OPTIMONIUM_PRESSURE_PLATE.get());
        dropSelf(ModBlocks.OPTIMONIUM_BUTTON.get());
        dropSelf(ModBlocks.OPTIMONIUM_FENCE.get());
        dropSelf(ModBlocks.OPTIMONIUM_FENCE_GATE.get());
        dropSelf(ModBlocks.OPTIMONIUM_WALL.get());

        this.add(ModBlocks.OPTIMONIUM_DOOR.get(), block -> createDoorTable(ModBlocks.OPTIMONIUM_DOOR.get()));

        dropSelf(ModBlocks.OPTIMONIUM_TRAPDOOR.get());
    }

    protected LootTable.Builder createMultipleOreDrops(Block pBlock, Item item,float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(
                pBlock, this.applyExplosionDecay(
                        pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                                .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))
                )
        );
    }

    @Override
    protected Iterable<Block> getKnownBlocks(){
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
