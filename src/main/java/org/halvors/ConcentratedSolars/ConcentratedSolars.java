package org.halvors.ConcentratedSolars;

import nova.core.block.BlockFactory;
import nova.core.block.BlockManager;
import nova.core.component.Category;
import nova.core.entity.EntityManager;
import nova.core.game.Game;
import nova.core.gui.factory.GuiFactory;
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
import org.halvors.ConcentratedSolars.gui.GuiSolarPanel;

import java.util.List;

/**
 * ConcentratedSolars is a NOVA mod that adds solar power sources to the game.
 *
 * @author halvors
 */
@NovaMod(id = Reference.ID, name = Reference.NAME, version = Reference.VERSION, novaVersion = Reference.NOVA_VERSION)
public class ConcentratedSolars implements Loadable {
	private static ConcentratedSolars instance;

	// Blocks
	public static BlockFactory blockSolarPanel;

	// Textures
	public static List<BlockTexture> solarPanelTextures;

	// Items
	public static ItemFactory itemSolarPanel;

	// GUIs
	public static GuiFactory guiSolarPanel;

	// Creative tab
	public static Category category = new Category("categoryConcentratedSolars");

	//public static CreativeTabConcentratedSolars tabConcentratedSolars = new CreativeTabConcentratedSolars();

	// Managers
	private final BlockManager blockManager;
	private final ItemManager itemManager;
	private final RenderManager renderManager;
	public final GuiManager guiManager;
	private final EntityManager entityManager;
	private final NativeManager nativeManager;

	public ConcentratedSolars(BlockManager blockManager, ItemManager itemManager, RenderManager renderManager, GuiManager guiManager, EntityManager entityManager, NativeManager nativeManager) {
		ConcentratedSolars.instance = this;

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
		addGUIs();
	}

	public static ConcentratedSolars getInstance() {
		return instance;
	}

	public void addBlocks() {
		// Create blocks.
		blockSolarPanel = blockManager.register(BlockSolarPanel.class);
	}

	public void addTextures() {
		// Create textures.
		solarPanelTextures.add(renderManager.registerTexture(new BlockTexture(Reference.ID, "blockSolarPanel_top")));
		solarPanelTextures.add(renderManager.registerTexture(new BlockTexture(Reference.ID, "blockSolarPanel_side")));
		solarPanelTextures.add(renderManager.registerTexture(new BlockTexture(Reference.ID, "blockSolarPanel_down")));
	}

	public void addTileEntities() {
		// Register tile entities.
	}

	public void addItems() {
		// Create items.
		itemSolarPanel = itemManager.getItemFromBlock(blockSolarPanel);
	}

	public void addRecipes() {
		// Create recipes.
		ItemIngredient ironIngotIngredient = ItemIngredient.forDictionary("ingotIron");
		ItemIngredient goldIngotIngredient = ItemIngredient.forDictionary("ingotGold");
		ItemIngredient dustRedstoneIngredient = ItemIngredient.forDictionary("dustRedstone");

		// Register recipes.
		Game.recipes().addRecipe(new ShapedCraftingRecipe(itemSolarPanel.makeItem(), "AAA-BBB-CBC", goldIngotIngredient, dustRedstoneIngredient, ironIngotIngredient));
	}

	public void addGUIs() {
		// Create GUIs.
		guiSolarPanel = guiManager.register(() -> new GuiSolarPanel());
	}
}