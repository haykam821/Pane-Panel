package io.github.haykam821.panepanel.screen;

import java.util.List;
import java.util.stream.Collectors;

import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WGridPanel;
import io.github.cottonmc.cotton.gui.widget.WLabel;
import io.github.cottonmc.cotton.gui.widget.WListPanel;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.PaneBlock;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.registry.Registry;

public class PaneListingGui extends LightweightGuiDescription {
	private static final int WIDTH = 7;
	private static final int HEIGHT = 10;

	public PaneListingGui(MinecraftClient client) {
		WGridPanel root = (WGridPanel) this.getRootPanel();

		root.add(new WLabel(new TranslatableText("text.panepanel.listing.title")), 0, 0, WIDTH, 1);
		
		List<Block> glassPanes = Registry.BLOCK.stream().filter(block -> {
			return block instanceof PaneBlock && !block.is(Blocks.IRON_BARS);
		}).collect(Collectors.toList());

		WListPanel<Block, WLabel> list = new WListPanel<>(glassPanes, () -> new WLabel((Text) null), (block, label) -> {
			label.setText(block.getName());
		});
		list.setListItemHeight(18);
		root.add(list, 0, 1, WIDTH, HEIGHT - 1);

		root.validate(this);
	}
}
