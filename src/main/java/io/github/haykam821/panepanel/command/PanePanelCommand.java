package io.github.haykam821.panepanel.command;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;

import io.github.haykam821.panepanel.screen.PaneListingScreen;
import net.fabricmc.fabric.api.client.command.v1.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v1.FabricClientCommandSource;
import net.minecraft.client.MinecraftClient;

public class PanePanelCommand {
	public static void register(CommandDispatcher<FabricClientCommandSource> dispatcher) {
		dispatcher.register(ClientCommandManager
			.literal("panepanel")
			.executes(PanePanelCommand::execute));
	}

	public static int execute(CommandContext<FabricClientCommandSource> context) {
		MinecraftClient client = context.getSource().getClient();
		client.send(() -> {
			client.openScreen(new PaneListingScreen(client));
		});

		return Command.SINGLE_SUCCESS;
	}
}
