package org.halvors.ConcentratedSolars.common.block;

import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import org.halvors.ConcentratedSolars.ConcentratedSolars;

public class BlockSolarPanel extends BlockContainer {
	public BlockSolarPanel() {
		super(Material.iron);
		setHardness(3.5F);
		setResistance(8F);
		setCreativeTab(ConcentratedSolars.tabConcentratedSolars);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int metadata) {
		return null;
	}
}
