package me.Nissl.Nissclt.utils;

import java.util.List;

import javax.swing.text.JTextComponent.KeyBinding;

import org.lwjgl.input.Keyboard;

import me.Nissl.Nissclt.Nissclt;
import me.Nissl.Nissclt.modules.Module;
import me.Nissl.Nissclt.modules.ModuleManager;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.IntHashMap;

public class ChatInputUtil {

	private Minecraft mc;
	private static String cToggle = ".toggle ";
	private static String cBind = ".bind ";
	private static String cUnbind = ".unbind ";
	KeyBinding key;

	public static boolean checkIfMessageIsCommand(String message) {
		boolean rtn = true;
		System.out.println("messgae sent: " + message);

		for (Module m : Nissclt.instance.moduleManager.getModules()) {

			if(message.startsWith(".")) {
				rtn = false;
			}
			if (message.equalsIgnoreCase(cToggle + m.getDiplayName())) {
				m.toggle();
				Nissclt.instance.logger.sendLocalMessageInfo("Toggled " + m.getDiplayName());
			}

			for (int c = 97; c <= 122; c++) {
				if (message.equalsIgnoreCase(cBind + m.getDiplayName() + " " + (char) c)) {
					c = Character.toUpperCase(c);
					int key = Keyboard.getKeyIndex("" + (char) c);
					m.setKeyBind(key);
					Nissclt.instance.logger.sendLocalMessageInfo("Bound " + m.getDiplayName() + " to " + Keyboard.getKeyName(key));
					return false;
				}
			}

			if (message.equalsIgnoreCase(cUnbind + m.getDiplayName())) {
				m.setKeyBind(Keyboard.CHAR_NONE);
				Nissclt.instance.logger.sendLocalMessageInfo("Unbound " + m.getDiplayName());
			}
		}

		return rtn;
	}

}
