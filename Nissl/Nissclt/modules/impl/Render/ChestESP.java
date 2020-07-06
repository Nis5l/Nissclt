package me.Nissl.Nissclt.modules.impl.Render;

import java.awt.Color;

import org.lwjgl.input.Keyboard;

import com.darkmagician6.eventapi.EventManager;

import me.Nissl.Nissclt.modules.Category;
import me.Nissl.Nissclt.modules.Module;
import me.Nissl.Nissclt.utils.RenderUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.BlockPos;

public class ChestESP extends Module{

	public ChestESP() {
		super("ChestESP", "ChestESP", Keyboard.KEY_J, 0x3b0047, Category.RENDER);
		// TODO Auto-generated constructor stub
	}

	public void onRender() {
		for (Object o : mc.theWorld.loadedTileEntityList) {
			if (o instanceof TileEntityChest) {
				TileEntityChest e = (TileEntityChest) o;
				passive(e);
				
			}
		}
	}

	public void passive(TileEntityChest tileEntityChest) {
		Color color = (Color) Color.BLUE;
		render(color, tileEntityChest.getPos()); 
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
