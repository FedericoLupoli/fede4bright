package me.fede4weed.fede4bright.client;

import me.fede4weed.fede4bright.event.KeyInputHandler;
import net.fabricmc.api.ClientModInitializer;

public class Fede4brightClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        KeyInputHandler.register();
    }
}
