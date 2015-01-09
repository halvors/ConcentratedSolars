package org.halvors.ConcentratedSolars;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import org.halvors.ConcentratedSolars.common.CommonProxy;
import org.halvors.ConcentratedSolars.common.block.GeneratorBlock;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = "ConcentratedSolars", name = "ConcentratedSolars", version = "0.0.1")
public class ConcentratedSolars {
	// Says where the client and server 'proxy' code is loaded.
	@SidedProxy(clientSide = "org.halvors.ConcentratedSolars.client.ClientProxy", serverSide = "org.halvors.ConcentratedSolars.common.CommonProxy")
	public static CommonProxy proxy;

	public static Block generatorBlock = new GeneratorBlock(Material.anvil).setBlockName("Solar Panel");
	
	// The instance of your mod that Forge uses.
	@Instance(value = "ConcentratedSolars")
	public static ConcentratedSolars instance;
	
	// Mekanism creative tab
	public static CreativeTab tabConcentratedSolars = new CreativeTab();

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		GameRegistry.registerBlock(generatorBlock, "blockGenerator");
	}

	@EventHandler
	public void load(FMLInitializationEvent event) {
		proxy.registerRenderers();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {

	}
}