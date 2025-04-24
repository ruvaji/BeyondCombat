package net.beyondDev.beyondcombat.item.custom;

import net.beyondDev.beyondcombat.item.ModItems;
import net.beyondDev.beyondcombat.sound.ModSounds;
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
        ItemStack itemStackDaggerMainHand = pPlayer.getItemInHand(InteractionHand.MAIN_HAND);
        ItemStack itemStackDaggerOffHand = pPlayer.getItemInHand(InteractionHand.OFF_HAND);
        ItemStack itemStackDaggers = new ItemStack(ModItems.IRON_DAGGERS.get());

        if(!pLevel.isClientSide) {
            if(Screen.hasShiftDown() && itemStackDaggerMainHand.is(ModItems.IRON_DAGGER.get()) && itemStackDaggerOffHand.is(ModItems.IRON_DAGGER.get())) {
                itemStackDaggerMainHand.grow(-1);
                itemStackDaggerOffHand.grow(-1);
                pPlayer.setItemInHand(InteractionHand.MAIN_HAND, itemStackDaggers);

                pLevel.playSeededSound(null, pPlayer.position().x, pPlayer.position().y, pPlayer.position().z,
                        ModSounds.DAGGERS_CONNECT.get(), SoundSource.PLAYERS,2f, 1f, 0);
            }
        }

        return super.use(pLevel, pPlayer, pHand);
    }
}
