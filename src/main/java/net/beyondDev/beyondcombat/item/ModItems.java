package net.beyondDev.beyondcombat.item;

import net.beyondDev.beyondcombat.Beyondcombat;
import net.beyondDev.beyondcombat.item.custom.DaggerItem;
import net.beyondDev.beyondcombat.item.custom.DaggersItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Beyondcombat.MODID);

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }

    public static final RegistryObject<Item> IRON_LONGSWORD = ITEMS.register("iron_longsword",
            () -> new SwordItem(Tiers.IRON, 7, -2, new Item.Properties().rarity(Rarity.RARE).durability(750)));
    public static final RegistryObject<Item> IRON_DAGGER = ITEMS.register("iron_dagger",
            () -> new DaggerItem(Tiers.IRON, 5, -1, new Item.Properties().rarity(Rarity.UNCOMMON).stacksTo(2)));
    public static final RegistryObject<Item> IRON_DAGGERS = ITEMS.register("iron_daggers",
            () -> new DaggersItem(new Item.Properties().rarity(Rarity.UNCOMMON).stacksTo(1)));
}
