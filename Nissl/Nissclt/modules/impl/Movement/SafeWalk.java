package me.Nissl.Nissclt.modules.impl.Movement;

import org.lwjgl.input.Keyboard;

import com.darkmagician6.eventapi.EventManager;
import com.darkmagician6.eventapi.EventTarget;

import me.Nissl.Nissclt.events.EventUpdate;
import me.Nissl.Nissclt.modules.Category;
import me.Nissl.Nissclt.modules.Module;
import net.minecraft.network.play.client.C0BPacketEntityAction;

public class SafeWalk extends Module {

	public SafeWalk() {
		super("SafeWalk", "SafeWalk", Keyboard.KEY_L, 0x003457, Category.MOVEMENT);

	}
	double x1;
	@EventTarget
	public void EventUpdate(EventUpdate eventUpdate) {
		
	}

	@Override
	public void onDisable() {
		EventManager.unregister(this);
	}


	@Override
	public void onEnable() {
		x1 = mc.thePlayer.posX ;
		EventManager.register(this);
	}

}
