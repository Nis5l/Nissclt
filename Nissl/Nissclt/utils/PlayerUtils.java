package me.Nissl.Nissclt.utils;

import net.minecraft.client.Minecraft;

public class PlayerUtils {

	public static boolean aacdamage = false;
	public static double aacdamagevalue;
	
	public static void damagePlayer(double value) {
		aacdamage = true;
		aacdamagevalue = value + 2.85D;
		Minecraft.getMinecraft().thePlayer.moveForward++;
		Minecraft.getMinecraft().thePlayer.moveForward--;
		Minecraft.getMinecraft().thePlayer.moveStrafing--;
		Minecraft.getMinecraft().thePlayer.moveStrafing++;
		Minecraft.getMinecraft().thePlayer.jump();
	}
	
}
