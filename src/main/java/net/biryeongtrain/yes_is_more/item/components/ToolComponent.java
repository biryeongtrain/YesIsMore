package net.biryeongtrain.yes_is_more.item.components;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.biryeongtrain.yes_is_more.item.material.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

import java.util.Map;

public record ToolComponent(Map<Identifier, ToolMaterial> parts) {
    public static Codec<ToolComponent> CODEC = RecordCodecBuilder.create(instance -> instance.group(
        Codec.unboundedMap(Identifier.CODEC, ToolMaterial)
    )
    );
    public ItemStack getParts(Identifier partName) {
        if (parts.containsKey(partName)) {

        }
        return ItemStack.EMPTY;
    }
}
