package org.halvors.ConcentratedSolars.client.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import org.halvors.ConcentratedSolars.common.tileentity.TileEntitySolarPanel;

import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		TileEntity tileEntity = world.getTileEntity(x, y, z);
		
		if (tileEntity instanceof TileEntitySolarPanel) {
			return new GuiSolarPanel(player.inventory, (TileEntitySolarPanel) tileEntity);
		}
		
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		TileEntity tileEntity = world.getTileEntity(x, y, z);
		
		if (tileEntity instanceof TileEntitySolarPanel) {
			return new GuiSolarPanel(player.inventory, (TileEntitySolarPanel) tileEntity);
		}
		
		return null;
	}
}
