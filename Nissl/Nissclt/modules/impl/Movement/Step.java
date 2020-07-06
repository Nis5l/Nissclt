package me.Nissl.Nissclt.modules.impl.Movement;

import org.lwjgl.input.Keyboard;

import com.darkmagician6.eventapi.EventManager;
import com.darkmagician6.eventapi.EventTarget;

import me.Nissl.Nissclt.events.EventUpdate;
import me.Nissl.Nissclt.modules.Category;
import me.Nissl.Nissclt.modules.Module;
import me.Nissl.Nissclt.utils.TimeHelper;
import net.minecraft.network.play.client.C03PacketPlayer;

public class Step extends Module {

	public Step() {
		super("Step", "Step", Keyboard.KEY_X, 0x003457, Category.MOVEMENT);
		// TODO Auto-generated constructor stub
	}

	TimeHelper time1 = new TimeHelper();
	
	@EventTarget
	public void onUpdate(EventUpdate e) {
		if((mc.thePlayer.isCollidedHorizontally) && ((this.mc.gameSettings.keyBindForward.pressed)  || (this.mc.gameSettings.keyBindBack.pressed) || (this.mc.gameSettings.keyBindRight.pressed) || (this.mc.gameSettings.keyBindLeft.pressed)) && (mc.thePlayer.onGround) && (!this.mc.thePlayer.isOnLadder())) {
			if(this.time1.isDelayComplete(57.0F)) {
				mc.thePlayer.stepHeight = 1.5F;
				mc.thePlayer.sendQueue.addToSendQueue(new C03PacketPlayer.C04PacketPlayerPosition(mc.thePlayer.posX,mc.thePlayer.posY + 0.42D, mc.thePlayer.posZ, mc.thePlayer.onGround));
				mc.thePlayer.sendQueue.addToSendQueue(new C03PacketPlayer.C04PacketPlayerPosition(mc.thePlayer.posX,mc.thePlayer.posY + 0.753D, mc.thePlayer.posZ, mc.thePlayer.onGround));
				time1.reset();
			}
			}else {
			mc.timer.timerSpeed = 1F;
			mc.thePlayer.stepHeight = 0.5F;
		}
	}
	
	@Override
	public void onDisable() {
		EventManager.unregister(this);
		mc.thePlayer.stepHeight = 0.5F;
	}
	
	@Override
	public void onEnable() {
		EventManager.register(this);
	}
	
}
