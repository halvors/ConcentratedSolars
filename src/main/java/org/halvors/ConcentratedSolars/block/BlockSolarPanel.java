package org.halvors.ConcentratedSolars.block;

import nova.core.block.Block;
import nova.core.block.Stateful;
import nova.core.block.component.StaticBlockRenderer;
import nova.core.component.Category;
import nova.core.component.misc.Collider;
import nova.core.component.renderer.ItemRenderer;
import nova.core.component.renderer.StaticRenderer;
import nova.core.render.model.Model;
import nova.core.retention.Storable;
import nova.core.util.transform.shape.Cuboid;
import org.halvors.ConcentratedSolars.ConcentratedSolars;

import java.util.Optional;

/**
 * This is simple solar panel block.
 * @author halvors
 */
public class BlockSolarPanel extends Block implements Storable, Stateful {
	public BlockSolarPanel() {
		add(new StaticBlockRenderer(this)).setTexture((dir) -> Optional.of(ConcentratedSolars.solarPanelTexture));
		add(new Collider());
		add(new ItemRenderer(this));
		add(new Category("buildingBlocks"));

		/*
		setBlockName("blockSolarPanel");
		setHardness(3.5F);
		setResistance(8F);
		setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.3F, 1.0F);
		setCreativeTab(ConcentratedSolars.tabConcentratedSolars);
		setStepSound(soundTypeMetal);
		*/
	}

	@Override
	public String getID() {
		return "blockSolarPanel";
	}

	/*
	@Override
	public TileEntity createNewTileEntity(World world, int metadata) {
		return new TileEntitySolarPanel();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		topIcon = iconRegister.registerIcon(Reference.PREFIX
				+ "blockSolarPanel_top");
		sideIcon = iconRegister.registerIcon(Reference.PREFIX
				+ "blockSolarPanel_side");
		bottomIcon = iconRegister.registerIcon(Reference.PREFIX
				+ "blockSolarPanel_bottom");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		switch (side) {
		case 1:
			return topIcon;

		case 0:
			return bottomIcon;

		default:
			return sideIcon;
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z,
			EntityPlayer player, int metadata, float what, float these,
			float are) {
		TileEntity tileEntity = world.getTileEntity(x, y, z);

		if (tileEntity == null || player.isSneaking()) {
			return false;
		}

		player.openGui(ConcentratedSolars.instance, 0, world, x, y, z);

		return true;
	}
	*/
}
