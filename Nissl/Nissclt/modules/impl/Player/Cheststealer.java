package me.Nissl.Nissclt.modules.impl.Player;

import org.lwjgl.input.Keyboard;

import com.darkmagician6.eventapi.EventManager;
import com.darkmagician6.eventapi.EventTarget;

import me.Nissl.Nissclt.events.EventUpdate;
import me.Nissl.Nissclt.modules.Category;
import me.Nissl.Nissclt.modules.Module;
import me.Nissl.Nissclt.utils.TimeHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerChest;
import net.minecraft.item.ItemStack;

public class Cheststealer extends Module {

	public TimeHelper time = new TimeHelper();

	public Cheststealer() {
		super("Cheststealer", "Cheststealer", Keyboard.KEY_L, 0x004a1f, Category.PLAYER);

	}

	@EventTarget
	public void onUpdate(EventUpdate e) {
		if ((this.mc.thePlayer.openContainer != null) && (this.mc.thePlayer.openContainer instanceof ContainerChest)) {
			ContainerChest chest = (ContainerChest) this.mc.thePlayer.openContainer;
			for (int i = 0; i < chest.getLowerChestInventory().getSizeInventory(); i++) {
				if ((chest.getLowerChestInventory().getStackInSlot(i) != null) && (this.time.hasReached(40L))) {
					this.mc.playerController.windowClick(chest.windowId, i, 0, 1, this.mc.thePlayer);
					this.time.reset();
				}
			}
			if(checkEmpty(chest)) {
				mc.thePlayer.closeScreen();
			}
		}
	}
	
	private boolean checkEmpty (ContainerChest chest) {
		for(int i = 0; i < chest.getLowerChestInventory().getSizeInventory(); i++) {
			ItemStack stack = chest.getLowerChestInventory().getStackInSlot(i);
			if(stack!=null)
				return false;
		}
		return true;
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
