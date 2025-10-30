package com.test2.test2mod.Item;

import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.ItemAbility;

import static com.test2.test2mod.test2mod.SILVER_MATERIAL;

public class Silver_hoe extends HoeItem {
    public Silver_hoe(Properties properties) {
        super(SILVER_MATERIAL, 7.0f, -3.0f, properties);
    }

    @Override
    public boolean canPerformAction(ItemStack stack, ItemAbility ability) {
        return ItemAbilities.DEFAULT_HOE_ACTIONS.contains(ability);
    }
}
