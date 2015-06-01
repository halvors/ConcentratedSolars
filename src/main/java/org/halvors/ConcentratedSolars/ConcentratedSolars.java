package org.halvors.ConcentratedSolars;

import nova.core.block.BlockFactory;
import nova.core.block.BlockManager;
import nova.core.entity.EntityManager;
import nova.core.game.Game;
import nova.core.gui.factory.GuiManager;
import nova.core.item.ItemFactory;
import nova.core.item.ItemManager;
import nova.core.loader.Loadable;
import nova.core.loader.NovaMod;
import nova.core.nativewrapper.NativeManager;
import nova.core.recipes.crafting.ItemIngredient;
import nova.core.recipes.crafting.ShapedCraftingRecipe;
import nova.core.render.RenderManager;
import nova.core.render.texture.BlockTexture;
import org.halvors.ConcentratedSolars.block.BlockSolarPanel;

/**
 * ConcentratedSolars is a NOVA mod that adds solar power sources to the game.
 *
 * @author halvors
 */
@NovaMod(id = Reference.ID, name = Reference.NAME, version = Reference.VERSION, novaVersion = Reference.NOVA_VERSION)
public class ConcentratedSolars implements Loadable {
	// Blocks
	public static BlockFactory blockSolarPanel;

	// Textures
	public static BlockTexture solarPanelTexture;

	// Items
	public static ItemFactory itemSolarPanel;

	// Creative tab
	//public static CreativeTabConcentratedSolars tabConcentratedSolars = new CreativeTabConcentratedSolars();

	// Managers
	private final BlockManager blockManager;
	private final ItemManager itemManager;
	private final RenderManager renderManager;
	private final GuiManager guiManager;
	private final EntityManager entityManager;
	private final NativeManager nativeManager;

	public ConcentratedSolars(BlockManager blockManager, ItemManager itemManager, RenderManager renderManager, GuiManager guiManager, EntityManager entityManager, NativeManager nativeManager) {
		this.blockManager = blockManager;
		this.itemManager = itemManager;
		this.renderManager = renderManager;
		this.guiManager = guiManager;
		this.entityManager = entityManager;
		this.nativeManager = nativeManager;
	}

	@Override
	public void preInit() {
		addBlocks();
		addTextures();
		addTileEntities();
		addItems();
		addRecipes();
		addGuis();
	}

	public void addBlocks() {
		// Create blocks.
		blockSolarPanel = blockManager.register(BlockSolarPanel.class);
	}

	public void addTextures() {
		// Create textures.
		solarPanelTexture = renderManager.registerTexture(new BlockTexture(Reference.ID, "solarPanel"));
	}

	public void addTileEntities() {
		// Register tile entities.
	}

	public void addItems() {
		// Create items.
		itemSolarPanel = itemManager.getItemFromBlock(blockSolarPanel);
	}

	public void addRecipes() {
		// Create recipies.
		ItemIngredient ironIngotIngredient = ItemIngredient.forDictionary("ingotIron");
		ItemIngredient goldIngotIngredient = ItemIngredient.forDictionary("ingotGold");
		ItemIngredient dustRedstoneIngredient = ItemIngredient.forDictionary("dustRedstone");

		// Register recipes.
		Game.recipeManager().addRecipe(new ShapedCraftingRecipe(itemSolarPanel.makeItem(), "AAA-BBB-CBC-", goldIngotIngredient, dustRedstoneIngredient, ironIngotIngredient));
	}

	public void addGuis() {
		// Register guis.
		guiManager.register(new GuiSolarPanel());
	}
}