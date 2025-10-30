package com.test2.test2mod;

import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.ViewportEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

import java.util.Objects;

import static com.test2.test2mod.test2mod.INTOXICATION_EFFECT;

// This class will not load on dedicated servers. Accessing client side code from here is safe.
@Mod(value = test2mod.MODID, dist = Dist.CLIENT)
// You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
@EventBusSubscriber(modid = test2mod.MODID, value = Dist.CLIENT)
public class test2modClient {
    public test2modClient(ModContainer container) {
        // Allows NeoForge to create a config screen for this mod's configs.
        // The config screen is accessed by going to the Mods screen > clicking on your mod > clicking on config.
        // Do not forget to add translations for your config options to the en_us.json file.
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }

    @SubscribeEvent
    static void onClientSetup(FMLClientSetupEvent event) {
        // Some client setup code
        test2mod.LOGGER.info("HELLO FROM CLIENT SETUP");
        test2mod.LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
    }

    @SubscribeEvent
    public static void onCameraSetup(ViewportEvent.ComputeCameraAngles event) {
        Minecraft mc = Minecraft.getInstance();
        Player player = mc.player;
        if (player == null) return;

        if (player.hasEffect(INTOXICATION_EFFECT)) {
            int amplifier = Objects.requireNonNull(player.getEffect(INTOXICATION_EFFECT)).getAmplifier();

            float time = (float) ((player.tickCount + event.getPartialTick()) * 0.1f);
            float intensity = 1.5F + amplifier;

            event.setPitch(event.getPitch() + (float) Math.sin(time) * intensity);
            event.setYaw(event.getYaw() + (float) Math.cos(time * 1.2) * intensity);
        }
    }
}
