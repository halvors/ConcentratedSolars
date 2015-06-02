package org.halvors.ConcentratedSolars.block;

import nova.core.block.component.ConnectedTextureRenderer;
import nova.core.block.component.StaticBlockRenderer;
import nova.core.component.misc.Collider;
import nova.core.game.Game;
import nova.core.network.PacketHandler;
import nova.core.util.transform.shape.Cuboid;
import org.halvors.ConcentratedSolars.ConcentratedSolars;

import java.util.Optional;

/**
 * This the solar panel block.
 *
 * @author halvors
 */
public class BlockSolarPanel extends BlockBasic implements PacketHandler {
    public BlockSolarPanel() {
        super();

        add(new ConnectedTextureRenderer(this, ConcentratedSolars.solarPanelTextureEdge)
                .setTexture((direction) -> Optional.of(ConcentratedSolars.solarPanelTexture)));

        /*
        add(new StaticBlockRenderer(this)).setTexture((direction) -> {
            switch (direction) {
                case UP:
                    return Optional.of(ConcentratedSolars.solarPanelTextures.get(0));

                case DOWN:
                    return Optional.of(ConcentratedSolars.solarPanelTextures.get(2));

                default:
                    return Optional.of(ConcentratedSolars.solarPanelTextures.get(1));
            }
        });
        */

        add(new Collider()
                .setBoundingBox(new Cuboid(0.0F, 0.0F, 0.0F, 1.0F, 0.2F, 1.0F))
                .isOpaqueCube(false));

        //rightClickEvent.add(this::onRightClick);

        /*
        Not ported features.

		setHardness(3.5F);
		setResistance(8F);
		setStepSound(soundTypeMetal);
		*/
    }

    public void onRightClick(RightClickEvent event) {
        ConcentratedSolars.getInstance().guiManager.showGui("guiBasic",  event.entity, position());

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
	*/
