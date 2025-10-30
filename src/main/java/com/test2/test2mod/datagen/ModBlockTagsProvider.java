package com.test2.test2mod.datagen;

import com.test2.test2mod.test2mod;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends BlockTagsProvider {

    public ModBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, test2mod.MODID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(test2mod.SILVER_ORE.get());

        this.tag(BlockTags.NEEDS_STONE_TOOL)
                .add(test2mod.SILVER_ORE.get());
    }
}