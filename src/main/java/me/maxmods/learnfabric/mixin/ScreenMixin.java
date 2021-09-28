package me.maxmods.learnfabric.mixin;


import me.maxmods.learnfabric.features.commands.Command;
import me.maxmods.learnfabric.features.commands.CommandRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Arrays;
import java.util.Locale;

@Mixin(Screen.class)
public class ScreenMixin {
    @Inject(method = "sendMessage(Ljava/lang/String;Z)V", at=@At("HEAD"), cancellable = true)
    public void sendMessage(String message, boolean toHud, CallbackInfo ci){
        if (message.startsWith("~")){
            MinecraftClient.getInstance().inGameHud.getChatHud().addToMessageHistory(message);
            ci.cancel();

            String commandWithoutPrefix = message.substring(1);
            String[] cmdAndArgs = commandWithoutPrefix.split(" +");
            String command = cmdAndArgs[0].toLowerCase();
            String[] args = Arrays.copyOfRange(cmdAndArgs, 1, cmdAndArgs.length);
            Command toExecute = CommandRegistry.getInstance().getByAlias(command);
            if (toExecute == null){
                MinecraftClient.getInstance().player.sendMessage(Text.of("No coemoent foent"), false);
            }else toExecute.execute(args);
            //Message to test if command is recognized
            //MinecraftClient.getInstance().player.sendMessage(Text.of("You ran "+command+" with "+Arrays.toString(args)+" as arguments."), false);

        }
    }
}
