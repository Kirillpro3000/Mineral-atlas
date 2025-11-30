package net.kirill.MineralAtlas;

import net.neoforged.bus.api.*;
import net.neoforged.neoforge.event.tick.LevelTickEvent;

public final class MineralAtlasForgeEvents {

	public static void init(final IEventBus eventBus) {
		// Register all static @SubscribeEvent annotated event methods
		eventBus.register(MineralAtlasForgeEvents.class);
	}

	@SubscribeEvent
	private static void onTick(final LevelTickEvent.Post event) {
		if (event.getLevel().getGameTime() % 100 != 0) {
			return;
		}
		MineralAtlas.LOG.debug("This is a debug log every 100 ticks! (5 seconds)");
	}
}