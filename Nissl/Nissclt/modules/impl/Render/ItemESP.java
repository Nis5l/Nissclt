package me.Nissl.Nissclt.modules.impl.Render;

import java.awt.Color;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import com.darkmagician6.eventapi.EventManager;
import com.darkmagician6.eventapi.EventTarget;

import me.Nissl.Nissclt.modules.Category;
import me.Nissl.Nissclt.modules.Module;
import me.Nissl.Nissclt.utils.RenderUtil;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.entity.RenderMagmaCube;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.Vec3;

public class ItemESP extends Module {

	public ItemESP() {
		super("ItemESP", "ItemESP", Keyboard.KEY_B, 0x3b0047, Category.RENDER);
	}

	public void onRender() {
		for (Object o : mc.theWorld.loadedEntityList) {
			if (o instanceof EntityItem) {
				EntityItem e = (EntityItem) o;
				passive(e);
			}
		}
	}

	public void passive(EntityItem entityItem) {
		Color color = (Color) Color.WHITE;
		this.mc.getRenderManager();
		double x = (entityItem.lastTickPosX- (entityItem.posX - entityItem.lastTickPosX) * this.mc.timer.renderPartialTicks)- RenderManager.renderPosX;
		double y = (entityItem.lastTickPosY- (entityItem.posY - entityItem.lastTickPosY) * this.mc.timer.renderPartialTicks)- RenderManager.renderPosY;
		double z = (entityItem.lastTickPosZ- (entityItem.posZ - entityItem.lastTickPosZ) * this.mc.timer.renderPartialTicks)- RenderManager.renderPosZ;
		render(color, x, y, z, entityItem.width, 0.35);
	}

	public void render(Color color, double x, double y, double z, float width, double yoffset) {

		RenderUtil.renderItemESPBox(color, x, y, z, width, yoffset);

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
