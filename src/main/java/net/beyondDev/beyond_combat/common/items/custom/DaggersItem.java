package net.beyondDev.beyond_combat.common.items.custom;

import net.beyondDev.beyond_combat.core.registry.BCItems;
import net.beyondDev.beyond_combat.core.registry.BCSounds;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class DaggersItem extends Item {
    public DaggersItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {
        if (!pLevel.isClientSide) {
            ItemStack itemStackDaggers = pPlayer.getMainHandItem();
            ItemStack itemStackOffHand = pPlayer.getOffhandItem();
            ItemStack itemStackDaggerMainHand = new ItemStack(BCItems.IRON_DAGGER.get());
            ItemStack itemStackDaggerOffHand = new ItemStack(BCItems.IRON_DAGGER.get());

            if (Screen.hasShiftDown() && itemStackOffHand.isEmpty()) {
                itemStackDaggers.grow(-1);
                pPlayer.setItemInHand(InteractionHand.MAIN_HAND, itemStackDaggerMainHand);
                pPlayer.setItemInHand(InteractionHand.OFF_HAND, itemStackDaggerOffHand);

                pLevel.playSeededSound(null, pPlayer.position().x, pPlayer.position().y, pPlayer.position().z, BCSounds.DAGGERS_KEEP.get(), SoundSource.PLAYERS, 2f, 1f, 0);
            }
        }

        return super.use(pLevel, pPlayer, pHand);
    }
}