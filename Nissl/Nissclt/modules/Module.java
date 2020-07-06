package me.Nissl.Nissclt.modules;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import net.minecraft.entity.Entity;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityOtherPlayerMP;

public class Module {

	private String name;
	private String diplayName;
	private Category category;
	private int color;

	private int keyBind;
	public static boolean colormode = false;
	public static Minecraft mc = Minecraft.getMinecraft();

	public boolean toggled;
	public boolean visible;
	
	public static boolean hasHit = false;
	
	public float renderModulesFontHeights = 0.1f;

	public static List<UUID> midClickedPlayers = new ArrayList<UUID>();
	
	public Module(String name, String displayName, int keyBind, int color, Category category) {

		this.name = name;
		this.diplayName = displayName;
		this.category = category;
		this.keyBind = keyBind;
		this.visible = true;
		this.color = color;

	}

	public int getColor() {
		return color;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDiplayName() {
		return diplayName;
	}

	public void setDiplayName(String diplayName) {
		this.diplayName = diplayName;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public boolean isCategory(Category category) {
		return this.category == category;
	}

	public int getKeyBind() {
		return keyBind;
	}

	public void setKeyBind(int keyBind) {
		this.keyBind = keyBind;
	}

	public boolean isEnabled() {
		return toggled;
	}

	public void toggle() {

		if (toggled) {
			toggled = false;
			onDisable();
		} else {
			toggled = true;
			onEnable();
		}

	}

	//public boolean getHasHit() { return false;}
	
	public void onDisable() {
	}

	public void onEnable() {
	}

	public void onRender() {
	}
	
}
