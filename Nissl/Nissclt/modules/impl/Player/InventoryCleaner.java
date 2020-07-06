package me.Nissl.Nissclt.modules.impl.Player;

import org.lwjgl.input.Keyboard;

import com.darkmagician6.eventapi.EventManager;
import com.darkmagician6.eventapi.EventTarget;

import me.Nissl.Nissclt.events.EventUpdate;
import me.Nissl.Nissclt.modules.Category;
import me.Nissl.Nissclt.modules.Module;
import me.Nissl.Nissclt.utils.ItemUtil;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;

public class InventoryCleaner extends Module {

	public InventoryCleaner() {
		super("InventoryCleaner", "InvCleaner", Keyboard.KEY_NONE, 0x004a1f, Category.PLAYER);
		
	}

	Container container;
	ItemUtil itemUtil = new ItemUtil();
	
	@EventTarget
	public void onUpdate(EventUpdate e) {
		// invClean();
	}

	public void invClean() {
		for (int i = 9; i < 45; i++) {
			if (this.mc.thePlayer.inventoryContainer.getSlot(i).getStack() != null) {
				container = this.mc.thePlayer.inventoryContainer;
				ItemStack itemStack = container.getSlot(i).getStack();
				if (itemStack != null) {
					if (itemUtil.isUseless(i)) {
						this.mc.playerController.windowClick(this.mc.thePlayer.inventoryContainer.windowId, i, 1, 4,
								this.mc.thePlayer);
					}
				}
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
