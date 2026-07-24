package lknq.speedrunhelper;

import net.fabricmc.api.ClientModInitializer;

public class SpeedrunHelper implements ClientModInitializer {

    public static final String MOD_ID = "speedrun-helper";

    @Override
    public void onInitializeClient() {
        System.out.println("[Speedrun Helper] Loaded");
        ServiceManager.initialize();
    }
}
