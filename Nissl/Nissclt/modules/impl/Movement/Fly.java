package me.Nissl.Nissclt.modules.impl.Movement;

import org.lwjgl.input.Keyboard;

import com.darkmagician6.eventapi.EventManager;
import com.darkmagician6.eventapi.EventTarget;

import me.Nissl.Nissclt.events.EventUpdate;
import me.Nissl.Nissclt.modules.Category;
import me.Nissl.Nissclt.modules.Module;

public class Fly extends Module {

	public Fly() {
		super("Fly", "Fly", Keyboard.KEY_NONE, 0x003457, Category.MOVEMENT);
	}
	
	@EventTarget
	public void onUpdate(EventUpdate eventUpdate) {
		
		this.mc.thePlayer.motionY = 0;
		this.mc.thePlayer.fallDistance = 0;
		
	}

	@Override
	public void onEnable() {
		EventManager.register(this);
	}

	@Override
	public void onDisable() {
		EventManager.unregister(this);
	}
	
}
