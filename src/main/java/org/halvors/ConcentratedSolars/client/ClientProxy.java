package org.halvors.ConcentratedSolars.client;

import org.halvors.ConcentratedSolars.common.CommonProxy;
import org.halvors.ConcentratedSolars.common.tileentity.TileEntityDishStirling;
import org.halvors.ConcentratedSolars.common.tileentity.TileEntityDishStirlingSpecialRenderer;

import cpw.mods.fml.client.registry.ClientRegistry;

public class ClientProxy extends CommonProxy {
	@Override
	public void registerRenderers() {
		// This is for rendering entities and so forth later on
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDishStirling.class, new TileEntityDishStirlingSpecialRenderer());
	}
}