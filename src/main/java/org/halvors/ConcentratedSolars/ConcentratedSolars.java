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
import nova.core.render.texture.ItemTexture;
import org.halvors.ConcentratedSolars.block.BlockSolarPanel;
import org.halvors.ConcentratedSolars.gui.GuiBasic;
import org.halvors.ConcentratedSolars.gui.GuiSolarPanel;
import org.halvors.ConcentratedSolars.items.ItemMirror;

import java.util.ArrayList;
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

	// Items
	public static ItemFactory itemSolarPanel;
	public static ItemFactory itemMirror;

	// Textures
	public static BlockTexture solarPanelTexture;
	public static BlockTexture solarPanelTextureEdge;

	public static List<BlockTexture> solarPanelTextures = new ArrayList<>();

	public static ItemTexture itemMirrorTexture;

	// GUIs
	public static GuiFactory guiBasic;
	public static GuiFactory guiSolarPanel;

	// Category
	public static Category category = new Category("categoryConcentratedSolars");

	// Managers
	private final BlockManager blockManager;
	private final ItemManager itemManager;
	private final RenderManager renderManager;
	public final GuiManager guiManager;

	public ConcentratedSolars(BlockManager blockManager, ItemManager itemManager, RenderManager renderManager, GuiManager guiManager) {
		instance = this;

		this.blockManager = blockManager;
		this.itemManager = itemManager;
		this.renderManager = renderManager;
		this.guiManager = guiManager;
	}

	@Override
	public void preInit() {
		addBlocks();
		addItems();
		addTextures();
		addRecipes();
		addGUIs();
	}

	@Override
	public void init() {

	}

	@Override
	public void postInit() {

	}

	/**
	 * Returns the instance of this mod.
	 */
	public static ConcentratedSolars getInstance() {
		return instance;
	}

	public void addBlocks() {
		// Create blocks.
		blockSolarPanel = blockManager.register(BlockSolarPanel.class);
	}

	public void addItems() {
		// Create items.
		itemSolarPanel = itemManager.getItemFromBlock(blockSolarPanel);
		itemMirror = itemManager.register(ItemMirror.class);

		// Register items in the dictionary.
		// TODO: Is this the right way to do this?
		Game.itemDictionary().add("mirror", itemMirror.getID());
		Game.itemDictionary().add("solarPanel", itemSolarPanel.getID());
	}

	public void addTextures() {
		// Create textures.
		solarPanelTexture = renderManager.registerTexture(new BlockTexture(Reference.ID, "blockSolarPanel_top"));
		solarPanelTextureEdge = renderManager.registerTexture(new BlockTexture(Reference.ID, "blockSolarPanel_side"));

		solarPanelTextures.add(renderManager.registerTexture(new BlockTexture(Reference.ID, "blockSolarPanel_top")));
		solarPanelTextures.add(renderManager.registerTexture(new BlockTexture(Reference.ID, "blockSolarPanel_side")));
		solarPanelTextures.add(renderManager.registerTexture(new BlockTexture(Reference.ID, "blockSolarPanel_bottom")));

		itemMirrorTexture = renderManager.registerTexture(new ItemTexture(Reference.ID, "itemMirror"));
	}

	public void addRecipes() {
		// Create recipes.
		ItemIngredient glassPaneIngredient = ItemIngredient.forDictionary("paneGlass");
		ItemIngredient ironIngotIngredient = ItemIngredient.forDictionary("ingotIron");
		ItemIngredient goldIngotIngredient = ItemIngredient.forDictionary("ingotGold");
		ItemIngredient dustRedstoneIngredient = ItemIngredient.forDictionary("dustRedstone");

		// Register recipes.
		Game.recipes().addRecipe(new ShapedCraftingRecipe(itemSolarPanel.makeItem(), "AAA-BCB-BDB",
				glassPaneIngredient,
				ironIngotIngredient,
				goldIngotIngredient,
				dustRedstoneIngredient));

		Game.recipes().addRecipe(new ShapedCraftingRecipe(itemMirror.makeItem(), "AAA-ABA-AAA",
				glassPaneIngredient,
				ironIngotIngredient));
	}

	public void addGUIs() {
		// Create GUIs.
		guiBasic = guiManager.register(() -> new GuiBasic());
		guiSolarPanel = guiManager.register(() -> new GuiSolarPanel());
	}
}