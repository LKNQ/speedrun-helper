package lknq.speedrunhelper.debug;

import java.util.List;

import lknq.speedrunhelper.ServiceManager;
import lknq.speedrunhelper.detector.DetectedStructure;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ChatScreen;

public final class DebugTeleport {

    private DebugTeleport() {}

    public static void teleportTo(int index) {

        MinecraftClient client = MinecraftClient.getInstance();

        if (client.player == null || client.getNetworkHandler() == null)
            return;

        List<DetectedStructure> structures =
                ServiceManager.getDetectionManager().getNearest(5);

        if (index < 0 || index >= structures.size())
            return;

        DetectedStructure structure = structures.get(index);

        int x = structure.getPos().getX();
        int z = structure.getPos().getZ();

        int y = client.world.getTopY(
                net.minecraft.world.Heightmap.Type.WORLD_SURFACE,
                x,
                z
        ) + 2;

        String command =
                "tp "
                        + x
                        + " "
                        + y
                        + " "
                        + z;

        client.player.sendChatMessage("/" + command);

        client.player.sendChatMessage("/" + command);
    }
}