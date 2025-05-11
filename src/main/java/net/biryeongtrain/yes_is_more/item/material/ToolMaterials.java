package net.biryeongtrain.yes_is_more.item.material;

import net.biryeongtrain.yes_is_more.ToolMaterialManager;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.Identifier;

public class ToolMaterials {
    public static final ToolMaterialInfo WOODEN = ToolMaterialInfo.Builder
            .createNew(ToolMaterial.WOOD, Identifier.ofVanilla("wooden"), 0.7f, 0.8f)
            .build();
    public static final ToolMaterialInfo STONE = ToolMaterialInfo.Builder
            .createNew(ToolMaterial.STONE, Identifier.ofVanilla("stone"), 0.8f, 0.85f)
            .build();
    public static final ToolMaterialInfo IRON = ToolMaterialInfo.Builder
            .createNew(ToolMaterial.IRON, Identifier.ofVanilla("iron"), 1.0f, 1.0f)
            .build();
    public static final ToolMaterialInfo GOLD = ToolMaterialInfo.Builder
            .createNew(ToolMaterial.GOLD, Identifier.ofVanilla("gold"), 0.6f, 1.3f)
            .build();
    public static final ToolMaterialInfo DIAMOND = ToolMaterialInfo.Builder.createNew(ToolMaterial.DIAMOND,
            Identifier.ofVanilla("diamond"), 1.2f, 1.2f)
            .build();
    public static final ToolMaterialInfo NETHERITE = ToolMaterialInfo.Builder
            .createNew(ToolMaterial.NETHERITE, Identifier.ofVanilla("netherite"), 1.25f, 1.25f)
            .build();

    public static void register() {
        ToolMaterialManager.getInstance().register(WOODEN);
        ToolMaterialManager.getInstance().register(STONE);
        ToolMaterialManager.getInstance().register(IRON);
        ToolMaterialManager.getInstance().register(GOLD);
        ToolMaterialManager.getInstance().register(DIAMOND);
        ToolMaterialManager.getInstance().register(NETHERITE);
    }
}
