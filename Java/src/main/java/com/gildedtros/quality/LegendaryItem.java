package com.gildedtros.quality;

import com.gildedtros.Item;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LegendaryItem implements QualityItem {

    final Item item;

    @Override
    public void updateQuality() {
        // Do nothing
    }

    @Override
    public int getDegradationFactor() {
        throw new UnsupportedOperationException("Legendary items don't degrade");
    }
}
