package com.gildedtros.quality;

import com.gildedtros.Item;

/**
 * Basic contract for a quality item.
 * A quality item is a wrapper around an 'item' to make sure the
 * quality is correctly tracked over the days.
 */
public interface QualityItem {

    void updateQuality();

    int getDegradationFactor();

    /**
     * Creates an appropriate quality item based on input
     * @param item  an item to track the quality of
     * @return  a quality item wrapper for the specified item
     */
    static QualityItem of(Item item) {
        return QualityItemFactory.create(item);
    }

}
