package com.test2.test2mod;

import com.test2.test2mod.Item.Silver_axe;
import com.test2.test2mod.Item.Silver_hoe;
import com.test2.test2mod.Item.Silver_shovel;
import com.test2.test2mod.armor.ModArmorMaterials;
import net.minecraft.core.component.DataComponents;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;
import net.minecraft.world.item.equipment.ArmorMaterials;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.level.block.SoundType;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import static net.minecraft.world.item.Items.registerItem;


// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(test2mod.MODID)

public class test2mod {

    // Define mod id in a common place for everything to reference
    public static final String MODID = "test2mod";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();
    // Create a Deferred Register to hold Blocks which will all be registered under the "test2mod" namespace
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID);
    // Create a Deferred Register to hold Items which will all be registered under the "test2mod" namespace
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);
    // Create a Deferred Register to hold CreativeModeTabs which will all be registered under the "test2mod" namespace
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);


    public static final TagKey<Item> INGOTS_SILVER = TagKey.create(Registries.ITEM,
            ResourceLocation.fromNamespaceAndPath(test2mod.MODID, "ingots/silver"));

    public static final ToolMaterial SILVER_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_IRON_TOOL,
            200,
            5f,
            1.5f,
            25,
            INGOTS_SILVER);

    public static final DeferredItem<Item> SILVER_SWORD = ITEMS.registerItem(
            "silver_sword",
            props -> new Item(
                    props.sword(
                            SILVER_MATERIAL,
                            5.5f,
                            -2.4f
                    )));

    public static final DeferredItem<Item> SILVER_AXE = ITEMS.registerItem("silver_axe", Silver_axe::new);


    public static final DeferredItem<Item> SILVER_PICKAXE = ITEMS.registerItem("silver_pickaxe",
            props -> new Item(props.pickaxe(SILVER_MATERIAL,
                    3,
                    -2.6f)));

    public static final DeferredItem<Item> SILVER_SHOVEL = ITEMS.registerItem("silver_shovel", Silver_shovel::new);

    public static final DeferredItem<Item> SILVER_HOE = ITEMS.registerItem("silver_hoe", Silver_hoe::new);

    public static final DeferredItem<Item> WITCH_HELMET = ITEMS.registerItem("witch_helmet",
            properties -> new Item(properties.humanoidArmor(ModArmorMaterials.SILVER, ArmorType.HELMET)));

    public static final DeferredItem<Item> WITCH_BOOTS = ITEMS.registerItem("witch_boots",
            properties -> new Item(properties.humanoidArmor(ModArmorMaterials.SILVER, ArmorType.BOOTS)));

    public static final DeferredItem<Item> WITCH_CHESTPLATE = ITEMS.registerItem("witch_chestplate",
            properties -> new Item(properties.humanoidArmor(ModArmorMaterials.SILVER, ArmorType.CHESTPLATE)));

    public static final DeferredItem<Item> WITCH_LEGGINGS = ITEMS.registerItem("witch_leggings",
            properties -> new Item(properties.humanoidArmor(ModArmorMaterials.SILVER, ArmorType.LEGGINGS)));


    // Creates a new Block with the id "test2mod:example_block", combining the namespace and path
    public static final DeferredBlock<Block> SILVER_ORE = BLOCKS.register(
            "silver_ore",
            registryName -> new Block(BlockBehaviour.Properties.of()
                    .setId(ResourceKey.create(Registries.BLOCK, registryName))
                    .destroyTime(3.0f)
                    .explosionResistance(10.0f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)
            ));

    public static final DeferredBlock<Block> SILVER_BLOCK = BLOCKS.register(
            "silver_block",
            registryName -> new Block(BlockBehaviour.Properties.of()
                    .setId(ResourceKey.create(Registries.BLOCK, registryName))
                    .destroyTime(3.0f)
                    .explosionResistance(10.0f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)
            ));

    // Creates a new BlockItem with the id "test2mod:example_block", combining the namespace and path
    public static final DeferredItem<BlockItem> SILVER_ORE_ITEM = ITEMS.registerSimpleBlockItem("silver_ore", SILVER_ORE);
    public static final DeferredItem<BlockItem> SILVER_BLOCK_ITEM = ITEMS.registerSimpleBlockItem("silver_block", SILVER_BLOCK);

    // Creates a new food item with the id "test2mod:example_id", nutrition 1 and saturation 2
    public static final DeferredItem<Item> SWALLOW_POTION = ITEMS.registerSimpleItem("swallow_potion", new Item.Properties().component(DataComponents.CONSUMABLE, Consumable.builder()
            .consumeSeconds(0.5f)
            .hasConsumeParticles(false)
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.REGENERATION, 900)))
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.SPEED, 900)))
            .sound(SoundEvents.HONEY_DRINK)
            .soundAfterConsume(SoundEvents.BREEZE_WIND_CHARGE_BURST)
            .build()));

    public static final DeferredItem<Item> RAW_SILVER = ITEMS.registerSimpleItem("raw_silver");
    public static final DeferredItem<Item> SILVER_INGOT = ITEMS.registerSimpleItem("silver_ingot");

    // Creates a creative tab with the id "test2mod:example_tab" for the example item, that is placed after the combat tab
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> EXAMPLE_TAB = CREATIVE_MODE_TABS.register("example_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.test2mod")) //The language key for the title of your CreativeModeTab
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> SWALLOW_POTION.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.accept(SWALLOW_POTION.get());
                output.accept(RAW_SILVER.get());
                output.accept(SILVER_INGOT.get());
                output.accept(SILVER_AXE.get());
                output.accept(SILVER_HOE.get());
                output.accept(SILVER_SHOVEL.get());
                output.accept(SILVER_SWORD.get());
                output.accept(SILVER_PICKAXE.get());
                output.accept(WITCH_HELMET.get());
                output.accept(WITCH_BOOTS.get());
                output.accept(WITCH_LEGGINGS.get());
                output.accept(WITCH_CHESTPLATE.get());
                // Add the example item to the tab. For your own tabs, this method is preferred over the event
            }).build());

    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public test2mod(IEventBus modEventBus, ModContainer modContainer) {
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register the Deferred Register to the mod event bus so blocks get registered
        BLOCKS.register(modEventBus);
        // Register the Deferred Register to the mod event bus so items get registered
        ITEMS.register(modEventBus);
        // Register the Deferred Register to the mod event bus so tabs get registered
        CREATIVE_MODE_TABS.register(modEventBus);

        // Register ourselves for server and other game events we are interested in.
        // Note that this is necessary if and only if we want *this* class (test2mod) to respond directly to events.
        // Do not add this line if there are no @SubscribeEvent-annotated functions in this class, like onServerStarting() below.
        NeoForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        // Some common setup code
        LOGGER.info("HELLO FROM COMMON SETUP");

        if (Config.LOG_DIRT_BLOCK.getAsBoolean()) {
            LOGGER.info("DIRT BLOCK >> {}", BuiltInRegistries.BLOCK.getKey(Blocks.DIRT));
        }

        LOGGER.info("{}{}", Config.MAGIC_NUMBER_INTRODUCTION.get(), Config.MAGIC_NUMBER.getAsInt());

        Config.ITEM_STRINGS.get().forEach((item) -> LOGGER.info("ITEM >> {}", item));
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(SILVER_ORE_ITEM);
            event.accept(SILVER_BLOCK_ITEM);
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

}
