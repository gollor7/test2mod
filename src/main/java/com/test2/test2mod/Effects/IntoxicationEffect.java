package com.test2.test2mod.Effects;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

//TODO: implement GUI changes
public class IntoxicationEffect extends MobEffect {
    public IntoxicationEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return duration % 40 == 0;
    }

    @Override
    public boolean applyEffectTick(ServerLevel level, LivingEntity entity, int amplifier) {
        entity.hurtServer(level, level.damageSources().generic(), 0.5F + amplifier * 0.5F);
        return super.applyEffectTick(level, entity, amplifier);
    }
}
