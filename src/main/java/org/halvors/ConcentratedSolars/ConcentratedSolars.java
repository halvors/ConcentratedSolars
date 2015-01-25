package org.halvors.ConcentratedSolars;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import org.halvors.ConcentratedSolars.client.gui.GuiHandler;
import org.halvors.ConcentratedSolars.common.CommonProxy;
import org.halvors.ConcentratedSolars.common.block.BlockDishStirling;
import org.halvors.ConcentratedSolars.common.block.BlockSolarPanel;
import org.halvors.ConcentratedSolars.common.item.ItemDishStirling;
import org.halvors.ConcentratedSolars.common.item.ItemMirror;
import org.halvors.ConcentratedSolars.common.item.ItemParabol;
import org.halvors.ConcentratedSolars.common.item.ItemSolarPanel;
import org.halvors.ConcentratedSolars.common.tileentity.TileEntityDishStirling;
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
	public static Item itemMirror;
	public static Item itemParabol;
	
	// Blocks
	public static Block blockSolarPanel;
	public static Block blockDishStirling;

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
		blockDishStirling = new BlockDishStirling();

		// Register blocks.
		GameRegistry.registerBlock(blockSolarPanel, ItemSolarPanel.class, "blockSolarPanel");
		GameRegistry.registerBlock(blockDishStirling, ItemDishStirling.class, "blockDishStirling");
	}

	public void addItems() {
		// Create items.
		itemMirror = new ItemMirror();
		itemParabol = new ItemParabol();
		
		// Register items.
		GameRegistry.registerItem(itemMirror, "itemMirror");
		GameRegistry.registerItem(itemParabol, "itemParabol");
	}
	
	public void addTileEntities() {
		// Register tile entities.
		GameRegistry.registerTileEntity(TileEntitySolarPanel.class, "tileEntitySolarPanel");
		GameRegistry.registerTileEntity(TileEntityDishStirling.class, "tileEntityDishStirling");
	}

	public void addRecipes() {
		// Register recipes.
		GameRegistry.addShapedRecipe(new ItemStack(itemMirror), 
				"ggg", "iii", "ggg", 
				'g', Blocks.glass,
				'i', Items.iron_ingot);
		
		GameRegistry.addShapedRecipe(new ItemStack(itemParabol), 
				" m ", "mmm", " m ", 
				'm', itemMirror);
		
		GameRegistry.addShapedRecipe(new ItemStack(blockDishStirling), 
				" p ", "psp", " p ", 
				'p', itemParabol,
				's', blockSolarPanel);
	}
}