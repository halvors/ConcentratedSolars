package org.halvors.ConcentratedSolars.items;

import nova.core.component.Category;
import nova.core.item.Item;
import org.halvors.ConcentratedSolars.ConcentratedSolars;

/**
 * This a basic item.
 *
 * @author halvors
 */
public class ItemBasic extends Item {
    protected ConcentratedSolars game = ConcentratedSolars.getInstance();

    protected Category category = add(game.category);

    public ItemBasic() {

    }

    @Override
    public String getID() {
        return null;
    }
}
