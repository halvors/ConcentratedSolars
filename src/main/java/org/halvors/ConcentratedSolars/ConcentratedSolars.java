package org.halvors.ConcentratedSolars;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import org.halvors.ConcentratedSolars.client.gui.GuiHandler;
import org.halvors.ConcentratedSolars.common.CommonProxy;
import org.halvors.ConcentratedSolars.common.block.BlockSolarPanel;
import org.halvors.ConcentratedSolars.common.item.ItemSolarPanel;
import org.halvors.ConcentratedSolars.common.tileentity.TileEntitySolarPanel;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = Reference.ID, name = Reference.NAME, version = Reference.VERSION)
public class ConcentratedSolars {
	// Says where the client and server 'proxy' code is loaded.
	@SidedProxy(clientSide = "org.halvors.ConcentratedSolars.client.ClientProxy", serverSide = "org.halvors.ConcentratedSolars.common.CommonProxy")
	public static CommonProxy proxy;

	// The instance of your mod that Forge uses.
	@Instance(value = Reference.ID)
	public static ConcentratedSolars instance;

	// Items
	
	// Blocks
	public static Block blockSolarPanel;

	// Creative tab
	public static CreativeTabConcentratedSolars tabConcentratedSolars = new CreativeTabConcentratedSolars();

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.registerRenderers();	
		
		// Register GUI handler.
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
		
		// Call functions for adding blocks etc.
		addBlocks();
		addItems();
		addTileEntities();
		addRecipes();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		// Nothing to see here.
	}

	public void addBlocks() {
		// Create blocks.
		blockSolarPanel = new BlockSolarPanel();

		// Register blocks.
		GameRegistry.registerBlock(blockSolarPanel, ItemSolarPanel.class, "blockSolarPanel");
	}

	public void addItems() {
		// Create items.
		
		// Register items.
	}
	
	public void addTileEntities() {
		// Register tile entities.
		GameRegistry.registerTileEntity(TileEntitySolarPanel.class, "tileEntitySolarPanel");
	}

	public void addRecipes() {
		// Register recipes.
	}
}