package io.github.haykam821.panepanel.screen;

import io.github.cottonmc.cotton.gui.client.CottonClientScreen;
import net.minecraft.client.MinecraftClient;

public class PaneListingScreen extends CottonClientScreen {
	public PaneListingScreen(MinecraftClient client) {
		super(new PaneListingGui(client));
	}
}
