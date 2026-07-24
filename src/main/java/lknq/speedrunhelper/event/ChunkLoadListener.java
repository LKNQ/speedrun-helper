package lknq.speedrunhelper.event;

import lknq.speedrunhelper.ServiceManager;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientChunkEvents;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.world.chunk.WorldChunk;

public class ChunkLoadListener {

    public static void register() {

        ClientChunkEvents.CHUNK_LOAD.register(ChunkLoadListener::onChunkLoad);

    }

    private static void onChunkLoad(ClientWorld world, WorldChunk chunk) {

        ServiceManager.getScannerManager().onChunkLoaded(chunk);

    }

}