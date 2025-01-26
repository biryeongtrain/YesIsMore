package net.biryeongtrain.yes_is_more.item.part;

import com.google.common.collect.Multimap;
import net.minecraft.component.ComponentType;
import net.minecraft.item.ItemStack;

public interface ComponentProvider {
    Multimap<ComponentType<Object>, Object> collectComponents(ItemStack stack);
}
