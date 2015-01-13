package org.halvors.ConcentratedSolars.client.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.halvors.ConcentratedSolars.common.tileentity.TileEntitySolarPanel;
import org.lwjgl.opengl.GL11;

public class GuiSolarPanel extends GuiContainer {
	public GuiSolarPanel(InventoryPlayer inventoryPlayer,
			TileEntitySolarPanel tileEntity) {
		super(new ContainerSolarPanel(inventoryPlayer, tileEntity));
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float p_146976_1_,
			int p_146976_2_, int p_146976_3_) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.renderEngine.bindTexture(new ResourceLocation("/gui/trap.png"));
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
	}
}
