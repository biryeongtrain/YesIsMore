package net.biryeongtrain.yes_is_more.util;

import com.google.common.collect.Multimap;
import net.biryeongtrain.yes_is_more.item.material.ToolMaterialInfo;
import net.minecraft.component.ComponentType;

public interface ComponentProvider {
    Multimap<ComponentType<?>, Object> collectComponents(ToolMaterialInfo info);
}
