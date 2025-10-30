package com.test2.test2mod.Item;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShovelItem;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.ItemAbility;
import org.jetbrains.annotations.NotNull;

import static com.test2.test2mod.test2mod.SILVER_MATERIAL;

public class Silver_shovel extends ShovelItem {
    public Silver_shovel(Properties properties) {
        super(SILVER_MATERIAL, 7.0f, -3.0f, properties);
    }

    @Override
    public boolean canPerformAction(@NotNull ItemStack stack, @NotNull ItemAbility ability) {
        return ItemAbilities.DEFAULT_SHOVEL_ACTIONS.contains(ability);
    }
}
