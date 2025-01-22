package net.biryeongtrain.yes_is_more.item.components;

import com.google.common.collect.ImmutableMap;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.biryeongtrain.yes_is_more.item.material.ToolMaterialInfo;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

import java.util.Map;
import java.util.Objects;

public final class ToolComponent {
    public static Codec<ToolComponent> CODEC = Codec.lazyInitialized(() -> RecordCodecBuilder.create(instance -> instance.group(
                    Codec.unboundedMap(Identifier.CODEC, ToolMaterialInfo.CODEC).fieldOf("tool_components").forGetter(ToolComponent::parts)
            ).apply(instance, ToolComponent::new)
    ));
    private final Map<Identifier, ToolMaterialInfo> parts;

    public ToolComponent(Map<Identifier, ToolMaterialInfo> parts) {
        this.parts = parts;
    }

    public ItemStack getParts(Identifier partName) {
        if (parts.containsKey(partName)) {

        }
        return ItemStack.EMPTY;
    }

    private Map<Identifier, ToolMaterialInfo> parts() {
        return parts;
    }

    public Map<Identifier, ToolMaterialInfo> getParts() {
        return ImmutableMap.copyOf(parts);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (ToolComponent) obj;
        return Objects.equals(this.parts, that.parts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parts);
    }

    @Override
    public String toString() {
        return "ToolComponent[" +
                "parts=" + parts + ']';
    }

}
