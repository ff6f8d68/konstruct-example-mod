package com.examplemod;

import modloader.konstruct.foundation.mod;
import modloader.konstruct.foundation.ModInfo;
import modloader.konstruct.events.NamedEvent;
import modloader.konstruct.events.EventBus;
import modloader.konstruct.events.SubscribeEvent;
import modloader.konstruct.utils.logger;

public class main extends mod {

    public main() {
        super(new ModInfo("MyMod", "1.0", "Me", "A dynamic event mod"));
        EventBus.getGlobal().register(this);

        // Fire your init event
        EventBus.getGlobal().post(new NamedEvent("mod_init"));
    }

    @SubscribeEvent
    public void onAnyEvent(NamedEvent event) {
        String name = event.getName();
        switch (name) {
            case "mod_init" -> logger.info("Mod init detected");
            case "game_start" -> logger.info("Game started!");
            default -> {
                // handle other dynamic events if needed
            }
        }
    }
}
