package xyz.risingthumb.navigator.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

public class GuiButtonSmall extends GuiButton {
	private final ResourceLocation location;
	private final int textureX;
	private final int textureY;
	private final String text;
	
	public GuiButtonSmall(ResourceLocation location, int buttonId, int x, int y, int width, int height, int textureX, int textureY, String text) {
        super(buttonId, x, y, width, height, text);

        this.location = location;
        this.textureX = textureX;
        this.textureY = textureY;
        this.text = text;
    }
	
	@Override
    public void drawButton(Minecraft mc, int mouseX, int mouseY, float partialTicks) {
        if (!enabled) return;

        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        mc.renderEngine.bindTexture(location);
        this.hovered = isHovered(mouseX, mouseY);

        if (!hovered) {
            drawTexturedModalRect(x, y, textureX, textureY, width, height);
        } else {
            drawTexturedModalRect(x, y, textureX+this.width, textureY, width, height);
        }
        drawString(Minecraft.getMinecraft().fontRenderer,this.text,x+(this.width/4), y+2,Integer.parseInt("FFFFFF", 16));
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
    }
	
	public boolean isHovered(int mouseX, int mouseY) {
        return (mouseX >= this.x && mouseX < this.x + this.width && mouseY >= this.y && mouseY < this.y + this.height);
    }

}
