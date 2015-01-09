package org.halvors.ConcentratedSolars;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CreativeTab extends CreativeTabs {
	public CreativeTab() {
		super("tabConsentratedSolars");
	}

	@Override
	public ItemStack getIconItemStack() {
		return new ItemStack(Blocks.dirt);
	}

	@Override
	public Item getTabIconItem() {
		return Items.arrow;
	}
}