package com.gildedtros.quality;

/**
 * Basic contract for a quality item.
 * A quality item is a wrapper around an 'item' to make sure the
 * quality is correctly tracked over the days.
 */
public interface QualityItem {

    void updateQuality();
    int getDegradationFactor();

}
