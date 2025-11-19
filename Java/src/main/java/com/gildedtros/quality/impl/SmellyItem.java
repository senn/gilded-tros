package com.gildedtros.quality.impl;

import com.gildedtros.Item;

public class SmellyItem extends NormalQualityItem {

    public SmellyItem(Item item) {
        super(item);
    }

    @Override
    public int getDegradationFactor() {
        return super.getDegradationFactor() * 2;
    }
}
