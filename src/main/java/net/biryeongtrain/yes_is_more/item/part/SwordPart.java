package net.biryeongtrain.yes_is_more.item.part;

import net.biryeongtrain.yes_is_more.item.material.ToolMaterialInfo;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;
import xyz.nucleoid.packettweaker.PacketContext;

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
}
