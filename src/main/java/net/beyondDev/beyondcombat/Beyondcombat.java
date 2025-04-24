package net.beyondDev.beyondcombat;

import com.mojang.logging.LogUtils;
import net.beyondDev.beyondcombat.item.ModCreativeModeTabs;
import net.beyondDev.beyondcombat.item.ModItems;
import net.beyondDev.beyondcombat.sound.ModSounds;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import org.zeith.hammerlib.core.adapter.LanguageAdapter;

@Mod(Beyondcombat.MODID)
public class Beyondcombat {

    public static final String MODID = "beyondcombat";

    private static final Logger LOGGER = LogUtils.getLogger();

    public Beyondcombat(FMLJavaModLoadingContext context) {

        IEventBus modEventBus = context.getModEventBus();

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::AddCreative);

        LanguageAdapter.registerMod("beyondcombat");
        ModCreativeModeTabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModSounds.register(modEventBus);

    }

    private void AddCreative(BuildCreativeModeTabContentsEvent event) {
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
        }
    }
}
