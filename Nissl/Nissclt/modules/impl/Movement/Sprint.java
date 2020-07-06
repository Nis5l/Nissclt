package me.Nissl.Nissclt.modules.impl.Movement;

import org.lwjgl.input.Keyboard;

import com.darkmagician6.eventapi.EventManager;
import com.darkmagician6.eventapi.EventTarget;

import me.Nissl.Nissclt.events.EventUpdate;
import me.Nissl.Nissclt.modules.Category;
import me.Nissl.Nissclt.modules.Module;
import me.Nissl.Nissclt.utils.TimeHelper;

public class Sprint extends Module {

	public Sprint() {
		super("Sprint", "Sprint", Keyboard.KEY_Y,0x003457, Category.MOVEMENT);
		// TODO Auto-generated constructor stub
	}

	TimeHelper time1 = new TimeHelper();
	
	@EventTarget
	public void onUpdate(EventUpdate e) {
		if((mc.thePlayer != null) && 
			(!mc.gameSettings.keyBindSneak.pressed) && (
			(mc.gameSettings.keyBindForward.pressed) || 
			(mc.gameSettings.keyBindLeft.pressed) || 
			(mc.gameSettings.keyBindRight.pressed) ||
			(mc.gameSettings.keyBindBack.pressed))) {
			
				mc.thePlayer.setSprinting(true);
			
		}
		
	}
	
	@Override
	public void onDisable() {
		EventManager.unregister(this);
		mc.thePlayer.setSprinting(false);
	}
	
	@Override
	public void onEnable() {
		EventManager.register(this);
	}
	
}
