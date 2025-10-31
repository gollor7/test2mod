package com.test2.test2mod.armor;

import com.google.common.collect.Maps;
import com.test2.test2mod.tags.ItemTags;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAssets;


import java.util.Map;

public interface ModArmorMaterials {
    ArmorMaterial SILVER = new ArmorMaterial(30, makeDefense(2, 5, 5, 2, 7), 15, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 0.0F, ItemTags.SILVER, EquipmentAssets.CHAINMAIL);

    private static Map<ArmorType, Integer> makeDefense(int boots, int leggings, int chestplate, int helmet, int body) {
        return Maps.newEnumMap(Map.of(ArmorType.BOOTS, boots, ArmorType.LEGGINGS, leggings, ArmorType.CHESTPLATE, chestplate, ArmorType.HELMET, helmet, ArmorType.BODY, body));
    }
}
