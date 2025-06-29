package com.tenbcpu;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Gobobbergo implements ModInitializer {
	public static final String MOD_ID = "gobobbergo";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Get ready to fish! Come on Bobber, go bobber go!");
	}
}