package net.beyondDev.beyond_combat.core.registry;

import net.beyondDev.beyond_combat.BeyondCombatMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BCSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, BeyondCombatMod.MOD_ID);

    public static final RegistryObject<SoundEvent> DAGGERS_KEEP = registerSoundEvents("daggers_keep");
    public static final RegistryObject<SoundEvent> DAGGERS_CONNECT = registerSoundEvents("daggers_connect");

    public static RegistryObject<SoundEvent> registerSoundEvents(String name) {
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(ResourceLocation.tryBuild(BeyondCombatMod.MOD_ID, name)));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
