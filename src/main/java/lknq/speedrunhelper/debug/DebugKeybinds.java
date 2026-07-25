package lknq.speedrunhelper.debug;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ChatScreen;
import net.minecraft.client.options.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public final class DebugKeybinds {

    private static KeyBinding toggleOverlay;

    private DebugKeybinds() {}

    public static void initialize() {

        toggleOverlay = KeyBindingHelper.registerKeyBinding(
                new KeyBinding(
                        "key.speedrunhelper.toggle_debug",
                        InputUtil.Type.KEYSYM,
                        GLFW.GLFW_KEY_F8,
                        "Speedrun Helper"
                )
        );


        ClientTickEvents.END_CLIENT_TICK.register(client -> {

            while (toggleOverlay.wasPressed()) {

                DebugOverlay.toggle();

                System.out.println(
                        "[Speedrun Helper] Debug overlay "
                                + (DebugOverlay.isEnabled() ? "enabled" : "disabled")
                );
            }


        });
    }
}