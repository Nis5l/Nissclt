package me.Nissl.Nissclt.modules.impl.Player;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.input.Keyboard;

import com.darkmagician6.eventapi.EventManager;
import com.darkmagician6.eventapi.EventTarget;

import me.Nissl.Nissclt.events.EventUpdate;
import me.Nissl.Nissclt.modules.Category;
import me.Nissl.Nissclt.modules.Module;
import me.Nissl.Nissclt.utils.ItemUtil;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerChest;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class AutoArmor extends Module {

	public AutoArmor() {
		super("AutoArmor", "AutoArmor", Keyboard.KEY_NONE, 0x004a1f, Category.PLAYER);
	}

	List<Integer> chestPlates = new ArrayList<Integer>();
	List<Integer> leggins = new ArrayList<Integer>();
	List<Integer> helmets = new ArrayList<Integer>();
	List<Integer> boots = new ArrayList<Integer>();
	Container container;
	int bestChestPlate;
	int bestLeggins;
	int bestHelmet;
	int bestBoots;
	ItemUtil itemUtil = new ItemUtil();

	@EventTarget
	public void onUpdate(EventUpdate e) {
		//invAutoArmor();
	}

	public void invAutoArmor() {

			chestPlates.clear();
			leggins.clear();
			helmets.clear();
			boots.clear();
			for (int i = 9; i < 45; i++) {
				if (this.mc.thePlayer.inventoryContainer.getSlot(i).getStack() != null) {
					container = this.mc.thePlayer.inventoryContainer;
					ItemStack itemStack = container.getSlot(i).getStack();
					if (itemUtil.isChestPlate(itemStack)) {
						chestPlates.add(i);
					} else if (itemUtil.isLeggins(itemStack)) {
						leggins.add(i);
					} else if (itemUtil.isHelmet(itemStack)) {
						helmets.add(i);
					} else if (itemUtil.isBoots(itemStack)) {
						boots.add(i);
					}
				}
			}

		if (this.mc.thePlayer.inventoryContainer.getSlot(6).getStack() != null) {
			bestChestPlate = itemUtil.getBestChestPlate(chestPlates, container,
					this.mc.thePlayer.inventoryContainer.getSlot(6).getStack());
		} else {
			bestChestPlate = itemUtil.getBestChestPlate(chestPlates, container, null);
		}

		if (this.mc.thePlayer.inventoryContainer.getSlot(7).getStack() != null) {
			bestLeggins = itemUtil.getBestLeggins(leggins, container,
					this.mc.thePlayer.inventoryContainer.getSlot(7).getStack());
		} else {
			bestLeggins = itemUtil.getBestLeggins(leggins, container, null);
		}

		if (this.mc.thePlayer.inventoryContainer.getSlot(5).getStack() != null) {
			bestHelmet = itemUtil.getBestHelmet(helmets, container,
					this.mc.thePlayer.inventoryContainer.getSlot(5).getStack());
		} else {
			bestHelmet = itemUtil.getBestHelmet(helmets, container, null);
		}

		if (this.mc.thePlayer.inventoryContainer.getSlot(8).getStack() != null) {
			bestBoots = itemUtil.getBestBoots(boots, container,
					this.mc.thePlayer.inventoryContainer.getSlot(8).getStack());
		} else {
			bestBoots = itemUtil.getBestBoots(boots, container, null);
		}

		if (this.mc.currentScreen instanceof GuiInventory) {
			if (bestChestPlate != -1) {
				if (this.mc.thePlayer.inventoryContainer.getSlot(6) != null) {
					itemUtil.SwapItems(bestChestPlate, 6);
				} else {
					this.mc.playerController.windowClick(container.windowId, bestChestPlate, 0, 1, this.mc.thePlayer);
				}
			}
			if (bestLeggins != -1) {
				if (this.mc.thePlayer.inventoryContainer.getSlot(7) != null) {
					itemUtil.SwapItems(bestLeggins, 7);
				} else {
					this.mc.playerController.windowClick(container.windowId, bestLeggins, 0, 1, this.mc.thePlayer);
				}
			}
			if (bestHelmet != -1) {
				if (this.mc.thePlayer.inventoryContainer.getSlot(5) != null) {
					itemUtil.SwapItems(bestHelmet, 5);
				} else {
					this.mc.playerController.windowClick(container.windowId, bestHelmet, 0, 1, this.mc.thePlayer);
				}
			}
			if (bestBoots != -1) {
				if (this.mc.thePlayer.inventoryContainer.getSlot(8) != null) {
					itemUtil.SwapItems(bestBoots, 8);
				} else {
					this.mc.playerController.windowClick(container.windowId, bestBoots, 0, 1, this.mc.thePlayer);
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
