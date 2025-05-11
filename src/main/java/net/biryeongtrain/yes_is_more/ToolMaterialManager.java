package net.biryeongtrain.yes_is_more;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
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

    public void register(ToolMaterialInfo info) {
        ID_TO_INFO_MAP.put(info.materialId, info);
        MATERIAL_INFO_MAP.put(info.material, info);
    }

    public String getSwordModel() {
        JsonArray jsonArray = new JsonArray();
        this.ID_TO_INFO_MAP.values().forEach(info -> {
            JsonObject materialJson = new JsonObject();
            materialJson.addProperty("when", info.materialId.toString());
            JsonObject modelJson = new JsonObject();
            modelJson.addProperty("type", "minecraft:model");
            modelJson.addProperty("model", YesIsMore.id("item/" + info.materialId.getPath()) + "_" + "sword_head");
            materialJson.add("model", modelJson);
            jsonArray.add(materialJson);
        });

        return jsonArray.getAsString();
    }
}
