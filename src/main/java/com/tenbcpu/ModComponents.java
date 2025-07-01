package com.tenbcpu;

import net.minecraft.util.Identifier;
import net.minecraft.registry.Registry;
import com.mojang.serialization.Codec;
import net.minecraft.component.DataComponentType;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.registry.Registries;

public class ModComponents {
    public static final DataComponentType<Double> POWER = DataComponentType.<Double>builder()
        .codec(Codec.DOUBLE)
        .packetCodec(PacketCodecs.DOUBLE)
        .build();

    public static void register() {
        Registry.register(Registries.DATA_COMPONENT_TYPE, new Identifier("gobobbergo", "power"), POWER);
    }
}