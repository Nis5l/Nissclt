package me.Nissl.Nissclt.modules.impl.Render;

import java.awt.Color;
import java.util.List;
import java.util.UUID;

import org.lwjgl.input.Keyboard;
import net.minecraft.entity.Entity;

import com.darkmagician6.eventapi.EventTarget;

import me.Nissl.Nissclt.modules.Category;
import me.Nissl.Nissclt.modules.Module;
import me.Nissl.Nissclt.modules.impl.Player.MidClick;
import me.Nissl.Nissclt.utils.RenderUtil;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.player.EntityPlayer;

public class PlayerESP extends Module {
	
	public PlayerESP() {
		super("PlayerESP", "PlayerESP", Keyboard.KEY_N, 0x3b0047, Category.RENDER);
		
	}
	EntityPlayer entityPlayer;
	@EventTarget
	public void onRender() {
		for(Object o : mc.theWorld.loadedEntityList) {
			if(o instanceof EntityPlayer && o != mc.thePlayer) {
				entityPlayer = (EntityPlayer) o;
				passive(entityPlayer);
			}
			
		}
	}
	
	public void passive(EntityPlayer entityPlayer) {
		Color color = Color.GREEN;
		this.mc.getRenderManager();
		double x = (entityPlayer.lastTickPosX - (entityPlayer.posX - entityPlayer.lastTickPosX) * this.mc.timer.renderPartialTicks) - RenderManager.renderPosX;
		double y = (entityPlayer.lastTickPosY - (entityPlayer.posY - entityPlayer.lastTickPosY) * this.mc.timer.renderPartialTicks)- RenderManager.renderPosY;
		double z = (entityPlayer.lastTickPosZ - (entityPlayer.posZ - entityPlayer.lastTickPosZ) * this.mc.timer.renderPartialTicks) - RenderManager.renderPosZ;
		render(color, x, y, z, entityPlayer.width,(entityPlayer.height-0.7f),1);
		
	}
	
	public void render(Color color,double x, double y,double z,float width,float height,double yOffset) {
		
		//System.out.println(midClickedPlayers.size());
		boolean renderFriend = false;
		for(UUID e: midClickedPlayers) {
			if(e == entityPlayer.getUniqueID()) {
				RenderUtil.renderPlayerESPBox(Color.MAGENTA, x, y, z, width,height,yOffset);
				renderFriend = true;
			}
		}
		if(!renderFriend) {
		RenderUtil.renderPlayerESPBox(color, x, y, z, width,height,yOffset);
		}
	}
	
}
