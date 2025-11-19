package com.gildedtros.quality;

import com.gildedtros.Item;

public class BackstagePass extends NormalQualityItem {

    public BackstagePass(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        if (getItem().sellIn <= 0) {
            getItem().sellIn--;
            getItem().quality = 0; // zero after conference
        } else {
            super.updateQuality();
        }
    }

    @Override
    public int getDegradationFactor() {
        if (getItem().sellIn <= 5) {
            return -3;
        }
        if (getItem().sellIn <= 10) {
            return -2;
        }
        return -1;
    }
}
