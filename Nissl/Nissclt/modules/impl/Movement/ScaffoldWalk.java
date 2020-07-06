package me.Nissl.Nissclt.modules.impl.Movement;

import javax.sound.midi.Soundbank;

import org.lwjgl.input.Keyboard;

import com.darkmagician6.eventapi.EventManager;
import com.darkmagician6.eventapi.EventTarget;
import com.ibm.icu.impl.ICUService.Key;

import io.netty.handler.codec.spdy.SpdyWindowUpdateFrame;
import me.Nissl.Nissclt.events.EventUpdate;
import me.Nissl.Nissclt.modules.Category;
import me.Nissl.Nissclt.modules.Module;
import net.minecraft.block.Block;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.network.play.client.C09PacketHeldItemChange;
import net.minecraft.network.play.client.C0APacketAnimation;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Rotations;

public class ScaffoldWalk extends Module {

	public ScaffoldWalk() {
		super("ScaffoldWalk", "ScaffoldWalk", Keyboard.KEY_NONE, 0x003457, Category.MOVEMENT);

	}

	private static float blockSideOffset = 0.1f;
	
	@EventTarget
	public static void OnUpdate(EventUpdate eventUpdate) {

		BlockPos blockOnPos = new BlockPos(mc.thePlayer.posX, mc.thePlayer.posY - 1, mc.thePlayer.posZ);
		Block blockOn = mc.theWorld.getBlockState(new BlockPos(blockOnPos)).getBlock();

		float yaw = Math.abs(mc.thePlayer.rotationYaw % 360);

		// System.out.println(mc.thePlayer.posX);
		// System.out.println(blockOnPos.getX() );
		//
		if (mc.thePlayer.posX >= blockOnPos.getX() + (1 - blockSideOffset)) {
			BlockPos nextBlockPos = new BlockPos(blockOnPos.getX() + 1, blockOnPos.getY(), blockOnPos.getZ());
			Block nextBlock = mc.theWorld.getBlockState(nextBlockPos).getBlock();
			if(Block.getIdFromBlock(nextBlock) == 0) {

				mc.thePlayer.isSneaking();
				System.out.println("d");
				mc.thePlayer.motionX = 0;
				mc.thePlayer.posX = blockOnPos.getX() + (1 - blockSideOffset);
				
			}
		}
		if (mc.thePlayer.posX <= blockOnPos.getX() + blockSideOffset) {
			BlockPos nextBlockPos = new BlockPos(blockOnPos.getX() -1, blockOnPos.getY(), blockOnPos.getZ());
			Block nextBlock = mc.theWorld.getBlockState(nextBlockPos).getBlock();
			if(Block.getIdFromBlock(nextBlock) == 0) {
				System.out.println("place");
			}
		}
		if (mc.thePlayer.posZ >= blockOnPos.getZ() + (1 - blockSideOffset)) {
			BlockPos nextBlockPos = new BlockPos(blockOnPos.getX(), blockOnPos.getY(), blockOnPos.getZ() + 1);
			Block nextBlock = mc.theWorld.getBlockState(nextBlockPos).getBlock();
			if(Block.getIdFromBlock(nextBlock) == 0) {
				System.out.println("place");
			}
		}
		if (mc.thePlayer.posZ <= blockOnPos.getZ() + blockSideOffset) {
			BlockPos nextBlockPos = new BlockPos(blockOnPos.getX(), blockOnPos.getY(), blockOnPos.getZ() - 1);
			Block nextBlock = mc.theWorld.getBlockState(nextBlockPos).getBlock();
			if(Block.getIdFromBlock(nextBlock) == 0) {
				System.out.println("place");
			}
		}

	}

	@Override
	public void onDisable() {
		EventManager.unregister(this);
	}

	@Override
	public void onEnable() {
		EventManager.register(this);
	}
}
