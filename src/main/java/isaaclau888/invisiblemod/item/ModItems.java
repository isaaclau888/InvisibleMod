package isaaclau888.invisiblemod.item;

import isaaclau888.invisiblemod.InvisibleMod;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item FLUORITE = registerItem("fluorite", new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM,Identifier.of(InvisibleMod.MOD_ID,"fluorite"))));
    public static final Item RAW_FLUORITE = registerItem("raw_fluorite", new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM,Identifier.of(InvisibleMod.MOD_ID,"raw_fluorite"))));

    private static Item registerItem(String name, Item.Settings itemSettings) {
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(InvisibleMod.MOD_ID, name));
        Item item = new Item(itemSettings.registryKey(key));
        return Registry.register(Registries.ITEM, Identifier.of(InvisibleMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        InvisibleMod.LOGGER.info("Registering Mod Items for " + InvisibleMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(FLUORITE);
            entries.add(RAW_FLUORITE);
        });
    }
}
