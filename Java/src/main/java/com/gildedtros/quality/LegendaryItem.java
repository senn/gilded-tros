package com.gildedtros.quality;

import com.gildedtros.Item;

public class LegendaryItem implements QualityItem {

    private static final int LEGENDARY_QUALITY = 80;

    final Item item;

    public LegendaryItem(Item item) {
        this.item = item;
        this.item.quality = LEGENDARY_QUALITY; // Always 80
    }

    @Override
    public void updateQuality() {
        // Do nothing
    }

    @Override
    public int getDegradationFactor() {
        throw new UnsupportedOperationException("Legendary items don't degrade");
    }
}
