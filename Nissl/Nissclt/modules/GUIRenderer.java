package me.Nissl.Nissclt.modules;

import java.util.ArrayList;
import java.util.List;

import me.Nissl.Nissclt.Nissclt;
import me.Nissl.Nissclt.utils.ColorUtil;
import me.Nissl.Nissclt.utils.RenderUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.entity.Render;

public class GUIRenderer {

	private Minecraft mc = Minecraft.getMinecraft();

	List<Integer> renderModulesColorPre = new ArrayList<Integer>();
	int renderModulesColor = 0xFFFFFF;
	int renderModulesColorCount = 0;
	int activatedModulesCount = 0;

	public void renderModules() {
		renderModulesColorCount++;
		renderModulesColor = Nissclt.instance.colorUtil.rainbowColor(1000000L, 1.0f).getRGB();
		if (renderModulesColorCount >= 10) {
			renderModulesColorPre.add(renderModulesColor);
			renderModulesColorCount = 0;
		}
		if (renderModulesColorPre.size() - 1 > activatedModulesCount) {
			renderModulesColorPre.remove(0);
		}
		int index = 0;
		ScaledResolution sr = new ScaledResolution(this.mc);
		sr.getScaledWidth();
		sr.getScaledHeight();
		final FontRenderer fr = this.mc.fontRendererObj;
		int count = 0;
		int rendercolor = 0;
		activatedModulesCount = 0;
		for (Module m : Nissclt.instance.moduleManager.getModules()) {
			if (m.isEnabled() && m.visible) {
				activatedModulesCount++;
				if (renderModulesColorPre.size() - (count + 1) >= 0) {
					rendercolor = renderModulesColorPre.get(renderModulesColorPre.size() - (count + 1));
				} else {
					rendercolor = renderModulesColorPre.get(0);
				}
				RenderUtil.renderFontWithShadow(m.getDiplayName(),
						(sr.getScaledWidth() - fr.getStringWidth(m.getDiplayName()) - 5), 5 + (count * 10), 1, 1,
						m.renderModulesFontHeights, rendercolor, m.getColor());
				if (m.renderModulesFontHeights < 1) {
					m.renderModulesFontHeights += 0.1;
				}
				count += 1;
			} else if (m.renderModulesFontHeights > 0.1f) {
				RenderUtil.renderFontWithShadow(m.getDiplayName(),
						(sr.getScaledWidth() - fr.getStringWidth(m.getDiplayName()) - 5), 5 + (count * 10), 1, 1,
						m.renderModulesFontHeights, rendercolor, m.getColor());
				m.renderModulesFontHeights -= 0.1;
			}
		}
	}

	int renderNameColor = 0xFFFFFF;

	public void renderName() {
		renderNameColor = Nissclt.instance.colorUtil.rainbowColor(1000000L, 1.0f).getRGB();
		RenderUtil.renderFontWithShadow("" + Nissclt.instance.clientName, 3, 5, 1, 1, 1, renderNameColor, 0x000000);
		renderNameColor /= 2;
	}

	int renderVersionColor = 0xFFFFFF;

	public void renderVersion() {
		renderVersionColor = Nissclt.instance.colorUtil.rainbowColor(1000000L, 1.0f).getRGB();
		RenderUtil.renderFontWithShadow("" + Nissclt.instance.clientVersion, 40, 5, 1, 1, 1, renderVersionColor,
				0x000000);
	}

	int renderFPSColor = 0xFFFFFF;

	public void renderFPS() {
		renderFPSColor = Nissclt.instance.colorUtil.rainbowColor(1000000L, 1.0f).getRGB();
		RenderUtil.renderFontWithShadow("" + Minecraft.getMinecraft().getDebugFPS() + " FPS", 3, 17, 1, 1, 1,
				renderFPSColor, 0x000000);
	}

}
