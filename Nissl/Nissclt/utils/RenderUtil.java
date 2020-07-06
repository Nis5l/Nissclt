package me.Nissl.Nissclt.utils;

import java.awt.Color;

import org.lwjgl.opengl.GL11;

import me.Nissl.Nissclt.Nissclt;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ResourceLocation;

public class RenderUtil {

	private static Tessellator tessellator = Tessellator.getInstance();
	private static WorldRenderer worldRenderer = tessellator.getWorldRenderer();
	private static ScaledResolution sr = new ScaledResolution(Minecraft.getMinecraft());

	public static void render2DGeometry() {
		GL11.glPushMatrix();
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		
//		GL11.glEnable(GL11.GL_BLEND);
//		GL11.glBlendFunc(770, 771);
//		GL11.glDisable(GL11.GL_TEXTURE_2D);
//		GL11.glEnable(GL11.GL_LINE_SMOOTH);
//		GL11.glDisable(GL11.GL_DEPTH_TEST);
//		GL11.glDepthMask(false);
		
		worldRenderer.begin(3, DefaultVertexFormats.POSITION);

		worldRenderer.pos(0, sr.getScaledHeight(), 0).endVertex();
		worldRenderer.pos(0, sr.getScaledHeight() - 20, 0).endVertex();
		worldRenderer.pos(sr.getScaledWidth(), sr.getScaledHeight() - 20, 0).endVertex();
		worldRenderer.pos(sr.getScaledWidth(), sr.getScaledHeight(), 0).endVertex();
		tessellator.draw();
		

//		GL11.glDisable(GL11.GL_LINE_SMOOTH);
//		GL11.glEnable(GL11.GL_TEXTURE_2D);
//		GL11.glEnable(GL11.GL_DEPTH_TEST);
//		GL11.glDepthMask(true);
//		GL11.glDisable(GL11.GL_BLEND);
		
		
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glPopMatrix();
	}

	public static void renderFont(String text, int posX, int posY, int color) {
		Minecraft.getMinecraft().fontRendererObj.drawString(text, posX, posY, color);
	}

	public static void renderFontWithShadow(String text, int posX, int posY, int shadowoffsetX, int shadowoffsetY,
			float fontsize, int color, int shadowColor) {
		GlStateManager.pushMatrix();
		GlStateManager.scale(fontsize, fontsize, fontsize);
		Minecraft.getMinecraft().fontRendererObj.drawString(text, posX + shadowoffsetX, posY + shadowoffsetY,
				shadowColor);
		Minecraft.getMinecraft().fontRendererObj.drawString(text, posX, posY, color);
		GlStateManager.scale(1, 1, 1);
		GlStateManager.popMatrix();
	}

	public static void renderItemESPBox(Color color, double x, double y, double z, float width, double yoffset) {
		Tessellator tessellator = Tessellator.getInstance();
		WorldRenderer worldRenderer = tessellator.getWorldRenderer();

		GL11.glPushMatrix();
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(770, 771);
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glEnable(GL11.GL_LINE_SMOOTH);
		GL11.glDisable(GL11.GL_DEPTH_TEST);
		GL11.glDepthMask(false);
		GL11.glColor4f(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha());
		worldRenderer.begin(3, DefaultVertexFormats.POSITION_COLOR);
		worldRenderer.pos(x - width, y + width + yoffset, z + width)
				.color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
		worldRenderer.pos(x + width, y + width + yoffset, z + width)
				.color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
		tessellator.draw();
		worldRenderer.begin(3, DefaultVertexFormats.POSITION_COLOR);
		worldRenderer.pos(x - width, y - width + yoffset, z + width)
				.color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
		worldRenderer.pos(x + width, y - width + yoffset, z + width)
				.color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
		tessellator.draw();
		worldRenderer.begin(3, DefaultVertexFormats.POSITION_COLOR);
		worldRenderer.pos(x - width, y - width + yoffset, z - width)
				.color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
		worldRenderer.pos(x + width, y - width + yoffset, z - width)
				.color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
		tessellator.draw();
		worldRenderer.begin(3, DefaultVertexFormats.POSITION_COLOR);
		worldRenderer.pos(x - width, y + width + yoffset, z - width)
				.color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
		worldRenderer.pos(x + width, y + width + yoffset, z - width)
				.color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
		tessellator.draw();

		worldRenderer.begin(3, DefaultVertexFormats.POSITION_COLOR);
		worldRenderer.pos(x + width, y - width + yoffset, z + width)
				.color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
		worldRenderer.pos(x + width, y + width + yoffset, z + width)
				.color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
		tessellator.draw();
		worldRenderer.begin(3, DefaultVertexFormats.POSITION_COLOR);
		worldRenderer.pos(x - width, y - width + yoffset, z + width)
				.color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
		worldRenderer.pos(x - width, y + width + yoffset, z + width)
				.color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
		tessellator.draw();
		worldRenderer.begin(3, DefaultVertexFormats.POSITION_COLOR);
		worldRenderer.pos(x + width, y - width + yoffset, z - width)
				.color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
		worldRenderer.pos(x + width, y + width + yoffset, z - width)
				.color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
		tessellator.draw();
		worldRenderer.begin(3, DefaultVertexFormats.POSITION_COLOR);
		worldRenderer.pos(x - width, y - width + yoffset, z - width)
				.color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
		worldRenderer.pos(x - width, y + width + yoffset, z - width)
				.color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
		tessellator.draw();

		worldRenderer.begin(3, DefaultVertexFormats.POSITION_COLOR);
		worldRenderer.pos(x + width, y + width + yoffset, z + width)
				.color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
		worldRenderer.pos(x + width, y + width + yoffset, z + -width)
				.color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
		tessellator.draw();
		worldRenderer.begin(3, DefaultVertexFormats.POSITION_COLOR);
		worldRenderer.pos(x - width, y + width + yoffset, z + width)
				.color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
		worldRenderer.pos(x - width, y + width + yoffset, z - width)
				.color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
		tessellator.draw();
		worldRenderer.begin(3, DefaultVertexFormats.POSITION_COLOR);
		worldRenderer.pos(x + width, y - width + yoffset, z + width)
				.color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
		worldRenderer.pos(x + width, y - width + yoffset, z - width)
				.color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
		tessellator.draw();
		worldRenderer.begin(3, DefaultVertexFormats.POSITION_COLOR);
		worldRenderer.pos(x - width, y - width + yoffset, z + width)
				.color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
		worldRenderer.pos(x - width, y - width + yoffset, z - width)
				.color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
		tessellator.draw();

		GL11.glDisable(GL11.GL_LINE_SMOOTH);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glEnable(GL11.GL_DEPTH_TEST);
		GL11.glDepthMask(true);
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glPopMatrix();
	}

	public static void renderBlockESPBox(Color color,BlockPos blockPos) {
		double size = 0.5;
		double offset = 0.5;
		double x =
	            blockPos.getX()
	                - Minecraft.getMinecraft().getRenderManager().renderPosX;
	        double y =
	            blockPos.getY()
	                - Minecraft.getMinecraft().getRenderManager().renderPosY;
	        double z =
	            blockPos.getZ()
	                - Minecraft.getMinecraft().getRenderManager().renderPosZ;
	        GL11.glBlendFunc(770, 771);
	        GL11.glEnable(GL11.GL_BLEND);
	        GL11.glLineWidth(2.0F);
	        GL11.glColor4d(0, 1, 0, 0.15F);
	        GL11.glDisable(GL11.GL_TEXTURE_2D);
	        GL11.glDisable(GL11.GL_DEPTH_TEST);
	        GL11.glDepthMask(false);
	        //drawColorBox(new AxisAlignedBB(x, y, z, x + 1.0, y + 1.0, z + 1.0));
	        GL11.glColor4d(0, 0, 1, 0.5F);
	        
	        worldRenderer.begin(3, DefaultVertexFormats.POSITION_COLOR);
			worldRenderer.pos(x - size + offset, y + size+ offset, z + size+ offset)
					.color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
			worldRenderer.pos(x + size+ offset, y + size+ offset , z + size+ offset)
					.color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
			tessellator.draw();
			worldRenderer.begin(3, DefaultVertexFormats.POSITION_COLOR);
			worldRenderer.pos(x - size+ offset, y - size+ offset , z + size+ offset)
					.color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
			worldRenderer.pos(x + size+ offset, y - size+ offset , z + size+ offset)
					.color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
			tessellator.draw();
			worldRenderer.begin(3, DefaultVertexFormats.POSITION_COLOR);
			worldRenderer.pos(x - size+ offset, y - size+ offset, z - size+ offset)
					.color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
			worldRenderer.pos(x + size+ offset, y - size+ offset , z - size+ offset)
					.color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
			tessellator.draw();
			worldRenderer.begin(3, DefaultVertexFormats.POSITION_COLOR);
			worldRenderer.pos(x - size+ offset, y + size+ offset, z - size+ offset)
					.color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
			worldRenderer.pos(x + size+ offset, y + size+ offset, z - size+ offset)
					.color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
			tessellator.draw();

			worldRenderer.begin(3, DefaultVertexFormats.POSITION_COLOR);
			worldRenderer.pos(x + size+ offset, y - size+ offset, z + size+ offset)
					.color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
			worldRenderer.pos(x + size+ offset, y + size+ offset, z + size+ offset)
					.color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
			tessellator.draw();
			worldRenderer.begin(3, DefaultVertexFormats.POSITION_COLOR);
			worldRenderer.pos(x - size+ offset, y - size+ offset, z + size+ offset)
					.color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
			worldRenderer.pos(x - size+ offset, y + size+ offset , z + size+ offset)
					.color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
			tessellator.draw();
			worldRenderer.begin(3, DefaultVertexFormats.POSITION_COLOR);
			worldRenderer.pos(x + size+ offset, y - size + offset, z - size+ offset)
					.color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
			worldRenderer.pos(x + size+ offset, y + size + offset, z - size+ offset)
					.color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
			tessellator.draw();
			worldRenderer.begin(3, DefaultVertexFormats.POSITION_COLOR);
			worldRenderer.pos(x - size+ offset, y - size+ offset, z - size+ offset)
					.color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
			worldRenderer.pos(x - size+ offset, y + size+ offset, z - size+ offset)
					.color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
			tessellator.draw();

			worldRenderer.begin(3, DefaultVertexFormats.POSITION_COLOR);
			worldRenderer.pos(x + size+ offset, y + size+ offset, z + size+ offset)
					.color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
			worldRenderer.pos(x + size+ offset, y + size+ offset, z + - size+ offset)
					.color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
			tessellator.draw();
			worldRenderer.begin(3, DefaultVertexFormats.POSITION_COLOR);
			worldRenderer.pos(x - size+ offset, y + size+ offset, z + size+ offset)
					.color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
			worldRenderer.pos(x - size+ offset, y + size+ offset, z - size+ offset)
					.color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
			tessellator.draw();
			worldRenderer.begin(3, DefaultVertexFormats.POSITION_COLOR);
			worldRenderer.pos(x + size+ offset, y - size+ offset, z + size+ offset)
					.color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
			worldRenderer.pos(x + size+ offset, y - size+ offset, z - size+ offset)
					.color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
			tessellator.draw();
			worldRenderer.begin(3, DefaultVertexFormats.POSITION_COLOR);
			worldRenderer.pos(x - size+ offset, y - size+ offset, z + size+ offset)
					.color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
			worldRenderer.pos(x - size+ offset, y - size+ offset, z - size+ offset)
					.color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
			tessellator.draw();
	        
	        //RenderGlobal.drawSelectionBoundingBox(new AxisAlignedBB(x, y, z, x + 1.0F, y + 1.0F, z + 1.0F));
	        GL11.glEnable(GL11.GL_TEXTURE_2D);
	        GL11.glEnable(GL11.GL_DEPTH_TEST);
	        GL11.glDepthMask(true);
	        GL11.glDisable(GL11.GL_BLEND);
	}
	
	public static void renderPlayerESPBox(Color color, double x, double y, double z, float width, float height,
			double yoffset) {
		Tessellator tessellator = Tessellator.getInstance();
		WorldRenderer worldRenderer = tessellator.getWorldRenderer();

		GL11.glPushMatrix();
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(770, 771);
		// GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glEnable(GL11.GL_LINE_SMOOTH);
		GL11.glDisable(GL11.GL_DEPTH_TEST);
		GL11.glDepthMask(false);
		GL11.glColor4f(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha());
		worldRenderer.begin(3, DefaultVertexFormats.POSITION_COLOR);
		worldRenderer.pos(x - width, y + height + yoffset, z + width)
				.color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
		worldRenderer.pos(x + width, y + height + yoffset, z + width)
				.color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
		tessellator.draw();
		worldRenderer.begin(3, DefaultVertexFormats.POSITION_COLOR);
		worldRenderer.pos(x - width, y - height + yoffset, z + width)
				.color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
		worldRenderer.pos(x + width, y - height + yoffset, z + width)
				.color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
		tessellator.draw();
		worldRenderer.begin(3, DefaultVertexFormats.POSITION_COLOR);
		worldRenderer.pos(x - width, y - height + yoffset, z - width)
				.color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
		worldRenderer.pos(x + width, y - height + yoffset, z - width)
				.color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
		tessellator.draw();
		worldRenderer.begin(3, DefaultVertexFormats.POSITION_COLOR);
		worldRenderer.pos(x - width, y + height + yoffset, z - width)
				.color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
		worldRenderer.pos(x + width, y + height + yoffset, z - width)
				.color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
		tessellator.draw();

		worldRenderer.begin(3, DefaultVertexFormats.POSITION_COLOR);
		worldRenderer.pos(x + width, y - height + yoffset, z + width)
				.color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
		worldRenderer.pos(x + width, y + height + yoffset, z + width)
				.color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
		tessellator.draw();
		worldRenderer.begin(3, DefaultVertexFormats.POSITION_COLOR);
		worldRenderer.pos(x - width, y - height + yoffset, z + width)
				.color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
		worldRenderer.pos(x - width, y + height + yoffset, z + width)
				.color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
		tessellator.draw();
		worldRenderer.begin(3, DefaultVertexFormats.POSITION_COLOR);
		worldRenderer.pos(x + width, y - height + yoffset, z - width)
				.color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
		worldRenderer.pos(x + width, y + height + yoffset, z - width)
				.color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
		tessellator.draw();
		worldRenderer.begin(3, DefaultVertexFormats.POSITION_COLOR);
		worldRenderer.pos(x - width, y - height + yoffset, z - width)
				.color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
		worldRenderer.pos(x - width, y + height + yoffset, z - width)
				.color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
		tessellator.draw();

		worldRenderer.begin(3, DefaultVertexFormats.POSITION_COLOR);
		worldRenderer.pos(x + width, y + height + yoffset, z + width)
				.color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
		worldRenderer.pos(x + width, y + height + yoffset, z + -width)
				.color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
		tessellator.draw();
		worldRenderer.begin(3, DefaultVertexFormats.POSITION_COLOR);
		worldRenderer.pos(x - width, y + height + yoffset, z + width)
				.color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
		worldRenderer.pos(x - width, y + height + yoffset, z - width)
				.color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
		tessellator.draw();
		worldRenderer.begin(3, DefaultVertexFormats.POSITION_COLOR);
		worldRenderer.pos(x + width, y - height + yoffset, z + width)
				.color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
		worldRenderer.pos(x + width, y - height + yoffset, z - width)
				.color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
		tessellator.draw();
		worldRenderer.begin(3, DefaultVertexFormats.POSITION_COLOR);
		worldRenderer.pos(x - width, y - height + yoffset, z + width)
				.color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
		worldRenderer.pos(x - width, y - height + yoffset, z - width)
				.color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
		tessellator.draw();

		GL11.glDisable(GL11.GL_LINE_SMOOTH);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		// GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glEnable(GL11.GL_DEPTH_TEST);
		GL11.glDepthMask(true);
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glPopMatrix();
	}

}
