package com.tenbcpu;

import com.mojang.brigadier.arguments.DoubleArgumentType;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.CommandDispatcher;

import java.util.function.Supplier;

public class PowerGiveCommand {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(
            CommandManager.literal("pgive")
                .then(CommandManager.argument("power", DoubleArgumentType.doubleArg(0.1))  // minimum power 0.1
                    .executes(context -> givePowerRod(context, DoubleArgumentType.getDouble(context, "power")))
                )
                .executes(context -> givePowerRod(context, 2.0)) // default power 2.0 if no argument given
        );
        dispatcher.register(
            CommandManager.literal("powergive")
                .then(CommandManager.argument("power", DoubleArgumentType.doubleArg(0.1))  // minimum power 0.1
                    .executes(context -> givePowerRod(context, DoubleArgumentType.getDouble(context, "power")))
                )
                .executes(context -> givePowerRod(context, 2.0)) // default power 2.0 if no argument given
        );
    }

    private static int givePowerRod(CommandContext<ServerCommandSource> context, double power) {
        var player = context.getSource().getPlayer();
        if (player == null) {
            context.getSource().sendFeedback((Supplier<Text>) Text.literal("This command can only be run by a player").formatted(Formatting.RED), false);
            return 0;
        }

        ItemStack rod = new ItemStack(Items.FISHING_ROD);
        rod.set(ModComponents.POWER, power);  // your custom component setter here

        player.getInventory().insertStack(rod);
        context.getSource().sendFeedback((Supplier<Text>) Text.literal("Given fishing rod with Power " + power), true);
        return 1;  // success
    }
}