package org.halvors.ConcentratedSolars.common.item;

import org.halvors.ConcentratedSolars.ConcentratedSolars;
import org.halvors.ConcentratedSolars.Reference;

import net.minecraft.item.Item;

public class ItemParabol extends Item {
	public ItemParabol() {
		setUnlocalizedName("itemParabol");
		setCreativeTab(ConcentratedSolars.tabConcentratedSolars);
		setTextureName(Reference.PREFIX + "itemParabol");
	}
}

