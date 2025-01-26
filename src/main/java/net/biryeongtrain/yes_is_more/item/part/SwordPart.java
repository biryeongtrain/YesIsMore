package net.biryeongtrain.yes_is_more.item.part;

import net.biryeongtrain.yes_is_more.YesIsMore;
import net.biryeongtrain.yes_is_more.item.components.ItemComponents;
import net.biryeongtrain.yes_is_more.item.material.ToolMaterialInfo;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;
import xyz.nucleoid.packettweaker.PacketContext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static net.biryeongtrain.yes_is_more.YesIsMore.id;

public class SwordPart extends Part {
    public static final Identifier SWORD_PART_ID = id("sword_part");
    public final Identifier modelId;

    public SwordPart(Identifier modelId, ToolMaterialInfo toolMaterial) {
        super(SWORD_PART_ID, toolMaterial);
        this.modelId = modelId;
    }

    @Override
    public Item getPolymerItem(ItemStack itemStack, PacketContext packetContext) {
        return Items.PAPER;
    }

    @Override
    public @Nullable Identifier getPolymerItemModel(ItemStack stack, PacketContext context) {
        return this.modelId;
    }

    @Override
    protected Map<RegistryEntry<EntityAttribute>, EntityAttributeModifier> combine(ItemStack stack, Map<RegistryEntry<EntityAttribute>, EntityAttributeModifier> original) {
        ToolMaterialInfo info = stack.get(ItemComponents.PARTS_MATERIAL_COMPONENT);
        if (info != null) {
            var modifier = new EntityAttributeModifier(YesIsMore.id("part_sword"), info.material.attackDamageBonus(), EntityAttributeModifier.Operation.ADD_VALUE);
            original.put(EntityAttributes.ATTACK_DAMAGE, modifier);
        }
        return original;
    }
}
