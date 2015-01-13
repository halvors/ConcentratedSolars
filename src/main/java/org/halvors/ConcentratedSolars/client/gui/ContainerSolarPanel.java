package org.halvors.ConcentratedSolars.client.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;

import org.halvors.ConcentratedSolars.common.tileentity.TileEntitySolarPanel;

public class ContainerSolarPanel extends Container {
	private TileEntitySolarPanel tileEntity;

	public ContainerSolarPanel(InventoryPlayer inventory,
			TileEntitySolarPanel tileEntity) {
		this.tileEntity = tileEntity;

		addSlotToContainer(new Slot((IInventory) tileEntity, 0, 56, 17));

		int slotX;

		for (slotX = 0; slotX < 3; ++slotX) {
			for (int slotY = 0; slotY < 9; ++slotY) {
				addSlotToContainer(new Slot(inventory, slotY + slotX * 9 + 9, 8 + slotY * 18, 84 + slotX * 18));
			}
		}

		for (slotX = 0; slotX < 9; ++slotX) {
			addSlotToContainer(new Slot(inventory, slotX, 8 + slotX * 18, 142));
		}
	}

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return ((IInventory) tileEntity).isUseableByPlayer(player);
	}
}