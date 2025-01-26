package net.biryeongtrain.yes_is_more.item.components;

import com.google.common.collect.*;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.biryeongtrain.yes_is_more.item.material.ToolMaterialInfo;
import net.biryeongtrain.yes_is_more.item.part.Parts;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;

import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;

public final class ToolComponent {
    public static Codec<ToolComponent> CODEC = Codec.lazyInitialized(() -> RecordCodecBuilder.create(instance -> instance.group(
                    Codec.unboundedMap(Parts.CODEC, ToolMaterialInfo.CODEC).fieldOf("tool_components").forGetter(ToolComponent::parts)
            ).apply(instance, (map) -> new ToolComponent(Maps.newEnumMap(map)))
    ));
    private final EnumMap<Parts, ToolMaterialInfo> parts;

    public ToolComponent(EnumMap<Parts, ToolMaterialInfo> parts) {
        this.parts = parts;
    }

    public ItemStack getParts(Parts partName) {
        if (parts.containsKey(partName)) {
              // TODO create part ItemStack Logic
        }
        return ItemStack.EMPTY;
    }

    public Multimap<RegistryEntry<EntityAttribute>, EntityAttributeModifier> getModifiers() {
        Multimap<RegistryEntry<EntityAttribute>, EntityAttributeModifier> map = HashMultimap.create();
        this.parts.forEach((part, info) ->{
            map.putAll  (part.combine(info));
        });
        // todo need test
        return map;
    }

    public int getMaxDamage() {

    }

    private Map<Parts, ToolMaterialInfo> parts() {
        return parts;
    }

    public Map<Parts, ToolMaterialInfo> getParts() {
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
