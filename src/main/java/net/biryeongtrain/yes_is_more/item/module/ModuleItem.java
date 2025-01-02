package net.biryeongtrain.yes_is_more.item.module;

import eu.pb4.polymer.core.api.item.PolymerItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;
import xyz.nucleoid.packettweaker.PacketContext;

/**
 *
 */
public abstract class ModuleItem extends Item implements PolymerItem {
    public ModuleItem(Settings settings) {
        super(settings);
    }

    @Override
    public abstract @Nullable Identifier getPolymerItemModel(ItemStack stack, PacketContext context);

    public abstract ItemStack create();
    public abstract ItemStack createUnSafe();
}
