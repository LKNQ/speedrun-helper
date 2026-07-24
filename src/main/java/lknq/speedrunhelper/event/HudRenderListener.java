package lknq.speedrunhelper.event;

import lknq.speedrunhelper.debug.DebugOverlay;
import lknq.speedrunhelper.debug.DebugStats;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;

public final class HudRenderListener {

    private HudRenderListener() {}

    public static void register() {
        System.out.println("[Speedrun Helper] HUD registered");
        HudRenderCallback.EVENT.register((matrices, tickDelta) -> {

            if (!DebugOverlay.isEnabled())
                return;

            MinecraftClient client = MinecraftClient.getInstance();

            if (client.player == null)
                return;

            int x = 5;
            int y = 5;

            client.textRenderer.draw(
                    matrices,
                    "=== Speedrun Helper ===",
                    x, y,
                    0xFFFFFF);

            y += 12;

            client.textRenderer.draw(
                    matrices,
                    "XYZ: "
                            + (int) client.player.getX()
                            + " "
                            + (int) client.player.getY()
                            + " "
                            + (int) client.player.getZ(),
                    x, y,
                    0xAAAAAA);

            y += 10;

            client.textRenderer.draw(
                    matrices,
                    "Chunks scanned: " + DebugStats.chunksScanned,
                    x, y,
                    0x55FF55);

            y += 10;

            client.textRenderer.draw(
                    matrices,
                    "Interesting blocks: " + DebugStats.interestingBlocks,
                    x, y,
                    0x55FFFF);

            y += 10;

            client.textRenderer.draw(
                    matrices,
                    String.format("Last scan: %.3f ms",
                            DebugStats.getLastScanMs()),
                    x, y,
                    0xFFFF55);

            y += 10;

            client.textRenderer.draw(
                    matrices,
                    String.format("Average: %.3f ms",
                            DebugStats.getAverageScanMs()),
                    x, y,
                    0xFFFF55);

            y += 10;

            client.textRenderer.draw(
                    matrices,
                    "Village score: " + DebugStats.lastVillageScore,
                    x,
                    y,
                    0xFFFF55
            );

            y += 10;

            client.textRenderer.draw(
                    matrices,
                    "Village candidates: "
                            + DebugStats.villageCandidates,
                    x, y,
                    0xFFAA00);

            y += 10;

            client.textRenderer.draw(
                    matrices,
                    "Waypoints: "
                            + DebugStats.waypointCount,
                    x, y,
                    0xFF55FF);
        });

    }

}