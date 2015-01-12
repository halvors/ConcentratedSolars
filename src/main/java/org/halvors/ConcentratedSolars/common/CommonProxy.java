package org.halvors.ConcentratedSolars.common;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import org.halvors.ConcentratedSolars.client.gui.ContainerSolarPanel;
import org.halvors.ConcentratedSolars.client.gui.GuiSolarPanel;
import org.halvors.ConcentratedSolars.common.tileentity.TileEntitySolarPanel;

import cpw.mods.fml.common.network.IGuiHandler;

public class CommonProxy implements IGuiHandler {
	// Client stuff
	public void registerRenderers() {
		// Nothing here as the server doesn't render graphics or entities!
	}

	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world,
			int x, int y, int z) {
		TileEntity tileEntity = world.getTileEntity(x, y, z);
		if (tileEntity instanceof TileEntitySolarPanel) {
			return new ContainerSolarPanel(player.inventory, (TileEntitySolarPanel) tileEntity);
		}

		return null;
	}

	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world,
			int x, int y, int z) {
		TileEntity tileEntity = world.getTileEntity(x, y, z);
		if (tileEntity instanceof TileEntitySolarPanel) {
			return new GuiSolarPanel(player.inventory, (TileEntitySolarPanel) tileEntity);
		}

		return null;
	}
}