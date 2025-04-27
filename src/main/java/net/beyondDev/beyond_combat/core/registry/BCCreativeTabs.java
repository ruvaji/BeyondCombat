package net.beyondDev.beyond_combat.core.registry;

import net.beyondDev.beyond_combat.BeyondCombatMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class BCCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BeyondCombatMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> BEYOND_COMBAT_TAB = CREATIVE_MODE_TABS.register("beyond_combat_tab", () -> CreativeModeTab
            .builder()
            .icon(() -> BCItems.IRON_LONGSWORD.get().getDefaultInstance())
            .title(Component.literal("BeyondCombat"))
            .displayItems((itemDisplayParameters, output) -> {
                net.beyondDev.beyond_combat.core.registry.BCItems.ITEMS.getEntries().forEach(item -> output.accept(item.get()));
            }).build());

    public static void register(IEventBus bus) {
        CREATIVE_MODE_TABS.register(bus);
    }
}