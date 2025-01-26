package net.biryeongtrain.yes_is_more.item.part;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.biryeongtrain.yes_is_more.YesIsMore;
import net.biryeongtrain.yes_is_more.item.components.ItemComponents;
import net.biryeongtrain.yes_is_more.item.material.ToolMaterialInfo;
import net.minecraft.component.ComponentType;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.StringIdentifiable;

public enum Parts implements StringIdentifiable, ComponentProvider, AttributeProvider {
    SWORD_HEAD {
        @Override
        public Multimap<RegistryEntry<EntityAttribute>, EntityAttributeModifier> combine(ToolMaterialInfo info) {
            var map = super.combine(info);
            map.put(EntityAttributes.ATTACK_DAMAGE, new EntityAttributeModifier(YesIsMore.id("sword_part"), info.material.attackDamageBonus() + 3.0f, EntityAttributeModifier.Operation.ADD_VALUE));
            map.put(EntityAttributes.ATTACK_SPEED, new EntityAttributeModifier(YesIsMore.id("sword_part"), -2.4f, EntityAttributeModifier.Operation.ADD_VALUE));

            return map;
        }
    },

    PICKAXE_HEAD {

    },
    TOOL_BINDING {
        @Override
        public boolean affectsDurability() {
            return true;
        }
    }

    ;

    public static StringIdentifiable.EnumCodec<Parts> CODEC = StringIdentifiable.createCodec(Parts::values);

    @Override
    public String asString() {
        return this.toString();
    }

    public ToolMaterialInfo getInfo(ItemStack stack) {
        return stack.get(ItemComponents.PARTS_MATERIAL_COMPONENT);
    }

    public boolean affectsDurability() {
        return false;
    }
    @Override
    public Multimap<RegistryEntry<EntityAttribute>, EntityAttributeModifier> combine(ToolMaterialInfo info) {
        return HashMultimap.create();
    }


    @Override
    public Multimap<ComponentType<Object>, Object> collectComponents(ItemStack stack) {
        return HashMultimap.create();
    }
}


