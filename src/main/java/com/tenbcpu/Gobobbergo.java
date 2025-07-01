package com.tenbcpu;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Gobobbergo implements ModInitializer {
    public static final String MOD_ID = "gobobbergo";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Get ready to fish! Come on Bobber, go bobber go!");
        ModComponents.register();

        // Register commands
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            PowerGiveCommand.register(dispatcher);
        });
    }
}