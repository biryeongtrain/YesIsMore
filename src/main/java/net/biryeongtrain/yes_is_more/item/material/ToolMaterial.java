package net.biryeongtrain.yes_is_more.item.material;

import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;

public abstract class ToolMaterialInfo {
    private final Item baseItem;
    private final Identifier materialId;

    public ToolMaterialInfo(Identifier id, Item baseItem) {
        this.baseItem = baseItem;
        this.materialId = id;
    }

    public Item getBaseItem() {
        return baseItem;
    }

    public Identifier getMaterialId() {
        return materialId;
    }

    public void onBreak(ItemStack stack, ServerPlayerEntity player, BlockState block) {

    }

    public void onEntityHit(ItemStack stack, ServerPlayerEntity hitter, Entity entity, DamageSource source) {
    }

    public void onEntityKill(ItemStack stack, ServerPlayerEntity killer, Entity entity, DamageSource source) {
    }
}
