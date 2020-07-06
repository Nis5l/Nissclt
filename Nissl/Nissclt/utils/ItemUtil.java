package me.Nissl.Nissclt.utils;

import java.util.List;

import com.mojang.realmsclient.dto.RealmsServer.McoServerComparator;

import me.Nissl.Nissclt.Nissclt;
import net.minecraft.client.Minecraft;
import net.minecraft.inventory.Container;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemUtil {

	public TimeHelper time = new TimeHelper();
	private int[] ChestPlateIDs = { 311, 307, 303, 315, 299 };
	private int[] LegginsIDs = { 312, 308, 304, 316, 300 };
	private int[] HelmetIDs = { 310, 306, 302, 314, 298 };
	private int[] BootIDs = { 313, 309, 305, 317, 301 };
	private int[] WeaponIDs = { 276, 267, 279, 272, 278, 258, 268, 283, 277, 257, 275, 256, 274, 271, 286, 273,
			270, 285, 269, 284 };

	public boolean isChestPlate(ItemStack itemStack) {

		for (int i = 0; i < ChestPlateIDs.length; i++) {
			if (Item.getIdFromItem(itemStack.getItem()) == ChestPlateIDs[i]) {
				return true;
			}
		}

		return false;
	}

	public boolean isLeggins(ItemStack itemStack) {

		for (int i = 0; i < LegginsIDs.length; i++) {
			if (Item.getIdFromItem(itemStack.getItem()) == LegginsIDs[i]) {
				return true;
			}
		}

		return false;
	}

	public boolean isHelmet(ItemStack itemStack) {

		for (int i = 0; i < HelmetIDs.length; i++) {
			if (Item.getIdFromItem(itemStack.getItem()) == HelmetIDs[i]) {
				return true;
			}
		}

		return false;
	}

	public boolean isBoots(ItemStack itemStack) {

		for (int i = 0; i < BootIDs.length; i++) {
			if (Item.getIdFromItem(itemStack.getItem()) == BootIDs[i]) {
				return true;
			}
		}

		return false;
	}

	public boolean isWeapon(ItemStack itemStack) {
		for (int i = 0; i < WeaponIDs.length; i++) {
			if (Item.getIdFromItem(itemStack.getItem()) == WeaponIDs[i]) {
				return true;
			}
		}

		return false;
	}

	public int getBestChestPlate(List<Integer> slots, Container container, ItemStack itemStack) {

		int best = ChestPlateIDs.length;
		int bestChestPlate = 0;

		if (itemStack != null) {
			for (int i = 0; i < ChestPlateIDs.length; i++) {
				if (Item.getIdFromItem(itemStack.getItem()) == ChestPlateIDs[i]) {
					best = i;
					bestChestPlate = -1;
				}
			}
		}

		for (int slot : slots) {
			for (int i = 0; i < ChestPlateIDs.length; i++) {
				if (Item.getIdFromItem(container.getSlot(slot).getStack().getItem()) == ChestPlateIDs[i]) {
					if (i < best) {
						best = i;
						bestChestPlate = slot;
					}
				}
			}
		}
		return bestChestPlate;
	}

	public int getBestLeggins(List<Integer> slots, Container container, ItemStack itemStack) {

		int best = LegginsIDs.length;
		int bestLeggins = 0;

		if (itemStack != null) {
			for (int i = 0; i < LegginsIDs.length; i++) {
				if (Item.getIdFromItem(itemStack.getItem()) == LegginsIDs[i]) {
					best = i;
					bestLeggins = -1;
				}
			}
		}

		for (int slot : slots) {
			for (int i = 0; i < LegginsIDs.length; i++) {
				if (Item.getIdFromItem(container.getSlot(slot).getStack().getItem()) == LegginsIDs[i]) {
					if (i < best) {
						best = i;
						bestLeggins = slot;
					}
				}
			}
		}
		return bestLeggins;
	}

	public int getBestHelmet(List<Integer> slots, Container container, ItemStack itemStack) {

		int best = HelmetIDs.length;
		int bestHelmet = 0;

		if (itemStack != null) {
			for (int i = 0; i < HelmetIDs.length; i++) {
				if (Item.getIdFromItem(itemStack.getItem()) == HelmetIDs[i]) {
					best = i;
					bestHelmet = -1;
				}
			}
		}

		for (int slot : slots) {
			for (int i = 0; i < HelmetIDs.length; i++) {
				if (Item.getIdFromItem(container.getSlot(slot).getStack().getItem()) == HelmetIDs[i]) {
					if (i < best) {
						best = i;
						bestHelmet = slot;
					}
				}
			}
		}
		return bestHelmet;
	}

	public int getBestBoots(List<Integer> slots, Container container, ItemStack itemStack) {

		int best = BootIDs.length;
		int bestBoots = 0;

		if (itemStack != null) {
			for (int i = 0; i < BootIDs.length; i++) {
				if (Item.getIdFromItem(itemStack.getItem()) == BootIDs[i]) {
					best = i;
					bestBoots = -1;
				}
			}
		}

		for (int slot : slots) {
			for (int i = 0; i < BootIDs.length; i++) {
				if (Item.getIdFromItem(container.getSlot(slot).getStack().getItem()) == BootIDs[i]) {
					if (i < best) {
						best = i;
						bestBoots = slot;
					}
				}
			}
		}
		return bestBoots;
	}

	public int getBestWeapon(List<Integer> slots, Container container) {

		int best = WeaponIDs.length;
		int bestSword = 0;
		if (container.getSlot(36).getStack() != null) {
			for (int i = 0; i < WeaponIDs.length; i++) {
				if (Item.getIdFromItem((container.getSlot(36).getStack().getItem())) == WeaponIDs[i]) {
					best = i;
					bestSword = -1;
				}
			}
		}

		for (int slot : slots) {
			for (int i = 0; i < WeaponIDs.length; i++) {
				if (Item.getIdFromItem(container.getSlot(slot).getStack().getItem()) == WeaponIDs[i]) {
					if (i < best) {
						best = i;
						bestSword = slot;
					}
				}
			}
		}
		
		return bestSword;
	}

	public void SwapItems(int slot1, int slot2) {
		if (this.time.hasReached(10L)) {
		Minecraft.getMinecraft().playerController.windowClick(
				Minecraft.getMinecraft().thePlayer.inventoryContainer.windowId, slot1, 1, 0,
				Minecraft.getMinecraft().thePlayer);
		}
		if (this.time.hasReached(20L)) {
		Minecraft.getMinecraft().playerController.windowClick(
				Minecraft.getMinecraft().thePlayer.inventoryContainer.windowId, slot2, 1, 0,
				Minecraft.getMinecraft().thePlayer);
		}
		if (this.time.hasReached(30L)) {
		Minecraft.getMinecraft().playerController.windowClick(
				Minecraft.getMinecraft().thePlayer.inventoryContainer.windowId, slot1, 1, 0,
				Minecraft.getMinecraft().thePlayer);
		time.reset();
		}
		
	}

	public int[] useFullItems = { 260, 262, 393, 363, 261, 297, 45, 99, 354, 391, 82, 173, 16, 4, 364, 366, 350,
			424, 320, 412, 357, 264, 57, 56, 3, 133, 129, 121, 368, 349, 346, 259, 20, 89, 41, 14, 322,
			172, 170, 79, 42, 15, 22, 21, 18, 161, 91, 17, 162, 103, 97, 48, 423, 110, 112, 87, 49, 174, 5, 319, 392,
			373, 168, 86, 155, 153, 411, 413, 100, 179, 153, 73, 24, 169, 80, 19, 95, 159, 1, 98, 98, 98, 98, 326,
			35 };

	public boolean isUseless(int id) {
		ItemStack itemStack = Minecraft.getMinecraft().thePlayer.inventoryContainer.getSlot(id).getStack();
		for (int itemID : useFullItems) {
			if (Item.getIdFromItem(itemStack.getItem()) == itemID) {
				System.out.println(itemStack);
				return false;
			}
		}
		//System.out.println(Nissclt.instance.bestWeaponSlot);
		if (id == 36 && Nissclt.instance.bestWeaponSlot == -1 || id == Nissclt.instance.bestWeaponSlot) {
			return false;
		}
		
		return true;
	}

}
