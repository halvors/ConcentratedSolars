package org.halvors.ConcentratedSolars.items;

import nova.core.item.Item;
import nova.core.render.texture.ItemTexture;
import org.halvors.ConcentratedSolars.ConcentratedSolars;

import java.util.Optional;

/**
 * This is the mirror item.
 *
 * @halvors
 */
public class ItemMirror extends Item {
    public ItemMirror() {
        add(ConcentratedSolars.category);
    }

    @Override
    public Optional<ItemTexture> getTexture() {
        return Optional.of(ConcentratedSolars.itemMirrorTexture);
    }

    @Override
    public int getMaxCount() {
        return 16;
    }

    @Override
    public String getID() {
        return "itemMirror";
    }
}
