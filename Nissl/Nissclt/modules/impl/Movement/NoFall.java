package me.Nissl.Nissclt.modules.impl.Movement;

import org.lwjgl.input.Keyboard;

import com.darkmagician6.eventapi.EventTarget;

import me.Nissl.Nissclt.events.EventUpdate;
import me.Nissl.Nissclt.modules.Category;
import me.Nissl.Nissclt.modules.Module;

public class NoFall extends Module {

	public NoFall() {
		super("NoFall", "NoFall", Keyboard.KEY_K, 0x003457, Category.MOVEMENT);
	}
	
	@EventTarget
	public void onUpdate(EventUpdate eventUpdate) {
		
	}

}
