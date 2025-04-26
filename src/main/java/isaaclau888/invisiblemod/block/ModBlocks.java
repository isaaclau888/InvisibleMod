package isaaclau888.invisiblemod.block;

import isaaclau888.invisiblemod.InvisibleMod;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block PINK_GARNET_BLOCK = registerBlock("pink_garnet_block",
            AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(InvisibleMod.MOD_ID, "pink_garnet_block")))
                    .strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK));

    public static final Block RAW_PINK_GARNET_BLOCK = registerBlock("raw_pink_garnet_block",
            AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(InvisibleMod.MOD_ID, "raw_pink_garnet_block")))
                    .strength(3f)
                    .requiresTool());

    private static Block registerBlock(String name, AbstractBlock.Settings blocksettings) {
        RegistryKey<Block> key = RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(InvisibleMod.MOD_ID, name));
        Block block = new Block(blocksettings.registryKey(key));
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, key, block);
    }

    private static void registerBlockItem(String name, Block block){
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(InvisibleMod.MOD_ID, name));
        BlockItem item = new BlockItem(block,new Item.Settings().registryKey(key));
        Registry.register(Registries.ITEM, key,item);
    }

    public static void registerModBlocks() {
        InvisibleMod.LOGGER.info("Registering Mod Blocks for" + InvisibleMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.PINK_GARNET_BLOCK);
            entries.add(ModBlocks.RAW_PINK_GARNET_BLOCK);
        });
    }
}
