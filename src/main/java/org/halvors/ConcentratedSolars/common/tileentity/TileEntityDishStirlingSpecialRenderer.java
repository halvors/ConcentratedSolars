package org.halvors.ConcentratedSolars.common.tileentity;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.halvors.ConcentratedSolars.Reference;
import org.lwjgl.opengl.GL11;

public class TileEntityDishStirlingSpecialRenderer extends TileEntitySpecialRenderer {
	private IModelCustom model;

	public TileEntityDishStirlingSpecialRenderer() {
		model = AdvancedModelLoader.loadModel(new ResourceLocation(Reference.PREFIX + "models/thruster.obj"));
	}

	@Override
	public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float partialTick) {
		// OpenGL stuff
		GL11.glPushMatrix();
		GL11.glTranslated(x, y, z);
		
		// Bind the texture and render the model
		// bindTexture(texture);
		model.renderAll();

		// OpenGL stuff to put everything back
		GL11.glPopMatrix();
	}
}