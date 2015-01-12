package org.halvors.ConcentratedSolars.client.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;

import org.halvors.ConcentratedSolars.common.tileentity.TileEntitySolarPanel;

public class ContainerSolarPanel extends Container {
    private TileEntitySolarPanel tileEntity;
	
	public ContainerSolarPanel (InventoryPlayer inventoryPlayer, TileEntitySolarPanel tileEntity) {
		this.tileEntity = tileEntity;
    }

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return ((IInventory) tileEntity).isUseableByPlayer(player);
	}
}