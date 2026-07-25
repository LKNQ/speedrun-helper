package lknq.speedrunhelper.mixin;

import lknq.speedrunhelper.debug.DebugTeleport;
import net.minecraft.client.gui.screen.ChatScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ChatScreen.class)
public class ChatScreenMixin {

    @Inject(method = "keyPressed", at = @At("HEAD"), cancellable = true)
    private void speedrunhelper$keyPressed(
            int keyCode,
            int scanCode,
            int modifiers,
            CallbackInfoReturnable<Boolean> cir
    ) {

        switch (keyCode) {

            case 49: // 1
                DebugTeleport.teleportTo(0);
                cir.setReturnValue(true);
                return;

            case 50: // 2
                DebugTeleport.teleportTo(1);
                cir.setReturnValue(true);
                return;

            case 51: // 3
                DebugTeleport.teleportTo(2);
                cir.setReturnValue(true);
                return;

            case 52: // 4
                DebugTeleport.teleportTo(3);
                cir.setReturnValue(true);
                return;

            case 53: // 5
                DebugTeleport.teleportTo(4);
                cir.setReturnValue(true);
                return;
        }
    }
}