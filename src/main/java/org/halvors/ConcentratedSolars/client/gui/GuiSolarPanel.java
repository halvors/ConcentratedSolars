package org.halvors.ConcentratedSolars.client.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.halvors.ConcentratedSolars.common.tileentity.TileEntitySolarPanel;
import org.lwjgl.opengl.GL11;

public class GuiSolarPanel extends GuiContainer {
	public GuiSolarPanel(InventoryPlayer inventoryPlayer,
			TileEntitySolarPanel tileEntity) {
		super(new ContainerSolarPanel(inventoryPlayer, tileEntity));
	}

	@Override
    protected void drawGuiContainerForegroundLayer(int par1, int par2) {
		//draw text and stuff here
        //the parameters for drawString are: string, x, y, color
		fontRendererObj.drawString("Solar Panel", 8, 6, 4210752);
		
        //draws "Inventory" or your regional equivalent
		fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 8, ySize - 96 + 2, 4210752);
    }
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		mc.renderEngine.bindTexture(new ResourceLocation("ConcentratedSolars:gui/GuiBlank.png"));
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
	}
}
