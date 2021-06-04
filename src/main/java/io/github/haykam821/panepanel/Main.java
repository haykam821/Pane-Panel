package io.github.haykam821.panepanel;

import io.github.haykam821.panepanel.command.PanePanelCommand;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.command.v1.ClientCommandManager;

public class Main implements ModInitializer {
	@Override
	public void onInitialize() {
		PanePanelCommand.register(ClientCommandManager.DISPATCHER);
	}
}
