package net.biryeongtrain.yes_is_more.item.material;

import com.mojang.serialization.Codec;
import net.biryeongtrain.yes_is_more.util.function.QuadConsumer;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;
import org.apache.commons.lang3.function.TriConsumer;

public class ToolMaterialInfo {
    public static final Codec<ToolMaterialInfo> CODEC;
    private final ToolMaterial material;
    private final Identifier materialId;

    private final float durabilityModifier;
    private final float breakingSpeedModifier;

    private final TriConsumer<ItemStack, ServerPlayerEntity, BlockState> onBreakCallback;
    private final QuadConsumer<ItemStack, ServerPlayerEntity, Entity, DamageSource> onEntityHitCallback;
    private final QuadConsumer<ItemStack, ServerPlayerEntity, Entity, DamageSource> onEntityKillCallback;
    private final TriConsumer<ItemStack, ServerPlayerEntity, Boolean> onTickCallback;

    private ToolMaterialInfo(Identifier id, ToolMaterial material, float durabilityModifier, float breakingSpeedModifier,
                            TriConsumer<ItemStack, ServerPlayerEntity, BlockState> onBreakCallback,
                            QuadConsumer<ItemStack, ServerPlayerEntity, Entity, DamageSource> onEntityHitCallback,
                            QuadConsumer<ItemStack, ServerPlayerEntity, Entity, DamageSource> onEntityKillCallback,
                            TriConsumer<ItemStack, ServerPlayerEntity, Boolean> onTickCallback) {
        this.material = material;
        this.materialId = id;
        this.durabilityModifier = durabilityModifier;
        this.breakingSpeedModifier = breakingSpeedModifier;
        this.onBreakCallback = onBreakCallback != null ? onBreakCallback : ((itemStack, serverPlayerEntity, blockState) -> {});
        this.onEntityHitCallback = onEntityHitCallback != null ? onEntityHitCallback : ((itemStack, serverPlayerEntity, entity, attacker) -> {});
        this.onEntityKillCallback = onEntityKillCallback != null ? onEntityKillCallback : ((itemStack, serverPlayerEntity, entity, attacker) -> {});
        this.onTickCallback = onTickCallback != null ? onTickCallback : ((itemStack, serverPlayerEntity, attacker) -> {});
    }
    public ToolMaterial getMaterial() {
        return material;
    }

    public Identifier getMaterialId() {
        return materialId;
    }

    public void onBreak(ItemStack stack, ServerPlayerEntity player, BlockState block) {
        this.onBreakCallback.accept(stack, player, block);
    }

    public void onEntityHit(ItemStack stack, ServerPlayerEntity hitter, Entity entity, DamageSource source) {
        this.onEntityHitCallback.accept(stack, hitter, entity, source);
    }

    public void onEntityKill(ItemStack stack, ServerPlayerEntity killer, Entity entity, DamageSource source) {
        this.onEntityKillCallback.accept(stack, killer, entity, source);
    }

    public void onTick(ItemStack stack, ServerPlayerEntity player, boolean isInHand) {
        this.onTickCallback.accept(stack, player, isInHand);
    }

    public static class Builder {
        private final Identifier id;
        private final ToolMaterial material;
        private float durabilityModifier;
        private float breakingSpeedModifier;
        private TriConsumer<ItemStack, ServerPlayerEntity, BlockState> onBreakCallback;
        private QuadConsumer<ItemStack, ServerPlayerEntity, Entity, DamageSource> onEntityHitCallback;
        private QuadConsumer<ItemStack, ServerPlayerEntity, Entity, DamageSource> onEntityKillCallback;
        private TriConsumer<ItemStack, ServerPlayerEntity, Boolean> onTickCallback;

        private Builder(ToolMaterial material, Identifier id, float durabilityModifier, float breakingSpeedModifier) {
            this.id = id;
            this.material = material;
            this.durabilityModifier = durabilityModifier;
            this.breakingSpeedModifier = breakingSpeedModifier;
        }

        public static Builder createNew(ToolMaterial base, Identifier id, float durabilityModifier, float breakingSpeedModifier) {
            return new Builder(base, id, durabilityModifier, breakingSpeedModifier);
        }

        public static Builder copyAs(ToolMaterialInfo info, Identifier id, ToolMaterial base) {
            return new Builder(base, id, info.durabilityModifier, info.breakingSpeedModifier);
        }

        public Builder durabilityModifier(float newValue) {
            newValue = Math.max(0, newValue);
            this.durabilityModifier = newValue;
            return this;
        }

        public Builder breakSpeedModifier(float newValue) {
            newValue = Math.max(0, newValue);
            this.breakingSpeedModifier = newValue;
            return this;
        }

        public Builder onTick(TriConsumer<ItemStack, ServerPlayerEntity, Boolean> onTickCallback) {
            this.onTickCallback = onTickCallback;
            return this;
        }

        public Builder onBreak(TriConsumer<ItemStack, ServerPlayerEntity, BlockState> onBreakCallback) {
            this.onBreakCallback = onBreakCallback;
            return this;
        }

        public Builder onEntityHit(QuadConsumer<ItemStack, ServerPlayerEntity, Entity, DamageSource> onEntityHitCallback) {
            this.onEntityHitCallback = onEntityHitCallback;
            return this;
        }

        public Builder onEntityKill(QuadConsumer<ItemStack, ServerPlayerEntity, Entity, DamageSource> onEntityKillCallback) {
            this.onEntityKillCallback = onEntityKillCallback;
            return this;
        }

        public ToolMaterialInfo build() {
            return new ToolMaterialInfo(id, material, durabilityModifier, breakingSpeedModifier,
                    onBreakCallback, onEntityHitCallback, onEntityKillCallback, onTickCallback);
        }
    }
}
