package me.Nissl.Nissclt.modules.impl.Player;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.input.Keyboard;

import com.darkmagician6.eventapi.EventManager;
import com.darkmagician6.eventapi.EventTarget;

import me.Nissl.Nissclt.Nissclt;
import me.Nissl.Nissclt.events.EventUpdate;
import me.Nissl.Nissclt.modules.Category;
import me.Nissl.Nissclt.modules.Module;
import me.Nissl.Nissclt.utils.ItemUtil;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;

public class InventorySorter extends Module {

	public InventorySorter() {
		super("InventorySorter", "InvSorter", Keyboard.KEY_NONE, 0x004a1f, Category.PLAYER);
	}

	Container container;
	List<Integer> swords = new ArrayList<Integer>();
	public ItemUtil itemUtil = new ItemUtil();

	@EventTarget
	public void OnUpdate(EventUpdate eventUpdate) {
		// invSort();
	}

	public void invSort() {

		swords.clear();
		for (int i = 9; i < 45; i++) {
			if (this.mc.thePlayer.inventoryContainer.getSlot(i).getStack() != null) {
				container = this.mc.thePlayer.inventoryContainer;
				ItemStack itemStack = container.getSlot(i).getStack();
				if (itemUtil.isWeapon(itemStack)) {
					swords.add(i);
				}
			}
		}

		Nissclt.instance.bestWeaponSlot = itemUtil.getBestWeapon(swords, container);
		//System.out.println(container.getSlot(Nissclt.instance.bestWeaponSlot).getStack());
		if (Nissclt.instance.bestWeaponSlot != -1) {

			if (this.mc.thePlayer.inventoryContainer.getSlot(36) != null) {
				itemUtil.SwapItems(Nissclt.instance.bestWeaponSlot, 36);

			} else {
				this.mc.playerController.windowClick(this.mc.thePlayer.inventoryContainer.windowId,
						Nissclt.instance.bestWeaponSlot, 1, 0, this.mc.thePlayer);
				this.mc.playerController.windowClick(this.mc.thePlayer.inventoryContainer.windowId, 36, 1, 0,
						this.mc.thePlayer);
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
