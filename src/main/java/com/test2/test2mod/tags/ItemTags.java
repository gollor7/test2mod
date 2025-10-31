package com.test2.test2mod.tags;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

import static com.test2.test2mod.test2mod.MODID;

public final class ItemTags {
    public static final TagKey<Item> SILVER = bind("silver");
    private ItemTags() {
    }

    private static TagKey<Item> bind(String name) {
        return TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(MODID, name));
    }

    public static TagKey<Item> create(ResourceLocation name) {
        return TagKey.create(Registries.ITEM, name);
    }
}