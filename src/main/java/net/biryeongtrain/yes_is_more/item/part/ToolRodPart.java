package net.biryeongtrain.yes_is_more.item.part;

import net.biryeongtrain.yes_is_more.YesIsMore;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import xyz.nucleoid.packettweaker.PacketContext;

public class ToolRodPart extends PartItem {
    public ToolRodPart() {
        super(YesIsMore.id("tool_rod_part"));
    }

    @Override
    public Parts getPartType() {
        return Parts.TOOL_ROD;
    }

    @Override
    public Item getPolymerItem(ItemStack itemStack, PacketContext packetContext) {
        return Items.PAPER;
    }
}
