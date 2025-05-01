package net.sentree.chroniccraft.item.custom;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.sounds.AbstractSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.sentree.chroniccraft.sounds.ModSounds;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class OGChronicRollItem extends Item {

    public OGChronicRollItem(Properties properties) {
        super(properties);
    }

    private static final Map<UUID, AbstractSoundInstance> activeSmokingSounds = new HashMap<>();

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        if (!level.isClientSide) {
            entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 3600, 3));
            entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 1200, 5));
        }
        return stack;
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 50;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.DRINK;
    }

    @Override
    public SoundEvent getDrinkingSound() {
        return SoundEvents.COD_AMBIENT; // Suppress default drinking sound
    }

    public class SmokingSoundInstance extends AbstractSoundInstance {
        public SmokingSoundInstance(Player player) {
            super(ModSounds.SPARKING_UP.get(), SoundSource.PLAYERS, SoundInstance.createUnseededRandom());
            this.looping = false;
            this.x = player.getX();
            this.y = player.getY();
            this.z = player.getZ();
        }
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        pPlayer.getCooldowns().addCooldown(this, 100);
        pPlayer.startUsingItem(pUsedHand);
        ItemStack itemstack = pPlayer.getItemInHand(pUsedHand);

        if (!pLevel.isClientSide) {
            SmokingSoundInstance sound = new SmokingSoundInstance(pPlayer);
            Minecraft.getInstance().getSoundManager().play(sound);
            activeSmokingSounds.put(pPlayer.getUUID(), sound);
            spawnSmokeParticles(pLevel, pPlayer);
        }

        pPlayer.awardStat(Stats.ITEM_USED.get(this));
        if (!pPlayer.getAbilities().instabuild) {
            itemstack.shrink(1);
        }

        return super.use(pLevel, pPlayer, pUsedHand);
    }

    @Override
    public void releaseUsing(ItemStack stack, Level level, LivingEntity entity, int timeLeft) {
        if (!level.isClientSide && entity instanceof Player player) {
            AbstractSoundInstance sound = activeSmokingSounds.remove(player.getUUID());
            if (sound != null) {
                Minecraft.getInstance().getSoundManager().stop(sound);
            }
        }
        super.releaseUsing(stack, level, entity, timeLeft);
    }


    private void spawnSmokeParticles(Level level, Player player) {
        for (int i = 0; i < 5; i++) {
            double x = player.getX() + 1;
            double y = player.getEyeY() - 0.2;
            double z = player.getZ();

            double dx = (level.random.nextDouble() - 0.5) * 0.02;
            double dy = 0.05 + level.random.nextDouble() * 0.02;
            double dz = (level.random.nextDouble() - 0.5) * 0.02;

            level.addParticle(ParticleTypes.CAMPFIRE_COSY_SMOKE, x, y, z, dx, dy, dz);
        }
    }

}