package me.Nissl.Nissclt;

import java.io.File;
import java.net.Proxy;
import java.util.Map;

import org.lwjgl.opengl.Display;

import com.google.gson.GsonBuilder;
import com.mojang.authlib.Agent;
import com.mojang.authlib.exceptions.AuthenticationException;
import com.mojang.authlib.properties.PropertyMap;
import com.mojang.authlib.yggdrasil.YggdrasilAuthenticationService;
import com.mojang.authlib.yggdrasil.YggdrasilUserAuthentication;

import me.Nissl.Nissclt.modules.GUIRenderer;
import me.Nissl.Nissclt.modules.ModuleManager;
import me.Nissl.Nissclt.utils.ColorUtil;
import me.Nissl.Nissclt.utils.Logger;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;

public class Nissclt {

	public static Nissclt instance;
	public static String clientName = "Nissclt";
	public static String clientVersion = "b1.0";
	public String clientPrefix = "§7[§2" +  clientName + "§2]";
	public Logger logger;
	public ModuleManager moduleManager;
	public GUIRenderer guirenderer;
	public ColorUtil colorUtil;
	
	public File directory;
	public int bestWeaponSlot;
	
	public static void preStartClient() {
		Display.setTitle("Loading " + clientName + " " + clientVersion);
	}
	
	public void startClient() {
		instance = this;
		Display.setTitle(clientName + " " + clientVersion);
		directory = new File(Minecraft.getMinecraft().mcDataDir, clientName);
		if(!directory.exists()) {
			directory.mkdir();
		}
		logger = new Logger();
		moduleManager = new ModuleManager();
		guirenderer = new GUIRenderer();
		colorUtil = new ColorUtil();
	}
	
	
}
