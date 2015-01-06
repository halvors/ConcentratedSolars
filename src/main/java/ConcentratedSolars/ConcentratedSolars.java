package concentratedsolars;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid="ConcentratedSolars", name="ConcentratedSolars", version="0.0.1")
public class ConcentratedSolars {
	// The instance of your mod that Forge uses.
	@Instance(value = "ConcentratedSolars")
	public static ConcentratedSolars instance;
   
	// Says where the client and server 'proxy' code is loaded.
	@SidedProxy(clientSide="concentratedsolars.client.ClientProxy", serverSide="concentratedsolars.CommonProxy")
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
			// Stub Method
	}
   
	@EventHandler
	public void load(FMLInitializationEvent event) {
			proxy.registerRenderers();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
			// Stub Method
	}
}