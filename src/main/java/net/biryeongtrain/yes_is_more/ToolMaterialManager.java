package net.biryeongtrain.yes_is_more;

import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.biryeongtrain.yes_is_more.item.material.ToolMaterialInfo;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.Identifier;

public class ToolMaterialManager {
    public static final ToolMaterialInfo UNKNOWN = ToolMaterialInfo.Builder.createNew(ToolMaterial.WOOD,YesIsMore.id("unknown"),
            1.0f, 1.0f)
            .build();
    private static ToolMaterialManager INSTANCE;
    private final Object2ObjectMap<Identifier, ToolMaterialInfo> ID_TO_INFO_MAP = new Object2ObjectOpenHashMap<>();
    private final Object2ObjectMap<ToolMaterial, ToolMaterialInfo> MATERIAL_INFO_MAP = new Object2ObjectOpenHashMap<>();
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

    public ToolMaterialInfo getToolMaterial(Identifier info) {
        return ID_TO_INFO_MAP.getOrDefault(info, UNKNOWN);
    }

    public ToolMaterialInfo getToolMaterial(ToolMaterial material) {
        return MATERIAL_INFO_MAP.getOrDefault(material, UNKNOWN);
    }

}
