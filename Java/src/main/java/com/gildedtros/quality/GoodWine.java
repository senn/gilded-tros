package com.gildedtros.quality;

import com.gildedtros.Item;

public class GoodWine extends NormalQualityItem {

    public GoodWine(Item item) {
        super(item);
    }

    @Override
    public int getDegradationFactor() {
        return -super.getDegradationFactor();
    }
}
