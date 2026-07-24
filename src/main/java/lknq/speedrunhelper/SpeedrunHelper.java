package lknq.speedrunhelper;

import lknq.speedrunhelper.debug.DebugKeybinds;
import lknq.speedrunhelper.event.ChunkLoadListener;
import net.fabricmc.api.ClientModInitializer;

public class SpeedrunHelper implements ClientModInitializer {

    public static final String MOD_ID = "speedrun-helper";

    @Override
    public void onInitializeClient() {

        System.out.println("[Speedrun Helper] Loaded");

        ServiceManager.initialize();
        DebugKeybinds.initialize();
        ChunkLoadListener.register();

    }

    public static void log(String text) {

        System.out.println("[Speedrun Helper] " + text);

    }

}