package net.biryeongtrain.yes_is_more.item.module;

import net.biryeongtrain.yes_is_more.YesIsMore;
import net.biryeongtrain.yes_is_more.item.part.Parts;
import net.biryeongtrain.yes_is_more.item.part.SwordPart;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.CustomModelDataComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;
import xyz.nucleoid.packettweaker.PacketContext;

import java.util.EnumSet;
import java.util.List;

public class SwordModuleItem extends ModuleItem {
    public SwordModuleItem() {
        super(createAttributeModifiers());
    }

    public static Settings createAttributeModifiers() {
        return ToolMaterial.WOOD.applySwordSettings(new Settings(), 0.0f, -2.4f);
    }

    @Override
    public Item getPolymerItem(ItemStack itemStack, PacketContext packetContext) {
        return Items.WOODEN_SWORD;
    }

    @Override
    public @Nullable Identifier getPolymerItemModel(ItemStack stack, PacketContext context) {
        return YesIsMore.id("item/sword_module");
    }

    @Override
    public EnumSet<Parts> getParts() {
        return EnumSet.of(Parts.SWORD_HEAD, Parts.TOOL_BINDING, Parts.TOOL_ROD);
    }

    @Override
    public ItemStack getPolymerItemStack(ItemStack itemStack, TooltipType tooltipType, PacketContext context) {
        ItemStack stack =  super.getPolymerItemStack(itemStack, tooltipType, context);
        stack.set(DataComponentTypes.CUSTOM_MODEL_DATA, new CustomModelDataComponent(List.of(), List.of(), List.of(), List.of()));
        return stack;
    }

    public static SwordModuleItem createSwordModuleItem(SwordPart swordPart) {

    }
}
