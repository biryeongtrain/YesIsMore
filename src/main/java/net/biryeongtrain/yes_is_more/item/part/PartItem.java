package net.biryeongtrain.yes_is_more.item.part;

import eu.pb4.polymer.core.api.item.PolymerItem;
import net.biryeongtrain.yes_is_more.ToolMaterialManager;
import net.biryeongtrain.yes_is_more.item.components.ItemComponents;
import net.biryeongtrain.yes_is_more.item.material.ToolMaterialInfo;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xyz.nucleoid.packettweaker.PacketContext;

public abstract class PartItem extends Item implements PolymerItem {
    public final Identifier id;
    public PartItem(Identifier partId) {
        super(new Settings().maxCount(4).registryKey(RegistryKey.of(Registries.ITEM.getKey(), partId)));
        this.id = partId;
    }
    @Override
    public @Nullable Identifier getPolymerItemModel(ItemStack stack, PacketContext context) {
        return id;
    }

    public static boolean isPartItem(ItemStack stack) {
        return stack.getItem() instanceof PartItem;
    }

    public static @NotNull ToolMaterialInfo getInfo(ItemStack stack) {
        if (!(stack.getItem() instanceof PartItem) && !stack.hasChangedComponent(ItemComponents.PARTS_MATERIAL_COMPONENT)) {
            return ToolMaterialManager.UNKNOWN;
        }
        return stack.get(ItemComponents.PARTS_MATERIAL_COMPONENT);
    }

    public abstract Parts getPartType();

    public ItemStack create(ToolMaterialInfo info) {
        ItemStack stack = new ItemStack(this);
        stack.set(ItemComponents.PARTS_MATERIAL_COMPONENT, info);
        return stack;
    }
}
