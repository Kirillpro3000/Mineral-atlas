package net.kirill.MineralAtlas.client;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;

import net.minecraft.network.chat.Component;

public final class MineralAtlasClientForgeEvents {

	public static void init(final IEventBus eventBus) {
		eventBus.addListener(MineralAtlasClientForgeEvents::onItemTooltip);
	}

	private static void onItemTooltip(final ItemTooltipEvent event) {
		event.getToolTip().add(Component.literal("This component was added via an event!"));
	}
}