package org.halvors.ConcentratedSolars.client.gui;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.InventoryPlayer;

import org.halvors.ConcentratedSolars.common.tileentity.TileEntitySolarPanel;

public class GuiSolarPanel extends GuiScreen {
	public GuiSolarPanel(InventoryPlayer inventoryPlayer,
			TileEntitySolarPanel tileEntity) {
	}

	@Override
	public void drawScreen(int par1, int par2, float par3) {
		drawDefaultBackground();
	}
}
