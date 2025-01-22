package net.biryeongtrain.yes_is_more.item.material;

import com.mojang.serialization.Codec;
import net.biryeongtrain.yes_is_more.ToolMaterialManager;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;

public abstract class ToolMaterialInfo {
    public static final Codec<ToolMaterialInfo> CODEC;
    private final ToolMaterial material;
    private final Identifier materialId;

    private final float durabilityModifier;
    private final float breakingSpeedModifier;

    public ToolMaterialInfo(Identifier id, ToolMaterial material) {
        this.material = material;
        this.materialId = id;
    }

    public ToolMaterial getMaterial() {
        return material;
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
