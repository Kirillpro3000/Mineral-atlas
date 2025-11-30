package net.kirill.MineralAtlas;

import net.kirill.MineralAtlas.client.*;
import net.kirill.MineralAtlas.common.block.MineralAtlasModOre;
import net.kirill.MineralAtlas.common.item.MineralAtlasModItems;
import net.kirill.MineralAtlas.common.tabs;
import net.kirill.MineralAtlas.config.MineralAtlasConfig;
import net.kirill.MineralAtlas.network.ExampleModPackets;
import com.mojang.logging.LogUtils;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.*;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig.Type;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import org.slf4j.Logger;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab.TabVisibility;
import net.minecraft.world.item.CreativeModeTabs;

@Mod(MineralAtlas.MOD_ID)
public final class MineralAtlas {

	public static final Logger LOG = LogUtils.getLogger();
	public static final String MOD_ID = "mineral_atlas";

	public MineralAtlas(final ModContainer modContainer, final IEventBus modBus, final Dist dist) {
		modBus.addListener(ExampleModPackets::init);

		// You likely don't want all of these.
		modContainer.registerConfig(Type.COMMON, MineralAtlasConfig.COMMON.spec());
		modContainer.registerConfig(Type.CLIENT, MineralAtlasConfig.CLIENT.spec());
		modContainer.registerConfig(Type.SERVER, MineralAtlasConfig.SERVER.spec());
		modContainer.registerConfig(Type.STARTUP, MineralAtlasConfig.STARTUP.spec());

		modBus.register(MineralAtlas.class);
		MineralAtlasModItems.ITEMS.register(modBus);
        MineralAtlasModOre.BLOCKS.register(modBus);
        tabs.register(modBus);

		MineralAtlasForgeEvents.init(NeoForge.EVENT_BUS);

		if (dist == Dist.CLIENT) {
			MineralAtlasClientEvents.init(modContainer, modBus);
			MineralAtlasClientForgeEvents.init(NeoForge.EVENT_BUS);
		}
	}

	@SubscribeEvent
	private static void onCreativeTabBuild(final BuildCreativeModeTabContentsEvent event) {
		if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
			event.accept(MineralAtlasModItems.EXAMPLE_ITEM.toStack(), TabVisibility.PARENT_AND_SEARCH_TABS);
		}
	}

	/**
	 * Shorthand for {@code ResourceLocation.fromNamespaceAndPath(MOD_ID, path)}
	 */
	public static ResourceLocation location(final String path) {
		return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
	}

	/**
	 * Helper for creating modid prepended lang keys
	 */
	public static String lang(final String langKey) {
		return MOD_ID + "." + langKey;
	}
}