package me.Nissl.Nissclt.utils;

import org.lwjgl.input.Keyboard;

import me.Nissl.Nissclt.Nissclt;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;

public class Logger {
	
	
	
	public void loading(String text) {
		System.out.println("Loading >> " + text);
	}
	
	public void info(String text) {
		System.out.println("Info >> " + text);
	}
	
	public void error(String text) {
		System.out.println("Error >> " + text);
	}
	
	public void downloading(String text) {
		System.out.println("Downloading >> " + text);
	}
	
	public void creating(String text) {
		System.out.println("Creating >> " + text);
	} 
	
	public void sendChatWithPrefix(String message) {
		Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(Nissclt.instance.clientPrefix + message));
	}
	
	public void sendChatError(String message) {
		Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(Nissclt.instance.clientPrefix + "§cError: " + message));
	}
	
	public void sendChatInfo(String message) {
		Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(Nissclt.instance.clientPrefix + "§aInfo " + message));
	}
	
	public void sendLocalMessageInfo(String message) {
		Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("[" + Nissclt.clientName + " " + Nissclt.clientVersion + "]: " + message));
	}
	
}
