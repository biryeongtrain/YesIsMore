package net.biryeongtrain.yes_is_more.item.part;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import xyz.nucleoid.packettweaker.PacketContext;

import static net.biryeongtrain.yes_is_more.YesIsMore.id;

public class SwordPart extends PartItem {
    public static final Identifier SWORD_PART_MODEL_ID = id("sword_part");

    public SwordPart() {
        super(SWORD_PART_MODEL_ID);
    }

    @Override
    public Item getPolymerItem(ItemStack itemStack, PacketContext packetContext) {
        return Items.PAPER;
    }

    @Override
    public Parts getPartType() {
        return Parts.SWORD_HEAD;
    }
}
