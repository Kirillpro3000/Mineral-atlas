package net.kirill.MineralAtlas.common.block;

import net.kirill.MineralAtlas.MineralAtlas;
import net.kirill.MineralAtlas.common.item.MineralAtlasModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class MineralAtlasModOre {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(MineralAtlas.MOD_ID);

    public static final DeferredBlock<Block> POOR_GRANITE_ALBITE_ORE = registerBlock("poor_granite_albite_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.STONE).strength(6.5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final DeferredBlock<Block> POOR_GRANITE_CHALCOPYRITE_ORE = registerBlock("poor_granite_chalcopyrite_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.STONE).strength(6.5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final DeferredBlock<Block> NORMAL_GRANITE_CHALCOPYRITE_ORE = registerBlock("normal_granite_chalcopyrite_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.STONE).strength(6.5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> RICH_GRANITE_CHALCOPYRITE_ORE = registerBlock("rich_granite_chalcopyrite_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.STONE).strength(6.5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));


    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block){
        MineralAtlasModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }

}
