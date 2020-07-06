package me.Nissl.Nissclt.modules.impl.Movement;

import org.lwjgl.input.Keyboard;

import com.darkmagician6.eventapi.EventManager;
import com.darkmagician6.eventapi.EventTarget;

import me.Nissl.Nissclt.events.EventUpdate;
import me.Nissl.Nissclt.modules.Category;
import me.Nissl.Nissclt.modules.Module;

public class NoSlowDown extends Module{

	public NoSlowDown() {
		super("NoSlowDown", "NoSlowDown", Keyboard.KEY_NONE, 0x003457, Category.MOVEMENT);
		// TODO Auto-generated constructor stub
	}

	@EventTarget
	public static void OnUpdate(EventUpdate eventUpdate) {
		
		if(mc.thePlayer.onGround && mc.thePlayer.moveForward != 0 && (mc.thePlayer.isBlocking() || mc.thePlayer.isUsingItem()))	{
//			mc.thePlayer.mo
//			mc.thePlayer.motionZ *= 1.4;
		}
	}
	
	@Override
	public void onDisable() {
		EventManager.unregister(this);
		}
	
	@Override
	public void onEnable() {
		EventManager.register(this);
	}
}
