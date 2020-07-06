package me.Nissl.Nissclt.modules.impl.Render;

import java.awt.Color;

import org.lwjgl.input.Keyboard;

import com.darkmagician6.eventapi.EventManager;
import com.jcraft.jorbis.Block;

import me.Nissl.Nissclt.modules.Category;
import me.Nissl.Nissclt.modules.Module;
import me.Nissl.Nissclt.utils.RenderUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntitySkull;
import net.minecraft.util.BlockPos;
import net.minecraft.world.chunk.Chunk;

public class BarrierESP extends Module{

	public BarrierESP() {
		super("BarrierESP", "BarrierESP", Keyboard.KEY_NONE, 0x3b0047, Category.RENDER);
		// TODO Auto-generated constructor stub
	}

	public void onRender() {
		
	}
		
	

	public void passive(TileEntitySkull tileEntitySkull) {
		Color color = (Color) Color.BLUE;
		render(color, tileEntitySkull.getPos()); 
	}

	public void render(Color color, BlockPos blockPos) {

		RenderUtil.renderBlockESPBox(color,blockPos);

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
