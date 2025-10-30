package com.test2.test2mod.datagen;

import com.test2.test2mod.test2mod;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ItemTagsProvider;

import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends ItemTagsProvider {
    public ModItemTagsProvider(PackOutput output,
                               CompletableFuture<HolderLookup.Provider> lookupProvider,
                               CompletableFuture<TagLookup<Block>> modId) {
        super(output, lookupProvider, String.valueOf(modId));
    }
    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(test2mod.INGOTS_SILVER)
                .add(test2mod.SILVER_INGOT.get());
    }
}
