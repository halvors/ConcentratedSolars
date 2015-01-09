package org.halvors.ConcentratedSolars;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CreativeTabConcentratedSolars extends CreativeTabs {
	public CreativeTabConcentratedSolars() {
		super("tabConcentratedSolars");
	}

	@Override
	public ItemStack getIconItemStack() {
		return new ItemStack(ConcentratedSolars.blockSolarPanel);
	}

	@Override
	public Item getTabIconItem() {
		return Items.arrow;
	}
}