package net.biryeongtrain.yes_is_more.item.part;

import eu.pb4.polymer.core.api.item.PolymerItem;
import net.biryeongtrain.yes_is_more.item.material.ToolMaterialInfo;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;
import xyz.nucleoid.packettweaker.PacketContext;

public abstract class Part extends Item implements PolymerItem {

    private final ToolMaterialInfo material;
    private final Identifier part;

    public Part(Identifier part, ToolMaterialInfo material) {
        super(new Settings().maxCount(4));
        this.material = material;
        this.part = part;
    }

    public Identifier getPart() {
        return this.part;
    }

    @Override
    public abstract @Nullable Identifier getPolymerItemModel(ItemStack stack, PacketContext context);

    public void onBreak(ItemStack stack, ServerPlayerEntity player, BlockState block) {
        this.material.onBreak(stack, player, block);
    }

    public void onEntityHit(ItemStack stack, ServerPlayerEntity hitter, Entity entity, DamageSource source) {
        this.material.onEntityHit(stack, hitter, entity, source);
    }

    public void onEntityKill(ItemStack stack, ServerPlayerEntity killer, Entity entity, DamageSource source) {
        this.material.onEntityKill(stack, killer, entity, source);
    }
}
