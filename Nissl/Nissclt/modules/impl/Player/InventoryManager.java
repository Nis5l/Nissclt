package me.Nissl.Nissclt.modules.impl.Player;

import org.lwjgl.input.Keyboard;

import com.darkmagician6.eventapi.EventManager;
import com.darkmagician6.eventapi.EventTarget;

import me.Nissl.Nissclt.Nissclt;
import me.Nissl.Nissclt.events.EventUpdate;
import me.Nissl.Nissclt.modules.Category;
import me.Nissl.Nissclt.modules.Module;
import me.Nissl.Nissclt.utils.ItemUtil;
import me.Nissl.Nissclt.utils.TimeHelper;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.item.ItemStack;

public class InventoryManager extends Module {

	InventoryCleaner inventoryCleaner = new InventoryCleaner();
	InventorySorter inventorySorter = new InventorySorter();
	AutoArmor autoArmor = new AutoArmor();
	public TimeHelper time = new TimeHelper();

	public InventoryManager() {
		super("InventoryManager", "InvManager", Keyboard.KEY_NONE, 0x004a1f, Category.PLAYER);
	}

	@EventTarget
	public void onUpdate(EventUpdate e) {

		if (this.mc.currentScreen instanceof GuiInventory) {
			autoArmor.invAutoArmor();
			inventorySorter.invSort();
			inventoryCleaner.invClean();
			time.reset();
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
