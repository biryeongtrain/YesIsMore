package net.biryeongtrain.yes_is_more;

import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.biryeongtrain.yes_is_more.item.material.ToolMaterialInfo;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.Identifier;

import java.util.Map;

public class ToolMaterialManager {
    private static ToolMaterialManager INSTANCE;
    private final Object2ObjectMap<Identifier, ToolMaterialInfo> MAP = new Object2ObjectOpenHashMap<>();
    private ToolMaterialManager() {
        if (INSTANCE != null) {
            throw new IllegalStateException("ToolMaterialManager has already been initialized.");
        }
    }

    public static ToolMaterialManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ToolMaterialManager();
        }
        return INSTANCE;
    }

    public ToolMaterialInfo getToolMaterial(ToolMaterial info) {
        return MAP.getOrDefault(info, null);
    }


}
