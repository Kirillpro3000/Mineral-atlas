package net.kirill.MineralAtlas.common.item;

import net.kirill.MineralAtlas.MineralAtlas;
import net.kirill.MineralAtlas.network.ExampleServerboundPacket;
import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.network.chat.Component;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

import java.util.List;

public class MineralAtlasItem extends Item {

	public static final String EXAMPLE_TOOLTIP = MineralAtlas.lang("tooltip.example_item.example_tooltip");

	public MineralAtlasItem(final Properties properties) {
		super(properties);
	}

	@Override
	public InteractionResultHolder<ItemStack> use(final Level level, final Player player, final InteractionHand usedHand) {
		if (level.isClientSide) {
			return InteractionResultHolder.consume(player.getItemInHand(usedHand));
		}
		return InteractionResultHolder.success(player.getItemInHand(usedHand));
	}
}