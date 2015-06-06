package org.halvors.ConcentratedSolars.block;

import nova.core.block.Block;
import nova.core.component.Category;
import nova.core.component.misc.Collider;
import nova.core.component.renderer.ItemRenderer;
import org.halvors.ConcentratedSolars.ConcentratedSolars;

/**
 * This a basic block.
 *
 * @author halvors
 */
public class BlockBasic extends Block {
    protected final ConcentratedSolars game = ConcentratedSolars.getInstance();

    protected Collider collider = add(new Collider());
    protected ItemRenderer itemRenderer = add(new ItemRenderer(this));
    protected Category category = add(ConcentratedSolars.category);

    public BlockBasic() {

    }

    @Override
    public String getID() {
        return null;
    }
}
