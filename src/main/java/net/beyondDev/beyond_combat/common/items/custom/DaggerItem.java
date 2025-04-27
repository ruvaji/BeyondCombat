package net.beyondDev.beyond_combat.common.items.custom;

import net.beyondDev.beyond_combat.core.registry.BCItems;
import net.beyondDev.beyond_combat.core.registry.BCSounds;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;

public class DaggerItem extends SwordItem {
    public DaggerItem(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {
        if (!pLevel.isClientSide) {
            ItemStack itemStackDaggerMainHand = pPlayer.getMainHandItem();
            ItemStack itemStackDaggerOffHand = pPlayer.getOffhandItem();
            ItemStack itemStackDaggers = new ItemStack(BCItems.IRON_DAGGERS.get());

            if (Screen.hasShiftDown() && itemStackDaggerMainHand.is(BCItems.IRON_DAGGER.get()) && itemStackDaggerOffHand.is(BCItems.IRON_DAGGER.get())) {
                itemStackDaggerMainHand.grow(-1);
                itemStackDaggerOffHand.grow(-1);
                pPlayer.setItemInHand(InteractionHand.MAIN_HAND, itemStackDaggers);

                pLevel.playSeededSound(null, pPlayer.position().x, pPlayer.position().y, pPlayer.position().z,
                        BCSounds.DAGGERS_CONNECT.get(), SoundSource.PLAYERS, 2f, 1f, 0);
            }
        }

        return super.use(pLevel, pPlayer, pHand);
    }
}
