package me.Nissl.Nissclt.modules;

import java.util.ArrayList;
import java.util.List;

import me.Nissl.Nissclt.Nissclt;
import me.Nissl.Nissclt.modules.impl.Combat.KillAaura;
import me.Nissl.Nissclt.modules.impl.Movement.*;
import me.Nissl.Nissclt.modules.impl.Player.AutoArmor;
import me.Nissl.Nissclt.modules.impl.Player.Cheststealer;
import me.Nissl.Nissclt.modules.impl.Player.FastPlace;
import me.Nissl.Nissclt.modules.impl.Player.InventoryCleaner;
import me.Nissl.Nissclt.modules.impl.Player.InventoryManager;
import me.Nissl.Nissclt.modules.impl.Player.InventorySorter;
import me.Nissl.Nissclt.modules.impl.Player.MidClick;
import me.Nissl.Nissclt.modules.impl.Render.ChestESP;
import me.Nissl.Nissclt.modules.impl.Render.FullBright;
import me.Nissl.Nissclt.modules.impl.Render.BarrierESP;
import me.Nissl.Nissclt.modules.impl.Render.ItemESP;
import me.Nissl.Nissclt.modules.impl.Render.PlayerESP;
import net.minecraft.world.gen.structure.StructureStrongholdPieces.ChestCorridor;

public class ModuleManager {

	public List<Module> modules = new ArrayList<Module>();
	
	public ModuleManager() {
		//Combat
		addModule(new KillAaura());
		
		//Movement
		addModule(new Step());
		addModule(new Sprint());
		addModule(new Fly());
		addModule(new NoSlowDown());
		addModule(new Speed());
		addModule(new SafeWalk());
		addModule(new ScaffoldWalk());
		
		//Player
		addModule(new FastPlace());
		addModule(new Cheststealer());
		addModule(new MidClick());
//		addModule(new InventoryCleaner());
//		addModule(new AutoArmor());
//		addModule(new InventorySorter());
		addModule(new InventoryManager());
		
		//Render
		addModule(new FullBright());
		addModule(new ItemESP());
		addModule(new PlayerESP());
		addModule(new ChestESP());
		addModule(new BarrierESP());
		
		Nissclt.instance.logger.info("Loaded Modules: " +  modules.size());
		
	}
	
	public void addModule(Module module) {
		
		this.modules.add(module);
		Nissclt.instance.logger.loading("Module: " + module.getName());
	}
	
	public List<Module> getModules() {
		
		return modules;
	
	}
	
	public Module getModuleByName(String moduleName) {
		
		for(Module mod : modules) {
			if((mod.getName().trim().equalsIgnoreCase(moduleName)) || (mod.toString().trim().equalsIgnoreCase(moduleName.trim()))) {
				return mod;
			}
		}
		return null;
	
	}
	
	public Module getModule(Class <? extends Module> clazz) {
		
		for(Module mod : modules) {
			return mod;
		}
		return null;
	}
	
}
