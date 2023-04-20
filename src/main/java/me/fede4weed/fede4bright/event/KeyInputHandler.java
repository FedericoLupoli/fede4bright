package me.fede4weed.fede4bright.event;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.InputUtil;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;

import static me.fede4weed.fede4bright.utils.Effects.*;

public class KeyInputHandler {
    public static final String KEY_GATEGORY_FEDE4WEED = "key.category.fede4weed";
    public static final String KEY_FULLBRIGHT = "key.fede4weed.fullbright";


    public static KeyBinding fullbrightkey;
    public static boolean fullbrightStatus=false;
    public static void registerKeyInputs(){
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (fullbrightkey.wasPressed()) {
                if(!fullbrightStatus){
                    enableNightVision(client.player);
                }else{
                    disableNightVision(client.player);
                }
            }
        });
    }

    public static void register() {
        fullbrightkey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                KEY_FULLBRIGHT,
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_X,
                KEY_GATEGORY_FEDE4WEED
        ));
        registerKeyInputs();
    }
}
