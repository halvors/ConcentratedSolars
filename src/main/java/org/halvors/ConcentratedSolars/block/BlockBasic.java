package org.halvors.ConcentratedSolars.block;

import nova.core.block.Block;
import nova.core.component.renderer.ItemRenderer;
import org.halvors.ConcentratedSolars.ConcentratedSolars;

/**
 * This a basic block.
 * @author halvors
 */
public class BlockBasic extends Block {
    public BlockBasic() {
        add(new ItemRenderer(this));
        add(ConcentratedSolars.category);
    }

    @Override
    public String getID() {
        return null;
    }
}
