package net.biryeongtrain.yes_is_more.item.part;

import net.biryeongtrain.yes_is_more.YesIsMore;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import xyz.nucleoid.packettweaker.PacketContext;

public class PickaxePart extends PartItem {
    public PickaxePart() {
        super(YesIsMore.id("pickaxe_part"));
    }

    @Override
    public Item getPolymerItem(ItemStack itemStack, PacketContext packetContext) {
        return Items.PAPER;
    }

    @Override
    public Parts getPartType() {
        return Parts.PICKAXE_HEAD;
    }
}
