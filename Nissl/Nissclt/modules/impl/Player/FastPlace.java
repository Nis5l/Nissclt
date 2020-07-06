package me.Nissl.Nissclt.modules.impl.Player;

import org.lwjgl.input.Keyboard;

import com.darkmagician6.eventapi.EventManager;
import com.darkmagician6.eventapi.EventTarget;

import me.Nissl.Nissclt.events.EventUpdate;
import me.Nissl.Nissclt.modules.Category;
import me.Nissl.Nissclt.modules.Module;
import net.minecraft.event.ClickEvent;

public class FastPlace extends Module {

	public FastPlace() {
		super("FastPlace", "FastPlace",  Keyboard.KEY_C, 0x004a1f, Category.PLAYER);
		
	}

	@EventTarget
	public void onUpdate(EventUpdate e) {
		mc.rightClickDelayTimer = 0;
	}
	
	@Override
	public void onDisable() {
		mc.rightClickDelayTimer = 6;
		EventManager.unregister(this);
	}
	
	@Override
	public void onEnable() {
		mc.rightClickDelayTimer = 0;
		EventManager.register(this);
		System.out.println("on");
	}
	
}
