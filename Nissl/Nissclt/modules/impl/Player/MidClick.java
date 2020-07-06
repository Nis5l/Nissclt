package me.Nissl.Nissclt.modules.impl.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.lwjgl.input.Keyboard;

import com.darkmagician6.eventapi.EventManager;
import com.darkmagician6.eventapi.EventTarget;

import me.Nissl.Nissclt.events.EventUpdate;
import me.Nissl.Nissclt.modules.Category;
import me.Nissl.Nissclt.modules.Module;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.play.server.S0BPacketAnimation;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.WorldServer;

public class MidClick extends Module {

	public MidClick() {
		super("MidClick", "MidClick", Keyboard.KEY_NONE, 0x004a1f, Category.PLAYER);
	}

	boolean unfriend = false;
	int downtimer = 0;

	@EventTarget
	public void OnUpdate(EventUpdate eventUpdate) {

		if (this.mc.gameSettings.keyBindPickBlock.pressed) {
			if (downtimer > 10) {
				MovingObjectPosition objectMouseOver = mc.objectMouseOver;
				Entity ent = objectMouseOver.entityHit;
				if (ent instanceof EntityPlayer) {
					for (UUID p : midClickedPlayers) {
						if (ent.getUniqueID() == p) {
							midClickedPlayers.remove(p);
							unfriend = true;
						}

					}
					if (!unfriend) {
						midClickedPlayers.add(ent.getUniqueID());
					}
				}
				downtimer = 0;
				unfriend = false;
			}
		}
		if(downtimer <= 11) {
			downtimer++;
		}
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
