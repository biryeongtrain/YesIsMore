package net.biryeongtrain.yes_is_more;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class YesIsMore implements ModInitializer {
    public static final String MOD_ID = "yes_is_more";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Hello Fabric world!");
    }

    public static Identifier id(String path) {
        return Identifier.of(MOD_ID, path);
    }

}
