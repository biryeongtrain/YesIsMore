package net.biryeongtrain.yes_is_more;

import eu.pb4.polymer.resourcepack.api.PolymerResourcePackUtils;
import eu.pb4.polymer.resourcepack.api.ResourcePackBuilder;
import net.biryeongtrain.yes_is_more.item.module.ModuleItem;

public class ResourcePackGenerator {
    public static void init() {
        PolymerResourcePackUtils.RESOURCE_PACK_CREATION_EVENT.register(builder -> {

        });
    }

    public static String getModelJson(ModuleItem item) {
        var json = """
                {
                  "model": {
                    "type": "minecraft:composite",
                    "models": [
                      {
                        "type": "minecraft:model",
                        "model": "qf:item/test_model"
                      },
                      {
                        "type": "minecraft:select",
                        "property": "minecraft:custom_model_data",
                        "index": 0,
                        "cases": [
                          {SWORD_HEAD_MODELS}
                        ],
                        "fallback": {
                          "type": "minecraft:model",
                          "model": "minecraft:item/iron_ingot"
                        }
                      },
                      {
                        "type": "minecraft:select",
                        "property": "minecraft:custom_model_data",
                        "index": 1,
                        "cases": [
                          {CROSS_GUARD_MODELS}
                        ],
                        "fallback": {
                          "type": "minecraft:model",
                          "model": "minecraft:item/diamond"
                        }
                      }.
                                            {
                        "type": "minecraft:select",
                        "property": "minecraft:custom_model_data",
                        "index": 2,
                        "cases": [
                          {GRIP_MODELS}
                        ],
                        "fallback": {
                          "type": "minecraft:model",
                          "model": "minecraft:item/diamond"
                        }
                      }
                    ]
                  }
                }
                """;
        return null;
    }
}
