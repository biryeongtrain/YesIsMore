package net.biryeongtrain.yes_is_more.item.components;

import eu.pb4.polymer.core.api.other.PolymerComponent;
import net.biryeongtrain.yes_is_more.item.material.ToolMaterialInfo;
import net.minecraft.component.ComponentType;

public class ItemComponents {
    public static ComponentType<ToolMaterialInfo> PARTS_MATERIAL_COMPONENT = ComponentType.<ToolMaterialInfo>builder().codec(ToolMaterialInfo.CODEC).build();
    public static ComponentType<ToolComponent> TOOL_COMPONENT = ComponentType.<ToolComponent>builder().codec(ToolComponent.CODEC).build();

    public static void init() {
        PolymerComponent.registerDataComponent(PARTS_MATERIAL_COMPONENT);
        PolymerComponent.registerDataComponent(TOOL_COMPONENT);
    }
}
