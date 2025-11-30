package net.kirill.MineralAtlas.common.item;

import net.kirill.MineralAtlas.MineralAtlas;
import net.neoforged.neoforge.registries.*;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;

import java.util.function.Function;

public final class MineralAtlasModItems {

	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MineralAtlas.MOD_ID);

	public static final DeferredItem<MineralAtlasItem> EXAMPLE_ITEM = register("example_item", MineralAtlasItem::new);
    //test
    public static final DeferredItem<MineralAtlasItem> ALBITE = register("albite", MineralAtlasItem::new);
    //copper ore
    public static final DeferredItem<MineralAtlasItem> POOR_CHALCOPYRITE = register("poor_chalcopyrite", MineralAtlasItem::new);
    public static final DeferredItem<MineralAtlasItem> NORMAL_CHALCOPYRITE = register("normal_chalcopyrite", MineralAtlasItem::new);
    public static final DeferredItem<MineralAtlasItem> RICH_CHALCOPYRITE = register("rich_chalcopyrite", MineralAtlasItem::new);

    private static <I extends Item> DeferredItem<I> register(final String name, final Function<Properties, ? extends I> factory,
			final Properties properties) {
		return ITEMS.registerItem(name, factory, properties);
	}

	private static <I extends Item> DeferredItem<I> register(final String name, final Function<Properties, ? extends I> factory) {
		return ITEMS.registerItem(name, factory);
	}

	private static DeferredItem<Item> registerSimple(final String name, Properties properties) {
		return ITEMS.registerSimpleItem(name, properties);
	}

	private static DeferredItem<Item> registerSimple(final String name) {
		return ITEMS.registerSimpleItem(name);
	}
}