package me.Nissl.Nissclt.modules.impl.Movement;

import org.lwjgl.input.Keyboard;

import com.darkmagician6.eventapi.EventManager;
import com.darkmagician6.eventapi.EventTarget;

import me.Nissl.Nissclt.events.EventUpdate;
import me.Nissl.Nissclt.modules.Category;
import me.Nissl.Nissclt.modules.Module;
import net.minecraft.network.play.client.C03PacketPlayer;

public class Speed extends Module {

	public Speed() {
		super("Speed", "Speed", Keyboard.KEY_NONE, 0x003457, Category.MOVEMENT);
	}

	@EventTarget
	public void OnUpdate(EventUpdate eventUpdate) {
		if(mc.thePlayer.moveForward != 0 || mc.thePlayer.moveStrafing != 0) {
		if (mc.thePlayer.onGround) {
			mc.thePlayer.jump();
			mc.thePlayer.motionY = 0.4;
			mc.timer.timerSpeed = 1.25F;
			} else {
			mc.timer.timerSpeed = 1F;
			}
		}
	}

	@Override
	public void onDisable() {
		EventManager.unregister(this);
		mc.timer.timerSpeed = 1F;
	}

	@Override
	public void onEnable() {
		EventManager.register(this);
	}
}
