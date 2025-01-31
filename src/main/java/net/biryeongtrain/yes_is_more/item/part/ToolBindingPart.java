package net.biryeongtrain.yes_is_more.item.part;

import net.biryeongtrain.yes_is_more.YesIsMore;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import xyz.nucleoid.packettweaker.PacketContext;

public class ToolBindingPart extends PartItem{
    public ToolBindingPart() {
        super(YesIsMore.id("tool_binding_part"));
    }

    @Override
    public Parts getPartType() {
        return Parts.TOOL_BINDING;
    }

    @Override
    public Item getPolymerItem(ItemStack itemStack, PacketContext packetContext) {
        return null;
    }
}
