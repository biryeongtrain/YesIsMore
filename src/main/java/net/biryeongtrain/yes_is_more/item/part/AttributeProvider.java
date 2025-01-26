package net.biryeongtrain.yes_is_more.item.part;

import com.google.common.collect.Multimap;
import net.biryeongtrain.yes_is_more.item.material.ToolMaterialInfo;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.registry.entry.RegistryEntry;

public interface AttributeProvider {
    Multimap<RegistryEntry<EntityAttribute>, EntityAttributeModifier> combine(ToolMaterialInfo info);
}
