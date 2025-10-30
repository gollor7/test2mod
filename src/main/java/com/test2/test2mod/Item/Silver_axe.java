package com.test2.test2mod.Item;

import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.ItemAbility;

import static com.test2.test2mod.test2mod.SILVER_MATERIAL;

public class Silver_axe extends AxeItem {
    public Silver_axe(Properties properties) {
        super(SILVER_MATERIAL, 7.0f, -3.0f, properties);
    }

    @Override
    public boolean canPerformAction(ItemStack stack, ItemAbility ability) {
        return ItemAbilities.DEFAULT_AXE_ACTIONS.contains(ability);
    }
}
