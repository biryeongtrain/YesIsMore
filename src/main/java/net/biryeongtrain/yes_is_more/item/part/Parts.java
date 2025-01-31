package net.biryeongtrain.yes_is_more.item.part;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.biryeongtrain.yes_is_more.item.PartItems;
import net.biryeongtrain.yes_is_more.item.components.ItemComponents;
import net.biryeongtrain.yes_is_more.item.material.ToolMaterialInfo;
import net.biryeongtrain.yes_is_more.util.AttributeProvider;
import net.biryeongtrain.yes_is_more.util.ComponentProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.component.ComponentType;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.ToolComponent;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.entry.RegistryEntryList;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.math.MathHelper;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public enum Parts implements StringIdentifiable, ComponentProvider, AttributeProvider {
    SWORD_HEAD {
        @Override
        public Multimap<RegistryEntry<EntityAttribute>, EntityAttributeModifier> combine(ToolMaterialInfo info) {
            var map = super.combine(info);
            map.put(EntityAttributes.ATTACK_DAMAGE, new EntityAttributeModifier(Item.BASE_ATTACK_DAMAGE_MODIFIER_ID, info.material.attackDamageBonus() + 3.0f, EntityAttributeModifier.Operation.ADD_VALUE));
            map.put(EntityAttributes.ATTACK_SPEED, new EntityAttributeModifier(Item.BASE_ATTACK_SPEED_MODIFIER_ID, -2.4f, EntityAttributeModifier.Operation.ADD_VALUE));

            return map;
        }

        @Override
        public Multimap<ComponentType<?>, Object> collectComponents(ToolMaterialInfo info) {
            var map = super.collectComponents(info);
            RegistryEntryLookup<Block> lookup = Registries.createEntryLookup(Registries.BLOCK);
            map.put(DataComponentTypes.TOOL, new ToolComponent(List.of(
                    ToolComponent.Rule.ofAlwaysDropping(RegistryEntryList.of(Blocks.COBWEB.getRegistryEntry()), 15.0f),
                    ToolComponent.Rule.of(lookup.getOrThrow(BlockTags.SWORD_EFFICIENT), 1.5f)),
                    1.0f, 2)
            );

            return map;
        }

        @Override
        public Item getItem() {
            return PartItems.SWORD_MODULE;
        }
    },

    PICKAXE_HEAD {
        @Override
        public Multimap<ComponentType<?>, Object> collectComponents(ToolMaterialInfo info) {
            var map = super.collectComponents(info);
            RegistryEntryLookup<Block> lookup = Registries.createEntryLookup(Registries.BLOCK);
            map.put(DataComponentTypes.TOOL, new ToolComponent(
                    List.of(ToolComponent.Rule.ofNeverDropping(lookup.getOrThrow(info.material.incorrectBlocksForDrops())),
                            ToolComponent.Rule.ofAlwaysDropping(lookup.getOrThrow(BlockTags.PICKAXE_MINEABLE), info.material.speed())
                    ),
                    1f,  1
                    ));
            return map;
        }

        @Override
        public Item getItem() {
            return
        }

        @Override
        public Multimap<RegistryEntry<EntityAttribute>, EntityAttributeModifier> combine(ToolMaterialInfo info) {
            var map = super.combine(info);
            map.put(EntityAttributes.ATTACK_DAMAGE, new EntityAttributeModifier(Item.BASE_ATTACK_DAMAGE_MODIFIER_ID, info.material.attackDamageBonus() + 1.0f, EntityAttributeModifier.Operation.ADD_VALUE));
            map.put(EntityAttributes.ATTACK_SPEED, new EntityAttributeModifier(Item.BASE_ATTACK_SPEED_MODIFIER_ID, -2.8f, EntityAttributeModifier.Operation.ADD_VALUE));
            return map;
        }
    },
    TOOL_BINDING {
        @Override
        public void after(@NotNull ItemStack stack, ToolMaterialInfo info) {
            if (!stack.hasChangedComponent(DataComponentTypes.MAX_DAMAGE)) {
                return;
            }
            int value = stack.get(DataComponentTypes.MAX_DAMAGE);
            stack.set(DataComponentTypes.MAX_DAMAGE, MathHelper.floor(value * info.durabilityModifier));
        }
    },
    TOOL_ROD {
        @Override
        public Multimap<ComponentType<?>, Object> collectComponents(ToolMaterialInfo info) {
            var map = super.collectComponents(info);
            map.put(DataComponentTypes.MAX_DAMAGE, info.material.durability());

            return map;
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

    @Override
    public Multimap<RegistryEntry<EntityAttribute>, EntityAttributeModifier> combine(ToolMaterialInfo info) {
        return HashMultimap.create();
    }


    @Override
    public Multimap<ComponentType<?>, Object> collectComponents(ToolMaterialInfo info) {
        return HashMultimap.create();
    }

    public void after(ItemStack stack, ToolMaterialInfo info) {

    }

    public ItemStack createItemStack(ToolMaterialInfo info) {
        ItemStack stack = new ItemStack(this.getItem());
        stack.set(ItemComponents.PARTS_MATERIAL_COMPONENT, info);
        return stack;
    }

    public abstract Item getItem();
}


