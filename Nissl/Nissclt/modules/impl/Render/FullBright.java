package me.Nissl.Nissclt.modules.impl.Render;

import org.lwjgl.input.Keyboard;

import com.darkmagician6.eventapi.EventManager;
import com.darkmagician6.eventapi.EventTarget;

import me.Nissl.Nissclt.events.EventUpdate;
import me.Nissl.Nissclt.modules.Category;
import me.Nissl.Nissclt.modules.Module;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class FullBright extends Module {

	public FullBright() {
		super("FullBright", "FullBright", Keyboard.KEY_V , 0x3b0047, Category.RENDER);
		// TODO Auto-generated constructor stub
	}
	
	@EventTarget
	public void onUpdate(EventUpdate e) {
		 if(mc.thePlayer != null && mc.theWorld  != null) {
			 mc.thePlayer.addPotionEffect(new PotionEffect(Potion.nightVision.id,6969));
		 }
	}

	@Override
	public void onEnable() {
		EventManager.register(this);
		if(mc.thePlayer != null && mc.theWorld  != null) {
			 mc.thePlayer.addPotionEffect(new PotionEffect(Potion.nightVision.id,6969));
		}
	}
	
	@Override
	public void onDisable() {
		EventManager.unregister(this);
		if(mc.thePlayer != null && mc.theWorld  != null) {
			mc.thePlayer.removePotionEffect(Potion.nightVision.id);
		}
	}
}
