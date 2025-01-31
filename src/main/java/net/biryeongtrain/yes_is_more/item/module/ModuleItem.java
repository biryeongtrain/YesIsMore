package net.biryeongtrain.yes_is_more.item.module;

import eu.pb4.polymer.core.api.item.PolymerItem;
import net.biryeongtrain.yes_is_more.ToolMaterialManager;
import net.biryeongtrain.yes_is_more.item.material.ToolMaterialInfo;
import net.biryeongtrain.yes_is_more.item.part.Parts;
import net.minecraft.component.ComponentType;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;
import xyz.nucleoid.packettweaker.PacketContext;

import java.util.EnumMap;
import java.util.EnumSet;

/**
 *
 */
public abstract class ModuleItem extends Item implements PolymerItem {
    public ModuleItem(Settings settings) {
        super(settings);
    }

    @Override
    public abstract @Nullable Identifier getPolymerItemModel(ItemStack stack, PacketContext context);

    public abstract EnumSet<Parts> getParts();
    public ItemStack combine(EnumMap<Parts, ToolMaterialInfo> infoMap) {
        ItemStack result = new ItemStack(this);
        this.getParts().forEach(part -> {
            ToolMaterialInfo info = infoMap.getOrDefault(part, ToolMaterialManager.UNKNOWN);
            var attributeMap = part.combine(info);
            var components = part.collectComponents(info);

            components.forEach((componentType, component) -> {
                result.set((ComponentType<? super Object>) componentType, component);
            });
            attributeMap.forEach((attribute, value) -> {
                var modifier = result.getOrDefault(DataComponentTypes.ATTRIBUTE_MODIFIERS, AttributeModifiersComponent.DEFAULT);
                modifier.with(attribute, value, AttributeModifierSlot.MAINHAND);
                result.set(DataComponentTypes.ATTRIBUTE_MODIFIERS, modifier);
            });
        });

        this.getParts().forEach(part -> {
            ToolMaterialInfo info = infoMap.getOrDefault(part, ToolMaterialManager.UNKNOWN);
            part.after(result, info);
        });
        return result;
    }
}
