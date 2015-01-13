package org.halvors.ConcentratedSolars.common.block;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import org.halvors.ConcentratedSolars.ConcentratedSolars;
import org.halvors.ConcentratedSolars.common.tileentity.TileEntitySolarPanel;

public class BlockSolarPanel extends BlockContainer {
	public BlockSolarPanel(String name) {
		super(Material.iron);

		setBlockName(name);
		setHardness(3.5F);
		setResistance(8F);
		setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.3F, 1.0F);
		setCreativeTab(ConcentratedSolars.tabConcentratedSolars);
		setStepSound(soundTypeMetal);
		setBlockTextureName("ConcentratedSolars:blockSolarPanel");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int metadata) {
		return new TileEntitySolarPanel();
	}
	
	@Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int metadata, float what, float these, float are) {
        TileEntity tileEntity = world.getTileEntity(x, y, z);
        
        if (tileEntity == null || player.isSneaking()) {
                return false;
        }
        
	    player.openGui(ConcentratedSolars.instance, 0, world, x, y, z);
	    
	    return true;
	}
}
