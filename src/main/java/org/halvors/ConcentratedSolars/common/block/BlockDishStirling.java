package org.halvors.ConcentratedSolars.common.block;

import org.halvors.ConcentratedSolars.ConcentratedSolars;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockDishStirling extends BlockContainer {
	public BlockDishStirling() {
		super(Material.iron);
		
		setBlockName("blockDishStirling");
		setHardness(3.5F);
		setResistance(8F);
		setCreativeTab(ConcentratedSolars.tabConcentratedSolars);
		setStepSound(soundTypeMetal);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int metadata) {
		return null;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
    public boolean isOpaqueCube() {
		return false;
	}
}
