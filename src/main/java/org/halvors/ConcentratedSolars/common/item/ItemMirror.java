package org.halvors.ConcentratedSolars.common.item;

import org.halvors.ConcentratedSolars.ConcentratedSolars;
import org.halvors.ConcentratedSolars.Reference;

import net.minecraft.item.Item;

public class ItemMirror extends Item {
	public ItemMirror() {
		setCreativeTab(ConcentratedSolars.tabConcentratedSolars);
		setTextureName(Reference.PREFIX + "itemMirror");
	}
}
