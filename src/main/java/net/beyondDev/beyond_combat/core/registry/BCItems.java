package net.beyondDev.beyond_combat.core.registry;

import net.beyondDev.beyond_combat.BeyondCombatMod;
import net.beyondDev.beyond_combat.common.items.custom.DaggerItem;
import net.beyondDev.beyond_combat.common.items.custom.DaggersItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BCItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, BeyondCombatMod.MOD_ID);

    public static final RegistryObject<Item> IRON_LONGSWORD = ITEMS.register("iron_longsword",
            () -> new SwordItem(Tiers.IRON, 7, -2, new Item.Properties().rarity(Rarity.RARE).durability(750)));
    public static final RegistryObject<Item> IRON_DAGGER = ITEMS.register("iron_dagger",
            () -> new DaggerItem(Tiers.IRON, 5, -1, new Item.Properties().rarity(Rarity.UNCOMMON).stacksTo(2)));
    public static final RegistryObject<Item> IRON_DAGGERS = ITEMS.register("iron_daggers",
            () -> new DaggersItem(new Item.Properties().rarity(Rarity.UNCOMMON).stacksTo(1)));

    private static RegistryObject<Item> registerSimpleItem(String id) {
        return ITEMS.register(id, () -> new Item(new Item.Properties()));
    }

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }
}