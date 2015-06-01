package org.halvors.ConcentratedSolars.block;

import nova.core.block.component.StaticBlockRenderer;
import nova.core.component.misc.Collider;
import nova.core.game.Game;
import nova.core.inventory.Inventory;
import nova.core.inventory.InventorySimple;
import nova.core.network.PacketHandler;
import nova.core.util.transform.shape.Cuboid;
import org.halvors.ConcentratedSolars.ConcentratedSolars;

import java.util.Optional;

/**
 * This the solar panel block.
 * @author halvors
 */
public class BlockSolarPanel extends BlockBasic implements PacketHandler {
    public Inventory inventory = new InventorySimple(1);

    public BlockSolarPanel() {
		super();

        add(new StaticBlockRenderer(this)).setTexture((direction) -> {
            switch (direction) {
                case UP:
                    return Optional.of(ConcentratedSolars.solarPanelTextures.get(0));

                case DOWN:
                    return Optional.of(ConcentratedSolars.solarPanelTextures.get(2));

                default:
                    return Optional.of(ConcentratedSolars.solarPanelTextures.get(0));
            }
        });

        add(new Collider().setBoundingBox(new Cuboid(0.0F, 0.0F, 0.0F, 1.0F, 0.3F, 1.0F)));

        rightClickEvent.add(this::onRightClick);

        /*
        Not ported features.

		setHardness(3.5F);
		setResistance(8F);
		setStepSound(soundTypeMetal);
		*/
    }

    public void onRightClick(RightClickEvent event) {
        ConcentratedSolars.getInstance().guiManager.showGui("guiSolarPanel",  event.entity, position());

        Game.network().sync(this);
    }

    @Override
    public String getID() {
        return "blockSolarPanel";
    }
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
