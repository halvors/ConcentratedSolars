package org.halvors.ConcentratedSolars.block;

import nova.core.block.Stateful;
import nova.core.block.component.ConnectedTextureRenderer;
import nova.core.block.component.StaticBlockRenderer;
import nova.core.retention.Storable;
import nova.core.util.shape.Cuboid;
import org.halvors.ConcentratedSolars.ConcentratedSolars;

import java.util.Optional;

/**
 * This the solar panel block.
 *
 * @author halvors
 */
public class BlockSolarPanel extends BlockBasic implements Stateful {
    //private ConnectedTextureRenderer renderer = add(new ConnectedTextureRenderer(this, ConcentratedSolars.solarPanelTextureEdge));
    private StaticBlockRenderer renderer = add(new StaticBlockRenderer(this));

    public BlockSolarPanel() {
        super();

        collider.setBoundingBox(new Cuboid(0.0F, 0.0F, 0.0F, 1.0F, 0.2F, 1.0F));
        collider.isOpaqueCube(false);

        renderer.setTexture((direction) -> Optional.of(ConcentratedSolars.solarPanelTexture));

        /*
        renderer.setTexture((direction) -> {
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

        events.on(RightClickEvent.class).bind(this::onRightClick);

        /*
        Not ported features.

		setHardness(3.5F);
		setResistance(8F);
		setStepSound(soundTypeMetal);
		*/
    }

    public void onRightClick(RightClickEvent event) {
        game.guiManager.showGui("guiBasic",  event.entity, position());

        game.networkManager.sync(this);
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
