package net.kirill.MineralAtlas.common;

import net.kirill.MineralAtlas.MineralAtlas;
import net.kirill.MineralAtlas.common.block.MineralAtlasModOre;
import net.kirill.MineralAtlas.common.item.MineralAtlasModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class tabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MineralAtlas.MOD_ID);

    public static final Supplier<CreativeModeTab> MINERAL_ATLAS_GEMS = CREATIVE_MODE_TAB.register("mineral_atlas_gems",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(MineralAtlasModItems.ALBITE.get()))
                    .title(Component.translatable("creativetab.mineral_atlas.mineral_atlas_gems"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(MineralAtlasModItems.ALBITE);
                    })
                    .build());

    public static final Supplier<CreativeModeTab> MINERAL_ATLAS_ORE = CREATIVE_MODE_TAB.register("mineral_atlas_ore",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(MineralAtlasModOre.POOR_GRANITE_CHALCOPYRITE_ORE.get()))
                    .title(Component.translatable("creativetab.mineral_atlas.mineral_atlas_ore"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(MineralAtlasModOre.POOR_GRANITE_ALBITE_ORE);
                        //chalcopyrite
                        output.accept(MineralAtlasModOre.POOR_GRANITE_CHALCOPYRITE_ORE);
                        output.accept(MineralAtlasModOre.NORMAL_GRANITE_CHALCOPYRITE_ORE);
                        output.accept(MineralAtlasModOre.RICH_GRANITE_CHALCOPYRITE_ORE);
                        output.accept(MineralAtlasModItems.POOR_CHALCOPYRITE);
                        output.accept(MineralAtlasModItems.NORMAL_CHALCOPYRITE);
                        output.accept(MineralAtlasModItems.RICH_CHALCOPYRITE);

                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
