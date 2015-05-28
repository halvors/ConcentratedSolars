package org.halvors.ConcentratedSolars;

import nova.core.loader.Loadable;

/**
 * A test Nova Mod
 *
 * @author Calclavia
 */
@NovaMod(id = Reference.ID, name = Reference.NAME, version = Reference.VERSION, novaVersion = "0.0.1")
public class ConcentratedSolars implements Loadable {
	public static ConcentratedSolars instance;

	// Items
	
	// Blocks
	//public static Block blockSolarPanel;

	// Creative tab
	//public static CreativeTabConcentratedSolars tabConcentratedSolars = new CreativeTabConcentratedSolars();

	public ConcentratedSolars() {

	}

	@Override
	public void preInit() {
		// Call functions for adding blocks etc.
		addBlocks();
		addItems();
		addTileEntities();
		addRecipes();
	}

	public void addBlocks() {
		// Create blocks.
		//blockSolarPanel = new BlockSolarPanel();

		// Register blocks.
		//GameRegistry.registerBlock(blockSolarPanel, ItemSolarPanel.class, "blockSolarPanel");
	}

	public void addItems() {
		// Create items.
		
		// Register items.
	}
	
	public void addTileEntities() {
		// Register tile entities.
		//GameRegistry.registerTileEntity(TileEntitySolarPanel.class, "tileEntitySolarPanel");
	}

	public void addRecipes() {
		// Register recipes.
	}
}