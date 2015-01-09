package org.halvors.ConcentratedSolars;

import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import org.halvors.ConcentratedSolars.common.CommonProxy;
import org.halvors.ConcentratedSolars.common.block.BlockSolarPanel;
import org.halvors.ConcentratedSolars.common.item.ItemBlockSolarPanel;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = "ConcentratedSolars", name = "ConcentratedSolars", version = "0.0.1", guiFactory = "org.halvors.ConcentratedSolars.client.gui.GuiHandler")
public class ConcentratedSolars {
	// Says where the client and server 'proxy' code is loaded.
	@SidedProxy(clientSide = "org.halvors.ConcentratedSolars.client.ClientProxy", serverSide = "org.halvors.ConcentratedSolars.common.CommonProxy")
	public static CommonProxy proxy;

	// The instance of your mod that Forge uses.
	@Instance(value = "ConcentratedSolars")
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
		
		// Initialize blocks.
		addBlocks();
		addItems();
		addRecipes();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		
	}

	public void addBlocks() {
		blockSolarPanel = new BlockSolarPanel("blockSolarPanel");

		GameRegistry.registerBlock(blockSolarPanel, ItemBlockSolarPanel.class, "blockSolarPanel");
	}

	public void addItems() {
		
	}

	public void addRecipes() {
		GameRegistry.addRecipe(new ItemStack(blockSolarPanel), "iii", "g", "i", 'i',
				Items.iron_ingot, 'g', Items.gold_ingot);
	}
}