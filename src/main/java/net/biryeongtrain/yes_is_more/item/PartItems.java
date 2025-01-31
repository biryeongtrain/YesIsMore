package net.biryeongtrain.yes_is_more.item;

import net.biryeongtrain.yes_is_more.item.part.*;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import org.jetbrains.annotations.Contract;

public class PartItems {
    public static Item SWORD_MODULE = register(new SwordPart());
    public static Item PICKAXE_PART = register(new PickaxePart());
    public static Item TOOL_ROD_PART = register(new ToolRodPart());
    public static Item TOOL_BINDING_PART = register(new ToolBindingPart());

    @Contract("_ -> param1")
    public static PartItem register(PartItem partItem) {
        Registry.register(Registries.ITEM, RegistryKey.of(RegistryKeys.ITEM ,partItem.id), partItem);
        return partItem;
    }
}
